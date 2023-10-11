package com.example.demo;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ArticlesController {

    @Autowired
    private INotaService notaservice;

    public ArticlesController() {
    }

    @GetMapping("/articles")
    public Iterable<Nota> getAll() {
        return notaservice.getAll();
    }
    
    @GetMapping("/articles/{id}")
    public Nota getById(@PathVariable int id) {
    	Optional<Nota> nota = notaservice.getById(id);
    	
    	if (nota.isEmpty()) {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "nota non trovata");
    	}
    	return nota.get();
    }
    
    @PostMapping("/articles")
    public Nota create(@RequestBody Nota nota) {
    	return notaservice.create(nota);
    }
}

