package br.com.kelvin.java19spring3.domain.people.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String id;
    private String name;
    private String phone;
    private String mail;
    private Date birthDate;
    private boolean active;
    private List<Address> addresses;
}
