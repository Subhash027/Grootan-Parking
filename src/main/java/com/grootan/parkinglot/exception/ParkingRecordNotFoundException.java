package com.grootan.parkinglot.exception;

import org.webjars.NotFoundException;

public class ParkingRecordNotFoundException extends NotFoundException {
	public ParkingRecordNotFoundException(String message) {
		super(message);
	}
}
