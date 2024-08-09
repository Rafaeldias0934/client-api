package com.example.client_api.dtos;

import java.util.Date;

public record PersonRecordDto(String PersonName, String cpfCnpj, String fatherName, String matherName, Date birthDate) {

}
