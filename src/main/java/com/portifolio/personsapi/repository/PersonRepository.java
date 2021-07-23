package com.portifolio.personsapi.repository;

import com.portifolio.personsapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
