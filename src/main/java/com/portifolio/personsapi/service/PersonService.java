package com.portifolio.personsapi.service;

import com.portifolio.personsapi.dto.response.MessageResponseDTO;
import com.portifolio.personsapi.entity.Person;
import com.portifolio.personsapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonService {
    private PersonRepository personRepository; //Pegando a interface com JPA

    //Fazer injeção do objeto dentro de um construtor, a vantagem é para fazer testes unitários
    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }


    public MessageResponseDTO createPerson(Person person){
        Person savedPerson = personRepository.save(person); //Save para salvar o objeto no banco
        return MessageResponseDTO
                .builder()
                .message("Created person with ID" + savedPerson.getId())
                .build();//Assim você monta a mensagem de forma correta
    }
}
