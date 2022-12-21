package br.com.kelvin.java19spring3.domain.people.usecases;

import br.com.kelvin.java19spring3.domain.people.entities.Person;
import br.com.kelvin.java19spring3.domain.people.exceptions.PersonNotFoundException;

public interface FindPersonByIdUseCase {
    Person execute(String id) throws PersonNotFoundException;
}
