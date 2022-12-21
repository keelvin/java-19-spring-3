package br.com.kelvin.java19spring3.domain.people.services;

import br.com.kelvin.java19spring3.domain.people.dataproviders.PersonDataProvider;
import br.com.kelvin.java19spring3.domain.people.entities.Person;
import br.com.kelvin.java19spring3.domain.people.exceptions.PersonNotFoundException;
import br.com.kelvin.java19spring3.domain.people.usecases.FindPersonByIdUseCase;
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
public class FindPersonByIdService implements FindPersonByIdUseCase {
    private final PersonDataProvider personDataProvider;
    @Override
    public Person execute(String id) throws PersonNotFoundException {
        return this.getPersonDataProvider().findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }
}
