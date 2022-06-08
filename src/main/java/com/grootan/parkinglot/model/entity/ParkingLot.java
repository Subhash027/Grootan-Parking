package com.grootan.parkinglot.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grootan.parkinglot.enums.VehicleT;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingLot
{
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String address;

    private String city;

    private boolean isEmpty;

    private VehicleT vehicleType;

    private Double price;
}
