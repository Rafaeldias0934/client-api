package com.example.client_api.controllers;

import com.example.client_api.dtos.EmployeeRecordDto;
import com.example.client_api.models.ClientModel;
import com.example.client_api.models.EmployeeModel;
import com.example.client_api.repositories.ClientRepository;
import com.example.client_api.service.ClientService;
import com.example.client_api.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeModel> saveEmployee(@RequestBody @Valid EmployeeRecordDto employeeRecordDto) {
        //EmployeeModel savedEmployee = employeeService.saveEmployee(employeeRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveEmployee(employeeRecordDto));
        //return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveEmployee(employeeRecordDto));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeModel>> getAllEmployee() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployee());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneEmployee(@PathVariable(value = "id") Long id) {
        EmployeeModel employeeModel = employeeService.getOneEmployee(id);
        if (employeeModel == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(employeeModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable(value = "id") Long id,
                                                 @RequestBody @Valid EmployeeRecordDto employeeRecordDto) {
        EmployeeModel employeeModel = employeeService.updateEmployee(id,employeeRecordDto);
        if (employeeModel == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(employeeModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable(value = "id") Long id) {
        Boolean isDelected = employeeService.deleteEmployee(id);
        if (isDelected) {
            return ResponseEntity.status(HttpStatus.OK).body("Employee deleted Successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
    }
}
