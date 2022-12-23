package br.com.kelvin.java19spring3.app.people.dataproviders.converters;

import br.com.kelvin.java19spring3.app.people.dataproviders.models.AddressModel;
import br.com.kelvin.java19spring3.common.EntityConverter;
import br.com.kelvin.java19spring3.domain.people.entities.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressEntityConverter implements EntityConverter<Address, AddressModel> {
    @Override
    public Address toEntity(AddressModel model) {
        return new Address(
            model.getId(),
            model.getStreet(),
            model.getNumber(),
            model.getComplement(),
            model.getNeighborhood(),
            model.getCity(),
            model.getState(),
            model.getCountry(),
            model.getZipCode(),
            model.getPersonId()
        );
    }

    @Override
    public AddressModel toModel(Address entity) {
        final AddressModel addressModel = new AddressModel();
        addressModel.setId(entity.getId());
        addressModel.setStreet(entity.getStreet());
        addressModel.setNumber(entity.getNumber());
        addressModel.setComplement(entity.getComplement());
        addressModel.setNeighborhood(entity.getNeighborhood());
        addressModel.setCity(entity.getCity());
        addressModel.setState(entity.getState());
        addressModel.setCountry(entity.getCountry());
        addressModel.setPersonId(entity.getPersonId());

        return addressModel;
    }
}
