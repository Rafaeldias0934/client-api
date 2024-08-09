package com.example.client_api.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "PEOPLE")
public class PersonModel implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_person", columnDefinition = "BIGINT", nullable = false)
    private UUID idPerson;
    @Column(name = "name_person", columnDefinition = "VARCHAR(36)", nullable = false)
    private String PersonName;
    @Column(name = "cpf_cnpj", columnDefinition = "VARCHAR(14)", nullable = false)
    private String cpfCnpj;
    @Column(name = "name_father", columnDefinition = "VARCHAR(36)", nullable = false)
    private String fatherName;
    @Column(name = "name_mather", columnDefinition = "VARCHAR(36)", nullable = false)
    private String matherName;
    @Column(name = "date_birth", columnDefinition = "TIMESTAMP", nullable = false)
    private Date birthDate;

    public UUID getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(UUID idPerson) {
        this.idPerson = idPerson;
    }

    public String getPersonName() {
        return PersonName;
    }

    public void setPersonName(String personName) {
        PersonName = personName;
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

    public String getMatherName() {
        return matherName;
    }

    public void setMatherName(String matherName) {
        this.matherName = matherName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}