package br.com.kelvin.java19spring3.domain.people.usecases;

import br.com.kelvin.java19spring3.domain.people.entities.Person;

import java.util.List;

public interface FindAllPeopleUseCase {
    List<Person> execute();
}
