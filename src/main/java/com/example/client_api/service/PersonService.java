package com.example.client_api.service;

import com.example.client_api.dtos.PersonRecordDto;
import com.example.client_api.models.PersonModel;
import com.example.client_api.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public PersonModel savePerson(PersonRecordDto personRecordDto) {
        PersonModel personModel = new PersonModel();
        BeanUtils.copyProperties(personRecordDto, personModel);
        return personRepository.save(personModel);
    }

    public List<PersonModel> getAllPerson() {
        List<PersonModel> personModelList = personRepository.findAll();
        if (!personModelList.isEmpty()) {
            for (PersonModel person: personModelList) {
                 Long id = person.getIdPerson();
            }
        }
        return personModelList;
    }
}
