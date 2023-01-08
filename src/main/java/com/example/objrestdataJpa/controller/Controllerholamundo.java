package com.example.objrestdataJpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllerholamundo {
    @GetMapping("/hola")
 public  String holamundo(){

     return "hola ingreible provando excelente plugin !!!";
 }
}
