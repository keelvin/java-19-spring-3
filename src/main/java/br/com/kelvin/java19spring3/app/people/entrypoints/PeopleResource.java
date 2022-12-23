package br.com.kelvin.java19spring3.app.people.entrypoints;

import br.com.kelvin.java19spring3.app.people.entrypoints.models.AddAddressRestModel;
import br.com.kelvin.java19spring3.app.people.entrypoints.models.CreatePersonRestModel;
import br.com.kelvin.java19spring3.common.ResponseData;
import org.springframework.http.ResponseEntity;

public interface PeopleResource {

    ResponseEntity<ResponseData> create(CreatePersonRestModel body);
    ResponseEntity<ResponseData> findById(String id);
    ResponseEntity<ResponseData> findAll();
    ResponseEntity<ResponseData> addAddress(AddAddressRestModel body);
}
