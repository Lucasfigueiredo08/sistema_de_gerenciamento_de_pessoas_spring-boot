package com.digitalinnovation.one.PersonAPI_bootcamp.repository;

import com.digitalinnovation.one.PersonAPI_bootcamp.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
