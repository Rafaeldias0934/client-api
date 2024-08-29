package com.example.client_api.service;

import com.example.client_api.dtos.EmployeeRecordDto;
import com.example.client_api.models.ClientModel;
import com.example.client_api.models.EmployeeModel;
import com.example.client_api.models.PersonModel;
import com.example.client_api.repositories.ClientRepository;
import com.example.client_api.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ClientRepository clientRepository;

    public EmployeeModel saveEmployee(EmployeeRecordDto employeeRecordDto) {
        EmployeeModel employeeModel = new EmployeeModel();
        BeanUtils.copyProperties(employeeRecordDto, employeeModel);

        PersonModel personModel = new PersonModel();

        personModel.setPersonName(employeeModel.getPersonName());
        personModel.setCpfCnpj(employeeModel.getCpfCnpj());
        personModel.setFatherName(employeeModel.getFatherName());

        employeeModel.setPersonName(personModel.getPersonName());
        employeeModel.setCpfCnpj(personModel.getCpfCnpj());
        if (personModel.getCpfCnpj() == null || personModel.getCpfCnpj().isEmpty()) {
            throw new IllegalArgumentException("CPF/CNPJ não pode ser nulo ou vazio.");
        }
        employeeModel.setFatherName(personModel.getFatherName());

        return employeeRepository.save(employeeModel);
    }

    public List<EmployeeModel> getAllEmployee() {
        List<EmployeeModel> employeeList = employeeRepository.findAll();
        if (!employeeList.isEmpty()) {
            for (EmployeeModel employee: employeeList) {
                Long id = employee.getIdPerson();
            }
        } else {
            return null;
        }
        return employeeList;
    }

    public EmployeeModel getOneEmployee(Long id) {
        Optional<EmployeeModel> getOneEmployeeOpt = employeeRepository.findById(id);
        if (getOneEmployeeOpt.isEmpty()) {
            return null;
        }
        return getOneEmployeeOpt.get();
    }

    public EmployeeModel updateEmployee(Long id, EmployeeRecordDto employeeRecordDto) {
        Optional<EmployeeModel> updateEmployeeOpt = employeeRepository.findById(id);
        if (updateEmployeeOpt.isEmpty()) {
            return null;
        }
        EmployeeModel employeeModel = updateEmployeeOpt.get();
        BeanUtils.copyProperties(employeeRecordDto, employeeModel);
        return employeeRepository.save(employeeModel);
    }

    public boolean deleteEmployee(long id) {
        Optional<EmployeeModel> deleteEmployeeOpt = employeeRepository.findById(id);
        if (deleteEmployeeOpt.isPresent()) {
            employeeRepository.delete(deleteEmployeeOpt.get());
            return true;
        } else {
            return false;
        }
    }
}
