package br.com.kelvin.java19spring3.common;

public interface ConvertCase<I, O> {
    O execute(I input);
}
