package com.ecommerce.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        String id,
        @NotNull(message = "The customer first name is null")
        String firstName,
        @NotNull(message = "The customer last name is null")
        String lastName,
        @NotNull(message = "The customer email is null")
        @Email(message = "The customer email is not valid")
        String email,
        Address address
) {
}
