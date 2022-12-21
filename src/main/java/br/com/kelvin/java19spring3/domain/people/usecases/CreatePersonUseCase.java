package br.com.kelvin.java19spring3.domain.people.usecases;

import br.com.kelvin.java19spring3.domain.people.entities.Person;
import br.com.kelvin.java19spring3.domain.people.exceptions.CreatePersonException;

public interface CreatePersonUseCase {

    String execute(Person person) throws CreatePersonException;
}
