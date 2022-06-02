package com.parkingmanagementsystem.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.parkingmanagementsystem.demo.enums.VehicleType;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingLot {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String address;

    private String city;

    private boolean isEmpty;

    private VehicleType vehicleType;

    private Double price;



}
