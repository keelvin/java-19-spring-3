package br.com.kelvin.java19spring3.app.people.entrypoints.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

@Data
public class CreatePersonRestModel {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "phone is required")
    @Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}-\\d{4}", message = "Phone must be in the format (99)99999-9999")
    private String phone;

    @NotBlank(message = "Mail is required")
    @Email(message = "Mail is invalid")
    private String mail;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = "America/Sao_Paulo")
    @PastOrPresent(message = "Birth date must be in the past or present")
    @NotNull(message = "Birth date is required")
    private Date birthDate;
}
