package br.com.kelvin.java19spring3.app.people.dataproviders.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity(name = "address")
@NoArgsConstructor
@Getter
@Setter
public class AddressModel {
    @Id
    private String id;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String personId;
    @ManyToOne
    @JoinColumn(name = "personId", insertable = false, updatable = false)
    private PersonModel person;
}
