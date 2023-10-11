package com.example.demo;

import java.util.Optional;

public interface INotaService {
    
    public Iterable<Nota> getAll();

	public Nota create(Nota nota);
	
	public Optional<Nota> getById(int id);

}
