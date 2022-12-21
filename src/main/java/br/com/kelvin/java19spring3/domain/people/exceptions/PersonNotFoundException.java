package br.com.kelvin.java19spring3.domain.people.exceptions;

public class PersonNotFoundException extends Exception {
    public PersonNotFoundException(String id) {
        super(String.format("Person with id %s not found", id));
    }
}
