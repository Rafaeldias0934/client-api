package com.example.client_api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record PersonRecordDto(@NotBlank String personName, @NotNull String cpfCnpj,
                              @NotBlank String fatherName, @NotBlank String motherName,
                              Date birthDate) {

}
