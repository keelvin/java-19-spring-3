package br.com.kelvin.java19spring3.app.people.dataproviders.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonModel {
    @Id
    private String id;

    private String name;

    private String phone;

    private String mail;

    private Date birthDate;

    private boolean active;
}
