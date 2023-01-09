package com.example.objrestdataJpa.controller;

import com.example.objrestdataJpa.entities.Libro;
import com.example.objrestdataJpa.repository.LibroRepositoy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



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
    @GetMapping("/api/libro/{id}")
    //colocar el mismo nombre al parametro
    public ResponseEntity<Libro> findByid(@PathVariable("id")  Long id){

        Optional <Libro> opt =repository.findById(id);
        //opcion2
       // return opt.orElse(null);
        //opcion1
       if(opt.isPresent())
            return   ResponseEntity.ok(opt.get());
        else
            return  ResponseEntity.notFound().build();
    }
    // cear libro
    @PostMapping("/api/libros")
    public Libro craerLibro(@RequestBody Libro libro , @RequestHeader HttpHeaders headers){
        //guardar libro recibido en parametros desde la base datos
        System.out.println(headers.get("User-Agent"));
       return  repository.save(libro);

    }

}
