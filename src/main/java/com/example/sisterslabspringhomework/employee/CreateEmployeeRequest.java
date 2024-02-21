package com.example.sisterslabspringhomework.employee;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CreateEmployeeRequest(
       @NotBlank String name,
       @NotBlank String role
) {
}
