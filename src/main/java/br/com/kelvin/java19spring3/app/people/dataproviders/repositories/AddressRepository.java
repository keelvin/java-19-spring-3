package br.com.kelvin.java19spring3.app.people.dataproviders.repositories;

import br.com.kelvin.java19spring3.app.people.dataproviders.models.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressModel, String> {
}
