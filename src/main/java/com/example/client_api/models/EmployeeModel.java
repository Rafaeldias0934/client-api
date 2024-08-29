package com.example.client_api.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "employee")  // Defina a tabela específica para Employee, caso use JOINED
//@DiscriminatorColumn(name = "employee_type", discriminatorType = DiscriminatorType.STRING)
public class EmployeeModel extends PersonModel implements Serializable {
    public static final long serialVersionUID = 1L;


    @ManyToOne
    @JoinColumn(name ="client_id", nullable = false)
    private ClientModel clientId;
    @Column(name = "Position_employee", columnDefinition = "VARCHAR(36)", nullable = false)
    private String position;
    @Column(name = "registration_number", columnDefinition = "VARCHAR(36)", nullable = false)
    private String registrationNumber;

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
