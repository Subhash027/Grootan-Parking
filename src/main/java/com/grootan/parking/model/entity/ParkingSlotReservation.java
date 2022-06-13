package com.grootan.parking.model.entity;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;
import java.time.LocalDateTime;



@AllArgsConstructor
@ToString
@Transactional
@Entity
@NoArgsConstructor
public class ParkingSlotReservation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String parkingLot;

    private LocalDateTime inTime;

    private String entryTime;

    private String vehicleNumber;

    private String bookingDate;

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

    public void setInTime() {
        this.inTime = inTime;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
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
    public void setInTime(LocalDateTime inTime) {
        this.inTime = inTime;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public ParkingSlotReservation(String parkingLot,LocalDateTime inTime, String  entryTime, String vehicleNumber, String bookingDate, LocalDateTime outTime,Double price) {
        this.parkingLot = parkingLot;
        this.inTime=inTime;
        this.entryTime = entryTime;
        this.vehicleNumber = vehicleNumber;
        this.bookingDate = bookingDate;
        this.outTime = outTime;
        this.price=price;
    }


}
