package br.com.kelvin.java19spring3.app.people.entrypoints.converters;

import br.com.kelvin.java19spring3.app.people.entrypoints.models.CreatePersonRestModel;
import br.com.kelvin.java19spring3.common.ConvertCase;
import br.com.kelvin.java19spring3.domain.people.entities.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CreatePersonRestModelToPersonConverter implements ConvertCase<CreatePersonRestModel, Person> {
    @Override
    public Person execute(final CreatePersonRestModel input) {
        final Person person = new Person();
        person.setName(input.getName());
        person.setMail(input.getMail());
        person.setBirthDate(input.getBirthDate());
        person.setActive(true);
        person.setId(UUID.randomUUID().toString());
        person.setPhone(input.getPhone());

        return person;
    }
}
