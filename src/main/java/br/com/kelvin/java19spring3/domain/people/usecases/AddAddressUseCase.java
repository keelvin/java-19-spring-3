package br.com.kelvin.java19spring3.domain.people.usecases;

import br.com.kelvin.java19spring3.domain.people.entities.Address;
import br.com.kelvin.java19spring3.domain.people.exceptions.CreateAddressException;

public interface AddAddressUseCase {
    String execute(Address address) throws CreateAddressException;
}
