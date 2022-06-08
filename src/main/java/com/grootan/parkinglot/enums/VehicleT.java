package com.grootan.parkinglot.enums;

public enum VehicleT
{
    CAR("car"),
    BIKE("bike");

    private final String type;

    VehicleT(String type)
    {
        this.type = type;
    }
    public String getType()
    {
        return type;
    }
}
