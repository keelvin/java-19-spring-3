package br.com.kelvin.java19spring3.domain.people.dataproviders;

import br.com.kelvin.java19spring3.domain.people.entities.Address;
import br.com.kelvin.java19spring3.domain.people.exceptions.CreateAddressException;

public interface AddressDataProvider {
    Address create(Address address) throws CreateAddressException;
}
