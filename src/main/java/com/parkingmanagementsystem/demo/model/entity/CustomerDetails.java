package com.parkingmanagementsystem.demo.model.entity;



import com.parkingmanagementsystem.demo.enums.VehicleType;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.lang.Nullable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class CustomerDetails {

    public Integer getCustomerDetailsId() {
        return customerDetailsId;
    }

    public void setCustomerDetailsId(Integer customerDetailsId) {
        this.customerDetailsId = customerDetailsId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Nullable
    public String getMail() {
        return mail;
    }

    public void setMail(@Nullable String mail) {
        this.mail = mail;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Nullable
    public Long getWhatsappNumber() {
        return whatsappNumber;
    }

    public void setWhatsappNumber(@Nullable Long whatsappNumber) {
        this.whatsappNumber = whatsappNumber;
    }

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