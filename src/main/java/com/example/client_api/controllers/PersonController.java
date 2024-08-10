package com.example.client_api.controllers;

import com.example.client_api.dtos.PersonRecordDto;
import com.example.client_api.models.PersonModel;
import com.example.client_api.repositories.PersonRepository;
import com.example.client_api.service.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/people")
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<PersonModel> savePerson(@RequestBody @Valid PersonRecordDto personRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.savePerson(personRecordDto));
    }

    @GetMapping
    public ResponseEntity<List<PersonModel>> getAllPerson() {
        return ResponseEntity.status(HttpStatus.OK).body(personService.getAllPerson());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePerson(@PathVariable(value = "id") Long id) {
        PersonModel personModel = personService.getOnePerson(id);
        if (personModel == null) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person model not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(personModel);
    }


}
