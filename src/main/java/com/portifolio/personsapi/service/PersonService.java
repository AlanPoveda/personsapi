package com.portifolio.personsapi.service;

import com.portifolio.personsapi.dto.request.PersonDTO;
import com.portifolio.personsapi.dto.response.MessageResponseDTO;
import com.portifolio.personsapi.entity.Person;
import com.portifolio.personsapi.exception.PersonNotFoundException;
import com.portifolio.personsapi.mapper.PersonMapper;
import com.portifolio.personsapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
    private PersonRepository personRepository; //Pegando a interface com JPA

    private final PersonMapper personMapper = PersonMapper.INSTANCE; // Pegando o Mapper

    //Create ----------------------------------------------------------------------------------------------------------
    public MessageResponseDTO createPerson(PersonDTO personDTO){
        //Pegando as informações do Mapper
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave); //Save para salvar o objeto no banco
        return createMessageResponse(savedPerson.getId(), "Created person with ID");//Assim você monta a mensagem de forma correta
    }

    //GET ALL ----------------------------------------------------------------------------------------------------------
    public List<Person> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    //GET BY ID --------------------------------------------------------------------------------------------------------
    public Person findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);
        return personMapper.toDTO(person);
    }

    //DELETE -----------------------------------------------------------------------------------------------------------
    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    //UPDATE------------------------------------------------------------------------------------------------------------

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        //Pegando as informações do Mapper
        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatePerson = personRepository.save(personToUpdate); //Save para salvar o objeto no banco
        return createMessageResponse(updatePerson.getId(), "Updated person with ID");//Assim você monta a mensagem de forma correta
    }

    //MÉTODOS PRIVADOS ABAIXO DOS PÚBLICOS -----------------------------------------------------------------------------

    //Message Response
    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

    //Criando uma verificação para ser usada no método GET e do DELETE para ver se existe no banco essa pessoa
    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(()->new PersonNotFoundException(id));

    }

}
