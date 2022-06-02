package com.parkingmanagementsystem.demo.exception;


import org.webjars.NotFoundException;

public class VehicleNotFoundException extends NotFoundException {
	public VehicleNotFoundException(String message) {
		super(message);

	}
}
