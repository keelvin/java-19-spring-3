package br.com.kelvin.java19spring3.app.people.dataproviders;

import br.com.kelvin.java19spring3.app.people.dataproviders.converters.PersonEntityConverter;
import br.com.kelvin.java19spring3.app.people.dataproviders.models.PersonModel;
import br.com.kelvin.java19spring3.app.people.dataproviders.repositories.PersonRepository;
import br.com.kelvin.java19spring3.domain.people.dataproviders.PersonDataProvider;
import br.com.kelvin.java19spring3.domain.people.entities.Person;
import br.com.kelvin.java19spring3.domain.people.exceptions.CreatePersonException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Getter(value = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PersonProvider implements PersonDataProvider {

    private final PersonRepository personRepository;
    private final PersonEntityConverter personEntityConverter;

    @Override
    public Person create(final Person person) throws CreatePersonException {
        try {
            final PersonModel personModel = this.getPersonEntityConverter().toModel(person);

            final PersonModel savedModel = this.getPersonRepository().save(personModel);

            return this.getPersonEntityConverter().toEntity(savedModel);
        } catch (Exception e) {
            throw new CreatePersonException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Person> findById(String id) {
        return this.getPersonRepository().findById(id).map(this.getPersonEntityConverter()::toEntity);
    }
}
