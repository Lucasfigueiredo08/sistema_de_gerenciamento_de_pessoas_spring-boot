package com.digitalinnovation.one.PersonAPI_bootcamp.controller;

import com.digitalinnovation.one.PersonAPI_bootcamp.dto.response.MessageResponseDTO;
import com.digitalinnovation.one.PersonAPI_bootcamp.entity.Person;
import com.digitalinnovation.one.PersonAPI_bootcamp.repository.PersonRepository;
import com.digitalinnovation.one.PersonAPI_bootcamp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson( Person person){
    return personService.createPerson(person);
    }
}
