package com.example.client_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "EMPLOYEE")
public class EmployeeModel implements Serializable {
    public static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Position_employee", columnDefinition = "VARCHAR(36)", nullable = false)
    private String position;
    @Column(name = "resgistration_number", columnDefinition = "VARCHAR(36)", nullable = false)
    private String resgistrationNumber;

}
