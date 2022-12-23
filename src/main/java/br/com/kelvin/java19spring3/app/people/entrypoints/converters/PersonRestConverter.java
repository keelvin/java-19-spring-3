package br.com.kelvin.java19spring3.app.people.entrypoints.converters;

import br.com.kelvin.java19spring3.app.people.entrypoints.models.PersonRestModel;
import br.com.kelvin.java19spring3.common.RestConverter;
import br.com.kelvin.java19spring3.domain.people.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@AllArgsConstructor
@Getter
public class PersonRestConverter implements RestConverter<Person, PersonRestModel> {

    private final AddressRestConverter addressRestConverter;
    @Override
    public Person toEntity(PersonRestModel rest) {
        return new Person(
            rest.getId(),
            rest.getName(),
            rest.getPhone(),
            rest.getMail(),
            rest.getBirthDate(),
            rest.isActive(),
            rest.getAddresses() == null ? new ArrayList<>() : rest.getAddresses().stream().map(addressRestConverter::toEntity).toList()
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
            entity.isActive(),
            entity.getAddresses() == null ? new ArrayList<>() : entity.getAddresses().stream().map(addressRestConverter::toRest).toList()
        );
    }
}
