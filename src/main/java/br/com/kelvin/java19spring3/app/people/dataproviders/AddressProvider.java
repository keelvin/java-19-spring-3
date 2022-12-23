package br.com.kelvin.java19spring3.app.people.dataproviders;

import br.com.kelvin.java19spring3.app.people.dataproviders.converters.AddressEntityConverter;
import br.com.kelvin.java19spring3.app.people.dataproviders.models.AddressModel;
import br.com.kelvin.java19spring3.app.people.dataproviders.models.PersonModel;
import br.com.kelvin.java19spring3.app.people.dataproviders.repositories.AddressRepository;
import br.com.kelvin.java19spring3.domain.people.dataproviders.AddressDataProvider;
import br.com.kelvin.java19spring3.domain.people.entities.Address;
import br.com.kelvin.java19spring3.domain.people.exceptions.CreateAddressException;
import br.com.kelvin.java19spring3.domain.people.exceptions.CreatePersonException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Getter(value = AccessLevel.PRIVATE)
public class AddressProvider implements AddressDataProvider {

    private final AddressRepository addressRepository;
    private final AddressEntityConverter addressEntityConverter;
    @Override
    public Address create(Address address) throws CreateAddressException {
        try {
            final AddressModel addressModel = this.getAddressEntityConverter().toModel(address);

            final AddressModel savedModel = this.getAddressRepository().save(addressModel);

            return this.getAddressEntityConverter().toEntity(savedModel);
        } catch (Exception e) {
            throw new CreateAddressException(e.getMessage(), e);
        }
    }
}
