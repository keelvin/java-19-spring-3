package br.com.kelvin.java19spring3.app.people.entrypoints.converters;

import br.com.kelvin.java19spring3.app.people.entrypoints.models.AddAddressRestModel;
import br.com.kelvin.java19spring3.common.ConvertCase;
import br.com.kelvin.java19spring3.domain.people.entities.Address;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AddAddressRestModelToAddressConverter implements ConvertCase<AddAddressRestModel, Address> {
    @Override
    public Address execute(AddAddressRestModel input) {
        final Address address = new Address();

        address.setId(UUID.randomUUID().toString());
        address.setNumber(input.getNumber());
        address.setComplement(input.getComplement());
        address.setNeighborhood(input.getNeighborhood());
        address.setCity(input.getCity());
        address.setState(input.getState());
        address.setCountry(input.getCountry());
        address.setZipCode(input.getZipCode());
        address.setPersonId(input.getPersonId());
        address.setStreet(input.getStreet());

        return address;
    }
}
