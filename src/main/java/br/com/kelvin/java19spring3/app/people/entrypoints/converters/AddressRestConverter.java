package br.com.kelvin.java19spring3.app.people.entrypoints.converters;

import br.com.kelvin.java19spring3.app.people.entrypoints.models.AddressRestModel;
import br.com.kelvin.java19spring3.common.RestConverter;
import br.com.kelvin.java19spring3.domain.people.entities.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressRestConverter implements RestConverter<Address, AddressRestModel> {
    @Override
    public Address toEntity(AddressRestModel rest) {
        return new Address(
            rest.getId(),
            rest.getStreet(),
            rest.getNumber(),
            rest.getComplement(),
            rest.getNeighborhood(),
            rest.getCity(),
            rest.getState(),
            rest.getCountry(),
            rest.getZipCode(),
            rest.getPersonId()
        );
    }

    @Override
    public AddressRestModel toRest(Address entity) {
        return new AddressRestModel(
            entity.getId(),
            entity.getStreet(),
            entity.getNumber(),
            entity.getComplement(),
            entity.getNeighborhood(),
            entity.getCity(),
            entity.getState(),
            entity.getCountry(),
            entity.getZipCode(),
            entity.getPersonId()
        );
    }
}
