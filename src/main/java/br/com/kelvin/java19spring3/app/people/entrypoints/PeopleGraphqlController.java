package br.com.kelvin.java19spring3.app.people.entrypoints;

import br.com.kelvin.java19spring3.app.people.entrypoints.converters.PersonRestConverter;
import br.com.kelvin.java19spring3.app.people.entrypoints.models.PersonRestModel;
import br.com.kelvin.java19spring3.domain.people.entities.Person;
import br.com.kelvin.java19spring3.domain.people.usecases.FindAllPeopleUseCase;
import br.com.kelvin.java19spring3.domain.people.usecases.FindPersonByIdUseCase;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
@Getter(value = AccessLevel.PRIVATE)
public class PeopleGraphqlController implements PeopleGraphqlResource {

    private final FindAllPeopleUseCase findAllPeopleUseCase;
    private final PersonRestConverter personRestConverter;
    private final FindPersonByIdUseCase findPersonByIdUseCase;

    @Override
    @QueryMapping
    public List<PersonRestModel> allPeople(@Argument int count) {
        final List<Person> peopleEntity = this.getFindAllPeopleUseCase().execute();

        return peopleEntity.stream().map(this.getPersonRestConverter()::toRest).limit(count).toList();
    }

    @Override
    @QueryMapping
    public PersonRestModel personById(@Argument String id) {
        try {
            final Person personEntity = this.getFindPersonByIdUseCase().execute(id);

            return this.getPersonRestConverter().toRest(personEntity);
        } catch (Exception e) {
            return null;
        }
    }
}
