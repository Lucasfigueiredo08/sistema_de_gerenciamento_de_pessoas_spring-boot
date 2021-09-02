package com.digitalinnovation.one.PersonAPI_bootcamp.service;

import com.digitalinnovation.one.PersonAPI_bootcamp.dto.request.PersonDTO;
import com.digitalinnovation.one.PersonAPI_bootcamp.dto.response.MessageResponseDTO;
import com.digitalinnovation.one.PersonAPI_bootcamp.entity.Person;
import com.digitalinnovation.one.PersonAPI_bootcamp.mapper.PersonMapper;
import com.digitalinnovation.one.PersonAPI_bootcamp.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.digitalinnovation.one.PersonAPI_bootcamp.utils.PersonUtils.createFakeDTO;
import static com.digitalinnovation.one.PersonAPI_bootcamp.utils.PersonUtils.createFakeEntity;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    @Test
    void TestGivenPersonDTOThenReturnSavedMessage(){
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId());
        MessageResponseDTO successMessage = personService.createPerson(personDTO);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long savedPersonId) {
        return MessageResponseDTO.builder()
                .message("Person successfully created with ID " + savedPersonId)
                .build();
    }
}
