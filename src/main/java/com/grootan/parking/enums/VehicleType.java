package com.grootan.parking.enums;

public enum VehicleType {
	CAR("car"),
	BIKE("bike");

	private final String type;

	VehicleType(String type) {
		this.type = type;
	}
	public String getType()
	{
		return type;
	}
}
