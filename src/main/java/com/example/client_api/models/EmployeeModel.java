package com.example.client_api.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "EMPLOYEE")
public class EmployeeModel implements Serializable {
    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_employee", nullable = false)
    private Long idEmployee;
    @Column(name = "Position_employee", columnDefinition = "VARCHAR(36)", nullable = false)
    private String position;
    @Column(name = "registration_number", columnDefinition = "VARCHAR(36)", nullable = false)
    private String registrationNumber;

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
