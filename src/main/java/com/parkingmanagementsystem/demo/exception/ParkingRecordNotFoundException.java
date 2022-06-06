package com.parkingmanagementsystem.demo.exception;

import org.webjars.NotFoundException;

public class ParkingRecordNotFoundException extends NotFoundException {
	public ParkingRecordNotFoundException(String message) {
		super(message);
	}
}
