package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Nota {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private int id;
    private String titolo;
    private String contenuto;
    private String autore;


    public Nota() {
    }
  
    public Nota (int id, String titolo, String contenuto, String autore) {
        this.id = id;
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.autore = autore;
    }

    public int getId() {
        return id;
    }
  
    public String getTitolo() {
        return titolo;
    }
  
    public String getContento() {
        return contenuto;
    }
  
    public String getAutore() {
        return autore;
    }

    public void setId(int id) {
        this.id = id;
    }
  
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
  
    public void setContento(String contenuto) {
        this.contenuto = contenuto;
    }
  
    public void setAutore(String autore) {
        this.autore = autore;
    }
    
}
