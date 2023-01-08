package com.example.objrestdataJpa.controller;

import com.example.objrestdataJpa.entities.Libro;
import com.example.objrestdataJpa.repository.LibroRepositoy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibroController {
    private LibroRepositoy repository;

    public LibroController(LibroRepositoy repository) {
        this.repository = repository;
    }

    //Entidad boot
 @GetMapping("api/libros")
   public List<Libro> findAll(){
       //recuperar los libros de base de datos
        return repository.findAll();
   }
    //Buscar un solo libro por su id
    /*public  Libro  findByid(Long id){

    }*/

}
