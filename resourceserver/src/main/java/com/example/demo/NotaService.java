package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaService implements INotaService{


    @Autowired
    private IBlocco_note blocco_note;

        @Override
        public Iterable<Nota> getAll() {
            return blocco_note.findAll();
        }

    
}
