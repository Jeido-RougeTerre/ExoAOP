package com.jeido.exerciseaop.celestial.utils.exception;

import com.jeido.exerciseaop.celestial.entity.Entity;

public class AlreadyInDBException extends RuntimeException {
    public AlreadyInDBException(Entity entity) {
        super(String.format("%s#%s is already in DB", entity.getClass().getName(), entity.getId()));
    }
}
