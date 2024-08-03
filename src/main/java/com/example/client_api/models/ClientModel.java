package com.example.client_api.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "CLIENTS")
public class ClientModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idClient;
    private String bairro;
    private String cpf_cnpj;

    public UUID getIdClient() {
        return idClient;
    }

    public void setIdClient(UUID idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return bairro;
    }

    public void setName(String bairro) {
        this.bairro = bairro;
    }

    public String getCPF_CNPJ() {
        return cpf_cnpj;
    }

    public void setCPF_CNPJ(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }
}
