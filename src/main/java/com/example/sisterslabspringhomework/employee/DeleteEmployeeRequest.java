package com.example.sisterslabspringhomework.employee;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record DeleteEmployeeRequest(
        @NotBlank Long id
) {
}
