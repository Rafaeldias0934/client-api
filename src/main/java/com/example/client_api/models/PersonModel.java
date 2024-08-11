package com.example.client_api.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PEOPLE")
public class PersonModel implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_person", nullable = false)
    private Long idPerson;
    @Column(name = "name_person", columnDefinition = "VARCHAR(36)", nullable = false)
    private String personName;
    @Column(name = "cpf_cnpj", columnDefinition = "VARCHAR(14)", nullable = false)
    private String cpfCnpj;
    @Column(name = "name_father", columnDefinition = "VARCHAR(36)", nullable = false)
    private String fatherName;
    @Column(name = "name_mother", columnDefinition = "VARCHAR(36)", nullable = false)
    private String motherName;
    @Column(name = "date_birth", columnDefinition = "DATE", nullable = false)
    private Date birthDate;

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}