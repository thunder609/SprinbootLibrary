package com.example.objrestdataJpa;

import com.example.objrestdataJpa.entities.Libro;
import com.example.objrestdataJpa.repository.LibroRepositoy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class
ObjRestdataJpaApplication {

	public static void main(String[] args) {

		   ApplicationContext context=   SpringApplication.run(ObjRestdataJpaApplication.class, args);
		     LibroRepositoy rep= context.getBean(LibroRepositoy.class);
			 //Crud
		// Crear Libro
		    Libro l1 = new Libro(null,"Programacion c++","osaldo",100,10.0,true);
		Libro l2 = new Libro(null,"Programacion c++","osaldo",100,10.0,true);
		// almacenar un libro
		rep.save(l1);

		for (Libro libros : rep.findAll()) {
			System.out.println(libros.getId());
			System.out.println(libros.getAutor());
		}
		System.out.println("hola mundo");

		}


	}


