package com.example.techstore.repository.abst;

import java.util.List;

public interface CRUDRepository<T> {
    T create(T t);

    List<T> getAll();

    T update(T t);

    void delete(T t);
}
