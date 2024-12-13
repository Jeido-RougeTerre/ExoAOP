package com.jeido.exerciseaop.celestial.repository;

import com.jeido.exerciseaop.celestial.entity.Entity;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T extends Entity> {
    T save(T t);
    Optional<T> findById(int id);
    List<T> findAll();
    List<Integer> findAllIds();
    boolean deleteById(int id);
    String getEntityName();
}
