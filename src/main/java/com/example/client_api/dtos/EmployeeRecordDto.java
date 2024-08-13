package com.example.client_api.dtos;

import jakarta.validation.constraints.NotBlank;

public record EmployeeRecordDto(@NotBlank String position,@NotBlank String registrationNumber) {
}
