package com.portifolio.personsapi.service;

import com.portifolio.personsapi.dto.request.PersonDTO;
import com.portifolio.personsapi.dto.response.MessageResponseDTO;
import com.portifolio.personsapi.entity.Person;
import com.portifolio.personsapi.repository.PersonRepository;
import com.portifolio.personsapi.utils.PersonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.MessageDigest;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    //Aqui para rodar o teste
    @Test
    void TestGivenPersonDTOThenReturnSavedMessage(){

        //Pegando os objetos fakes para fazer o teste
        PersonDTO personDTO = PersonUtils.createFakeDTO();
        Person expectedSavedPerson = PersonUtils.createFakeEntity();

        //Aqui fazendo o teste
        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO exprectedMessageResponse = createExpectedMessageResponse(expectedSavedPerson.getId());

        MessageResponseDTO sucessMessage = personService.createPerson(personDTO);

        //Validação se deu certo
        Assertions.assertEquals(sucessMessage, exprectedMessageResponse);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO.builder()
                .message("Created person with ID "+ id)
                .build();
    }


}
