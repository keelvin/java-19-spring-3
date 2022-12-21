package br.com.kelvin.java19spring3.app.people.entrypoints.converters;

import br.com.kelvin.java19spring3.app.people.entrypoints.models.PersonRestModel;
import br.com.kelvin.java19spring3.common.RestConverter;
import br.com.kelvin.java19spring3.domain.people.entities.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PersonRestConverter implements RestConverter<Person, PersonRestModel> {
    @Override
    public Person toEntity(PersonRestModel rest) {
        return new Person(
            rest.getId(),
            rest.getName(),
            rest.getPhone(),
            rest.getMail(),
            rest.getBirthDate(),
            rest.isActive()
        );
    }

    @Override
    public PersonRestModel toRest(Person entity) {
        return new PersonRestModel(
            entity.getId(),
            entity.getName(),
            entity.getMail(),
            entity.getPhone(),
            entity.getBirthDate(),
            entity.isActive()
        );
    }
}
