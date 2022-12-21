package br.com.kelvin.java19spring3.app.people.dataproviders.repositories;

import br.com.kelvin.java19spring3.app.people.dataproviders.models.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonModel, String> {
}
