package br.com.kelvin.java19spring3.app.people.entrypoints.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PersonRestModel {
    private String id;
    private String name;
    private String mail;
    private String phone;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = "America/Sao_Paulo")
    private Date birthDate;
    private boolean active;
}
