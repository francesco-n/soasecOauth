package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticlesController {

    @Autowired
    private INotaService notaservice;

    public ArticlesController() {
    }

    @RequestMapping("/articles")
    public Iterable<Nota> getAll() {
        return notaservice.getAll();
    }
    
    @PostMapping("/articles")
    public Nota create(@RequestBody Nota nota) {
    	return notaservice.create(nota);
    }
}

