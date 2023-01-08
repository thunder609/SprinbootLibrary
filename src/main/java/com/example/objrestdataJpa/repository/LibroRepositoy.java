package com.example.objrestdataJpa.repository;

import com.example.objrestdataJpa.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositoy extends JpaRepository<Libro,Long> {
}
