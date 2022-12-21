package br.com.kelvin.java19spring3.app.people.dataproviders.converters;

import br.com.kelvin.java19spring3.app.people.dataproviders.models.PersonModel;
import br.com.kelvin.java19spring3.common.EntityConverter;
import br.com.kelvin.java19spring3.domain.people.entities.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PersonEntityConverter implements EntityConverter<Person, PersonModel> {
    @Override
    public Person toEntity(PersonModel model) {
        return new Person(
            model.getId(),
            model.getName(),
            model.getPhone(),
            model.getMail(),
            model.getBirthDate(),
            model.isActive()
        );
    }

    @Override
    public PersonModel toModel(Person entity) {
        return new PersonModel(
            entity.getId(),
            entity.getName(),
            entity.getPhone(),
            entity.getMail(),
            entity.getBirthDate(),
            entity.isActive()
        );
    }
}
