package com.medicalclinic.api.exceptions;

public class EntityNotFoundException extends Exception{

    public EntityNotFoundException(String message) {
        super(message);
    }
}
