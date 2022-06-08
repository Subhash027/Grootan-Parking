package com.grootan.parkinglot.exception;


import org.webjars.NotFoundException;

public class VehicleNotFoundException extends NotFoundException {
	public VehicleNotFoundException(String message) {
		super(message);

	}
}
