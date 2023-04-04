package com.hotel.management.hotel_management.dao;

import java.util.List;

public interface Dao<T> {
    T save(T t);
    boolean remove(T t);
    T update(T t);
    T findById(int id);
    List<T> findAll();
}
