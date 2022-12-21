package br.com.kelvin.java19spring3.domain.people.dataproviders;

import br.com.kelvin.java19spring3.domain.people.entities.Person;
import br.com.kelvin.java19spring3.domain.people.exceptions.CreatePersonException;

import java.util.Optional;

public interface PersonDataProvider {
    Person create(Person person) throws CreatePersonException;
    Optional<Person> findById(String id);
}
