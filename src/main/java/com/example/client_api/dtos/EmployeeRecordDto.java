package com.example.client_api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployeeRecordDto(@NotBlank String position,@NotBlank String registrationNumber) {
}
