package br.com.kelvin.java19spring3.app.configurations;

import br.com.kelvin.java19spring3.common.ResponseData;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseData> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        final List<String> allErrors = new ArrayList<>();

        e.getBindingResult().getAllErrors().forEach(error -> allErrors.add(error.getDefaultMessage()));

        return ResponseEntity.badRequest().body(ResponseData.fail("Validation error", allErrors));
    }
}
