package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class NotaService implements INotaService{


    @Autowired
    private IBlocco_note blocco_note;

        @Override
        public Iterable<Nota> getAll() {
        	String NomeUtente = SecurityContextHolder.getContext().getAuthentication().getName();
            
			return blocco_note.findByautore(NomeUtente);
        }
        
        @Override
        public Nota create(Nota nota) {
        	return blocco_note.save(nota);
        }
    
}
