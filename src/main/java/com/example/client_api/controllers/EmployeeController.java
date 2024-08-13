package com.example.client_api.controllers;

import com.example.client_api.dtos.EmployeeRecordDto;
import com.example.client_api.models.EmployeeModel;
import com.example.client_api.repositories.EmployeeRepository;
import com.example.client_api.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveEmployee(employeeRecordDto));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeModel>> getAllEmployee() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployee());
    }
}
