package com.example.client_api.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "CLIENTS")
@DiscriminatorValue("CLIENTS")
public class ClientModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name ="id_client", nullable = false)
    private Long idClient;


    @Column (name ="name", nullable = false)
    private String name;

    @Column (name ="cpf_CNPJ_Client", nullable = false)
    private String cpfCNPJClient;
    @Column(name = "created_at", columnDefinition = "TIMESTAMP",nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP",nullable = true)
    private LocalDateTime updatedAt;

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpfCNPJClient() {
        return cpfCNPJClient;
    }

    public void setCpfCNPJClient(String cpfCNPJClient) {
        this.cpfCNPJClient = cpfCNPJClient;
    }


    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
