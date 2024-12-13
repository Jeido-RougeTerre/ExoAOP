package com.jeido.exerciseaop.celestial.utils.exception;


public class NotFoundException extends RuntimeException {
    public NotFoundException(String entity, int id) {
        super(String.format("%s#%s not found", entity, id));
    }
}
