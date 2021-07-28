package com.portifolio.personsapi.controller;

import com.portifolio.personsapi.dto.request.PersonDTO;
import com.portifolio.personsapi.dto.response.MessageResponseDTO;
import com.portifolio.personsapi.entity.Person;
import com.portifolio.personsapi.exception.PersonNotFoundException;
import com.portifolio.personsapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//Controlador que vai ser acessado
@RestController
@RequestMapping("/api/v1/person") //Recurso, bem esplicito
@AllArgsConstructor(onConstructor = @__(@Autowired)) // Para não precisar do Autowired
public class PersonController {
    //Create por isso o método POST-------------------------------------------------------------------------------------
    //Aqui usei o PersonService, é lá que acontece a contrução
    private PersonService personService;

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

    //GET ID------------------------------------------------------------------------------------------------------------

    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    //DELETE -----------------------------------------------------------------------------------------------------------

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }

    //UPDATE------------------------------------------------------------------------------------------------------------
    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updateById(id, personDTO);
    }



}
