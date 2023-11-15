package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class NotaService implements INotaService{


    @Autowired
    private IBlocco_note bloccoNote;
    
    	@Override
    	public Iterable<Nota> getPublicNotes() {
    		return bloccoNote.findByPubblicaTrue();
    	}
        @Override
        public Iterable<Nota> getAll() {
        	String NomeUtente = SecurityContextHolder.getContext().getAuthentication().getName();
			return bloccoNote.findByautore(NomeUtente);
        }
        
        @Override
        public Nota create(Nota nota) {
        	String NomeUtente = SecurityContextHolder.getContext().getAuthentication().getName();
        	nota.setAutore(NomeUtente);
        	return bloccoNote.save(nota);
        }

		@Override
		public Optional<Nota> getById(int id) {
			String NomeUtente = SecurityContextHolder.getContext().getAuthentication().getName();
			Optional<Nota> notaTrovata = bloccoNote.findByIdAndAutore(id,NomeUtente);
			
			if (notaTrovata.isEmpty()){
				return Optional.empty();
			}
			return notaTrovata;
		}
		
		@Override
		public Optional<Nota> update(int id, Nota nota) {
			String NomeUtente = SecurityContextHolder.getContext().getAuthentication().getName();
			Optional<Nota> notaTrovata = bloccoNote.findByIdAndAutore(id,NomeUtente);
			
			
			if (notaTrovata.isEmpty()) {
				return Optional.empty();
			}
			
			notaTrovata.get().setTitolo(nota.getTitolo());
			notaTrovata.get().setContenuto(nota.getContenuto());
			bloccoNote.save(notaTrovata.get());
			return notaTrovata;
		}
		
		@Override
		public boolean delete(int id) {
			String NomeUtente = SecurityContextHolder.getContext().getAuthentication().getName();
			Optional<Nota> notaTrovata = bloccoNote.findByIdAndAutore(id,NomeUtente);
			
			
			if (notaTrovata.isEmpty()) {
				return false;
			}
			
			bloccoNote.deleteById(id);
			return true;
		}
    
}
