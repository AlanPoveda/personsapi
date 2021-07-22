package com.portifolio.personsapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Controlador que vai ser acessado
@RestController
@RequestMapping("/api/v1/people") //Recurso, bem esplicito
public class PersonController {

    //Mapeando o GET para ser acessado no browser
    @GetMapping
    public String getBook(){
        return "Hola aplicação bunita";
    }
}
