package br.com.kelvin.java19spring3.domain.people.exceptions;

public class CreatePersonException extends Exception {
    public CreatePersonException(String message, Throwable cause) {
        super(message, cause);
    }
}
