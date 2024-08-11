package com.example.client_api.dtos;

import java.util.Date;

public record PersonRecordDto(String personName, String cpfCnpj, String fatherName, String motherName, Date birthDate) {

}
