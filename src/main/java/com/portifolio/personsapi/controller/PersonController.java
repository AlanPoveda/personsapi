package com.portifolio.personsapi.controller;

import com.portifolio.personsapi.dto.request.PersonDTO;
import com.portifolio.personsapi.dto.response.MessageResponseDTO;
import com.portifolio.personsapi.entity.Person;
import com.portifolio.personsapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//Controlador que vai ser acessado
@RestController
@RequestMapping("/api/v1/person") //Recurso, bem esplicito
public class PersonController {
    //Create por isso o método POST-------------------------------------------------------------------------------------
    //Aqui usei o PersonService, é lá que acontece a contrução
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Codigo create, http, feito pelo própro spring
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    //GET---------------------------------------------------------------------------------------------------------------

    @GetMapping
    public List<Person> listAll(){
        return personService.listAll();
    }
}
