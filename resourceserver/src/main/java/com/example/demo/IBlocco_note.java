package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlocco_note extends JpaRepository<Nota, Integer>{
    List<Nota> findByautore(String autore);
    Optional<Nota> findByIdAndAutore(int id, String autore);
    List<Nota> findByPubblicaTrue();
}
