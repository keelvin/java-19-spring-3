package br.com.kelvin.java19spring3.app.people.entrypoints;

import br.com.kelvin.java19spring3.app.people.entrypoints.models.PersonRestModel;
import br.com.kelvin.java19spring3.common.ResponseData;

import java.util.List;

public interface PeopleGraphqlResource {
    List<PersonRestModel> allPeople(int count);
    PersonRestModel personById(String id);
}
