package com.prana.stock.common;

public interface ConversionUtility<E, T> {

    E convertEntity(T object);

    T convertDTO(E object);
}
