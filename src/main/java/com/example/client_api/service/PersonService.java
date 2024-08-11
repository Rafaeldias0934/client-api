package com.example.client_api.service;

import com.example.client_api.dtos.PersonRecordDto;
import com.example.client_api.models.PersonModel;
import com.example.client_api.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public PersonModel getOnePerson(Long id) {
        Optional<PersonModel> getOnePersonOpt = personRepository.findById(id);
        if (getOnePersonOpt.isEmpty()) {
            return null;
        }
        return getOnePersonOpt.get();
    }

    public PersonModel updatePerson(Long id, PersonRecordDto  personRecordDto) {
        Optional<PersonModel> updatePersonOpt = personRepository.findById(id);
        if (updatePersonOpt.isEmpty()) {
            return null;
        }
        PersonModel personModel = updatePersonOpt.get();
        BeanUtils.copyProperties(personRecordDto,personModel);
        return personRepository.save(personModel);
    }
}
