package com.example.client_api.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record PersonRecordDto(@NotBlank String personName, @NotBlank String cpfCnpj,
                              @NotBlank String fatherName, @NotBlank String motherName,
                              @NotBlank Date birthDate) {

}
