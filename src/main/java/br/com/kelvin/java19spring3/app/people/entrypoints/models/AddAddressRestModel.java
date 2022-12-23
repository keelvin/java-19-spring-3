package br.com.kelvin.java19spring3.app.people.entrypoints.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddAddressRestModel {
    @NotBlank(message = "Street is required")
    @NotNull(message = "Street is required")
    private String street;
    @NotBlank(message = "Number is required")
    @NotNull(message = "Number is required")
    private String number;
    private String complement;
    private String neighborhood;
    @NotBlank(message = "City is required")
    @NotNull(message = "City is required")
    private String city;
    @NotBlank(message = "State is required")
    @NotNull(message = "State is required")
    private String state;

    @NotBlank(message = "Country is required")
    @NotNull(message = "Country is required")
    private String country;
    private String zipCode;

    @NotBlank(message = "Person id is required")
    @NotNull(message = "Person id is required")
    private String personId;
}
