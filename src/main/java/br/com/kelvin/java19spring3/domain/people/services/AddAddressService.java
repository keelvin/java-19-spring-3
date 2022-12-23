package br.com.kelvin.java19spring3.domain.people.services;

import br.com.kelvin.java19spring3.domain.people.dataproviders.AddressDataProvider;
import br.com.kelvin.java19spring3.domain.people.entities.Address;
import br.com.kelvin.java19spring3.domain.people.exceptions.CreateAddressException;
import br.com.kelvin.java19spring3.domain.people.usecases.AddAddressUseCase;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Getter(value = AccessLevel.PRIVATE)
public class AddAddressService implements AddAddressUseCase {

    private final AddressDataProvider addressDataProvider;
    @Override
    public String execute(Address address) throws CreateAddressException {
        return this.getAddressDataProvider().create(address).getId();
    }
}
