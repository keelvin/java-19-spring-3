package br.com.kelvin.java19spring3.app.people.dataproviders.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity(name = "person")
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

    @OneToMany(mappedBy = "person")
    private List<AddressModel> addresses;
}
