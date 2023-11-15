package com.example.demo;

import java.util.Optional;

public interface INotaService {
	
	public Iterable<Nota> getPublicNotes();
    
    public Iterable<Nota> getAll();

	public Nota create(Nota nota);
	
	public Optional<Nota> getById(int id);

	Optional<Nota> update(int id, Nota nota);

	boolean delete(int id);

}
