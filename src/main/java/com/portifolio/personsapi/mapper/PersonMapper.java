package com.portifolio.personsapi.mapper;


import com.portifolio.personsapi.dto.request.PersonDTO;
import com.portifolio.personsapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    //converção toModel, é obrigatório

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

    Person toDTO(Person person);
}
