package br.com.kelvin.java19spring3.domain.people.services;

import br.com.kelvin.java19spring3.domain.people.dataproviders.PersonDataProvider;
import br.com.kelvin.java19spring3.domain.people.entities.Person;
import br.com.kelvin.java19spring3.domain.people.exceptions.CreatePersonException;
import br.com.kelvin.java19spring3.domain.people.usecases.CreatePersonUseCase;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@AllArgsConstructor
@Getter(value = AccessLevel.PRIVATE)
public class CreatePersonService implements CreatePersonUseCase {

    private final PersonDataProvider personDataProvider;
    @Override
    public String execute(Person person) throws CreatePersonException {
        return this.getPersonDataProvider().create(person).getId();
    }
}
