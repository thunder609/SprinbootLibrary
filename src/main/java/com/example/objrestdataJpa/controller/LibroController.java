package com.example.objrestdataJpa.controller;

import com.example.objrestdataJpa.entities.Libro;
import com.example.objrestdataJpa.repository.LibroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactoryFriend;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
public class LibroController {
    private LibroRepository repository;
    private final Logger log = LoggerFactory.getLogger(LibroController.class);

    public LibroController(LibroRepository repository) {
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
    // cear libro en la base datos
    @PostMapping("/api/libro")
    public ResponseEntity<Libro> craerLibro(@RequestBody Libro libro , @RequestHeader HttpHeaders headers){
        //guardar libro recibido en parametros desde la base datos
      //  System.out.println(headers.get("User-Agent"));
      // return  repository.save(libro);
        //antes
        System.out.println(headers.get("User-Agent"));
        if(libro.getId() != null) {
            log.warn("create to a libro with id");
            System.out.println("try to create a libro with id");
            return ResponseEntity.badRequest().build();
        }
        Libro  result =repository.save(libro);
        return  ResponseEntity.ok(result);
    }
    //Actualizar libros
    @PutMapping("/api/libro")
    public ResponseEntity<Libro> actualizar(@RequestBody Libro libro){
        if(libro.getId()==null){
            log.warn("try to create a libro with id");
            return ResponseEntity.badRequest().build();
        }
        if(!repository.existsById(libro.getId())){
            log.warn("try to update a libro with id ");
           return  ResponseEntity.notFound().build();
        }
        Libro result = repository.save(libro);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/api/libro/{id}")
    public ResponseEntity<Libro>  delete (@PathVariable("id")  Long id){
        if(!repository.existsById(id)){
            log.warn("try to Delete a libro with id ");
            return  ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
//borrar todos los libros
    @DeleteMapping("/api/libros")
    public ResponseEntity<Libro> deleteall() {
        log.info("borrando todos los datos");
        repository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
