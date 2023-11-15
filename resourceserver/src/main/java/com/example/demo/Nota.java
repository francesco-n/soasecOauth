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
    private boolean pubblica;


    public Nota() {
    }
  
    public Nota (int id, String titolo, String contenuto, String autore, boolean pubblica) {
        this.id = id;
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.autore = autore;
        this.pubblica = pubblica;
    }
    
    public int getId() {
        return id;
    }
  
    public String getTitolo() {
        return titolo;
    }
  
    public String getContenuto() {
        return contenuto;
    }
  
    public String getAutore() {
        return autore;
    }
    
    public boolean getPubblica() {
    	return pubblica;
    }

    public void setId(int id) {
        this.id = id;
    }
  
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
  
    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }
  
    public void setAutore(String autore) {
        this.autore = autore;
    }
    
    public void setisPublic(boolean pubblica) {
    	this.pubblica = pubblica;
    }
    
}
