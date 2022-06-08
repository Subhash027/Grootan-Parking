package com.grootan.parkinglot.exception;


import org.webjars.NotFoundException;

public class ResourceNotFoundException extends NotFoundException
{
    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}
