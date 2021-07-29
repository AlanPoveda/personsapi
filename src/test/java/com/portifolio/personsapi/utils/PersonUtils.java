package com.portifolio.personsapi.utils;

import com.portifolio.personsapi.dto.request.PersonDTO;
import com.portifolio.personsapi.entity.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    private static final String FIRST_NAME = "Alan";
    private static final String LAST_NAME = "Poveda";
    private static final String CPF_NUMBER = "23606225873";
    private static final long PERSON_ID = 1l;
    public static final LocalDate BIRTH_DATE = LocalDate.of(1995,10,14);


    public static PersonDTO createFakeDTO(){
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("14-10-1995")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity(){
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .phones(Collections.singletonList((PhoneUtils.createFakeEntity())))
                .build();
    }
}
