package com.parkingmanagementsystem.demo.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.parkingmanagementsystem.demo.enums.VehicleType;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.management.relation.Role;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerDetailsId;
    @NotNull
    private String vehicleNumber;
    @NotNull
    private VehicleType vehicleType;
    @Nullable
    private String mail;
    @NotNull
    private Long phoneNumber;
    @Nullable
    private Long whatsappNumber;






}