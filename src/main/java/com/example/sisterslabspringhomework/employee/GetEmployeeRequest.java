package com.example.sisterslabspringhomework.employee;

import jakarta.validation.constraints.NotBlank;

public record GetEmployeeRequest(
        @NotBlank Long id
) {
}
