package com.parkingmanagementsystem.demo.repository;

import com.parkingmanagementsystem.demo.model.entity.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/***
 * customer details repository
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails,Integer>
{

    @Query("select customer from CustomerDetails customer where customer.vehicleNumber= ?1")
    CustomerDetails findByVehicleNumber(String vehicle);

    @Query("select cd from CustomerDetails cd")
    List<CustomerDetails> findAllCustomer();

    Optional<CustomerDetails> getCustomerDetailsByVehicleNumber(String plate);

    @Query("select customer from CustomerDetails customer where customer.mail= ?1")
    CustomerDetails findByEmail(String mail);




}
