package br.com.kelvin.java19spring3.domain.people.services;

import br.com.kelvin.java19spring3.domain.people.dataproviders.PersonDataProvider;
import br.com.kelvin.java19spring3.domain.people.entities.Person;
import br.com.kelvin.java19spring3.domain.people.usecases.FindAllPeopleUseCase;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Getter(value = AccessLevel.PRIVATE)
public class FindAllPeopleService implements FindAllPeopleUseCase {

    private final PersonDataProvider personDataProvider;
    @Override
    public List<Person> execute() {
        return this.getPersonDataProvider().findAll();
    }
}
