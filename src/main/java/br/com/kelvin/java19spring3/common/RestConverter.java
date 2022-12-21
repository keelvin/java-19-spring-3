package br.com.kelvin.java19spring3.common;

public interface RestConverter<E, R> {
    E toEntity(R rest);
    R toRest(E entity);
}
