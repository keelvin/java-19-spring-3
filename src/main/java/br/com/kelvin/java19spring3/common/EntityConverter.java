package br.com.kelvin.java19spring3.common;

public interface EntityConverter<E, M> {
    E toEntity(M model);
    M toModel(E entity);
}
