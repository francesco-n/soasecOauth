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
    
}
