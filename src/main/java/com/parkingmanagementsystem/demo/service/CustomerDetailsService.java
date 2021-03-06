package com.parkingmanagementsystem.demo.service;


import com.parkingmanagementsystem.demo.exception.ResourceNotFoundException;
import com.parkingmanagementsystem.demo.model.entity.CustomerDetails;
import com.parkingmanagementsystem.demo.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.parkingmanagementsystem.demo.constants.StringConstants.DELETE_SUCCESSFULL;


@Service
public class CustomerDetailsService {

    Logger logger= LoggerFactory.getLogger(CustomerDetailsService.class);


    CustomerRepository customerRepository;

    /***
     *
     *delete by vehicle Number
     * @param vehicleNumber
     * @return
     */
    public CustomerDetails deleteByvehicleNumber(String vehicleNumber) throws ResourceNotFoundException {

        CustomerDetails customerDetails=customerRepository.findByVehicleNumber(vehicleNumber);
        if(customerDetails==null)
        {
            throw new ResourceNotFoundException("vehicle number is not found");
        }
        customerRepository.delete(customerDetails);
        logger.info(DELETE_SUCCESSFULL);
        return customerDetails ;

    }


    /***
     * get details from user and save into database
     * @param customerDetails
     */
    public CustomerDetails saveUserDetails(CustomerDetails customerDetails)
    {
         return customerRepository.save(customerDetails);

    }

    /***
     * return all details
     *
     * @return
     */
    public List<CustomerDetails> findAll()
    {
        return customerRepository.findAllCustomer();
    }

    /***
     * find by vehicle Number
     * @param vehicleNumber
     * @return
     */

    public Optional<CustomerDetails> findByVehicleNumber(String vehicleNumber)
    {

        Optional<CustomerDetails> customerDetails=customerRepository.getCustomerDetailsByVehicleNumber(vehicleNumber);
        if(customerDetails==null)
        {
            throw new ResourceNotFoundException("vehicle number is not found");
        }
        return customerDetails;

    }














}
