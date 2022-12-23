package br.com.kelvin.java19spring3.app.people.entrypoints;

import br.com.kelvin.java19spring3.app.people.entrypoints.converters.AddAddressRestModelToAddressConverter;
import br.com.kelvin.java19spring3.app.people.entrypoints.converters.CreatePersonRestModelToPersonConverter;
import br.com.kelvin.java19spring3.app.people.entrypoints.converters.PersonRestConverter;
import br.com.kelvin.java19spring3.app.people.entrypoints.models.AddAddressRestModel;
import br.com.kelvin.java19spring3.app.people.entrypoints.models.CreatePersonRestModel;
import br.com.kelvin.java19spring3.common.ResponseData;
import br.com.kelvin.java19spring3.domain.people.entities.Person;
import br.com.kelvin.java19spring3.domain.people.usecases.AddAddressUseCase;
import br.com.kelvin.java19spring3.domain.people.usecases.CreatePersonUseCase;
import br.com.kelvin.java19spring3.domain.people.usecases.FindAllPeopleUseCase;
import br.com.kelvin.java19spring3.domain.people.usecases.FindPersonByIdUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/people")
@AllArgsConstructor
@Getter(value = AccessLevel.PRIVATE)
public class PeopleController implements PeopleResource {

    private final CreatePersonUseCase createPersonUseCase;
    private final CreatePersonRestModelToPersonConverter createPersonRestModelToPersonConverter;
    private final FindPersonByIdUseCase findPersonByIdUseCase;
    private final PersonRestConverter personRestConverter;
    private final FindAllPeopleUseCase findAllPeopleUseCase;
    private final AddAddressUseCase addAddressUseCase;
    private final AddAddressRestModelToAddressConverter addAddressRestModelToAddressConverter;

    @Override
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData> create(@Valid @RequestBody CreatePersonRestModel body) {
        try {
            final String personId = this.getCreatePersonUseCase().execute(
                    this.getCreatePersonRestModelToPersonConverter().execute(body)
            );

            return ResponseEntity.created(URI.create("")).body(ResponseData.success(personId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseData.fail(e.getMessage()));
        }
    }

    @Override
    @GetMapping(value = "/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData> findById(@NotBlank @PathVariable String id) {
        try {
            final Person person = this.getFindPersonByIdUseCase().execute(id);

            return ResponseEntity.ok().body(ResponseData.success(this.getPersonRestConverter().toRest(person)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseData.fail(e.getMessage()));
        }
    }

    @Override
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData> findAll() {
        return ResponseEntity.ok().body(
            ResponseData.success(
                this.getFindAllPeopleUseCase().execute().stream().map(this.getPersonRestConverter()::toRest)
            )
        );
    }

    @Override
    @PostMapping(value = "/add-address/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData> addAddress(@Valid @RequestBody AddAddressRestModel body) {
        try {
            final String addressId = this.getAddAddressUseCase().execute(
                    this.getAddAddressRestModelToAddressConverter().execute(body)
            );

            return ResponseEntity.created(URI.create("")).body(ResponseData.success(addressId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseData.fail(e.getMessage()));
        }
    }


}
