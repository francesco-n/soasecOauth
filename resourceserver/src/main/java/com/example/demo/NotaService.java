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
			
			return bloccoNote.findById(id);
		}
		
		@Override
		public Optional<Nota> update(int id, Nota nota) {
			Optional<Nota> notaTrovata = bloccoNote.findById(id);
			
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
			Optional<Nota> notaTrovata = bloccoNote.findById(id);
			
			if (notaTrovata.isEmpty()) {
				return false;
			}
			
			bloccoNote.deleteById(id);
			return true;
		}
    
}
