package com.example.sisterslabspringhomework.employee;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record UpdateEmployeeRequest(
        @NotBlank Long id,
        @NotBlank String name,
        String role
) {
}
