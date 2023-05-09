package com.klymovych.university.services;

import java.util.List;

public interface Service<T> {
    T findById(int id);
    T save(T t);
    T update( T t);
    void deleteById(int id);
    List<T> findAll();
}
