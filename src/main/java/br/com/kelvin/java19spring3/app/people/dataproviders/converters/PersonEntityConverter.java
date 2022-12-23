package br.com.kelvin.java19spring3.app.people.dataproviders.converters;

import br.com.kelvin.java19spring3.app.people.dataproviders.models.PersonModel;
import br.com.kelvin.java19spring3.common.EntityConverter;
import br.com.kelvin.java19spring3.domain.people.entities.Person;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@AllArgsConstructor
@Getter(value = AccessLevel.PRIVATE)
public class PersonEntityConverter implements EntityConverter<Person, PersonModel> {

    private final AddressEntityConverter addressEntityConverter;

    @Override
    public Person toEntity(PersonModel model) {
        return new Person(
            model.getId(),
            model.getName(),
            model.getPhone(),
            model.getMail(),
            model.getBirthDate(),
            model.isActive(),
            model.getAddresses() == null ? new ArrayList<>() : model.getAddresses().stream().map(addressEntityConverter::toEntity).toList()
        );
    }

    @Override
    public PersonModel toModel(Person entity) {
        final PersonModel personModel = new PersonModel();
        personModel.setId(entity.getId());
        personModel.setName(entity.getName());
        personModel.setPhone(entity.getPhone());
        personModel.setMail(entity.getMail());
        personModel.setBirthDate(entity.getBirthDate());
        personModel.setActive(entity.isActive());

        return personModel;
    }
}
