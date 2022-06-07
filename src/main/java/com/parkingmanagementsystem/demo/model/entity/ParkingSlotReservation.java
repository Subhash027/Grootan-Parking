package com.parkingmanagementsystem.demo.model.entity;


import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;







@NoArgsConstructor
@AllArgsConstructor
@ToString
@Transactional
@Entity
public class ParkingSlotReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String parkingLot;

    private LocalDateTime inTime;

    private String vehicleNumber;

    private LocalDate bookingDate;

    private LocalDateTime outTime;

    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(String parkingLot) {
        this.parkingLot = parkingLot;
    }

    public LocalDateTime getInTime() {
        return inTime;
    }

    public void setInTime(LocalDateTime inTime) {
        this.inTime = inTime;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDateTime getOutTime() {
        return outTime;
    }

    public void setOutTime(LocalDateTime outTime) {
        this.outTime = outTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ParkingSlotReservation(String parkingLot, LocalDateTime inTime, String vehicleNumber, LocalDate bookingDate, LocalDateTime outTime, Double price) {
        this.parkingLot = parkingLot;
        this.inTime = inTime;
        this.vehicleNumber = vehicleNumber;
        this.bookingDate = bookingDate;
        this.outTime = outTime;
        this.price=price;
    }
}
