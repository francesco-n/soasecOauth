package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlocco_note extends JpaRepository<Nota, Integer>{
    List<Nota> findByautore(String autore);
}
