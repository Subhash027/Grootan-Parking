package com.grootan.parkinglot.service;

import com.grootan.parkinglot.exception.ParkingLotNotFoundException;
import com.grootan.parkinglot.exception.VehicleAlreadyCheckedInException;
import com.grootan.parkinglot.exception.VehicleAlreadyCheckedOutException;
import com.grootan.parkinglot.model.entity.CustomerDetails;
import com.grootan.parkinglot.model.entity.ParkingLot;
import com.grootan.parkinglot.model.entity.ParkingSlotReservation;
import com.grootan.parkinglot.repository.ParkingLotRepository;
import com.grootan.parkinglot.repository.ParkingSlotReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingSlotReservationService {
	@Autowired
	ParkingSlotReservationRepository parkingSlotReservationRepository;

	@Autowired
	CustomerDetailsService customerDetailsService;

	@Autowired
	ParkingLotService parkingLotService;

	@Autowired
	private ParkingLotRepository parkingLotRepository;

	Logger logger = LoggerFactory.getLogger(ParkingSlotReservationService.class);


	public Iterable<ParkingSlotReservation> getParkingList()
	{

		return parkingSlotReservationRepository.findAll();
	}

	public ParkingSlotReservation createParking(CustomerDetails comingVehicle)
	{
		CustomerDetails customerDetails=checkIfVehicleExists(comingVehicle);
		checkIfAlreadyParked(customerDetails);
		ParkingLot parkingLot=findCorrectOne(customerDetails);
		if (parkingLot != null) {
			parkingLot.setEmpty(false);
			parkingLot.getPrice();
			parkingLotRepository.save(parkingLot);
			return parkingSlotReservationRepository.save(new ParkingSlotReservation(parkingLot.getName(), LocalTime.now(),customerDetails.getVehicleNumber(),LocalDate.now(), (LocalDateTime) null,parkingLot.getPrice()));

		} else {
			throw new ParkingLotNotFoundException("Parking Lot not suitable for you");
		}
	}
	public CustomerDetails checkIfVehicleExists(CustomerDetails customerDetails)
	{
		Optional<CustomerDetails> comingVehicle=customerDetailsService.findByVehicleNumber(customerDetails.getVehicleNumber());

		if(comingVehicle.isPresent())
		{
			customerDetails=comingVehicle.get();
			logger.debug("Vehicle " + customerDetails.getCustomerDetailsId() + "exists.");
			return customerDetails;
		}
		else {
			logger.debug("Vehicle is not exists. Creating a new vehicle.");
			return customerDetailsService.saveUserDetails(customerDetails);
		}
	}
	public void checkIfAlreadyParked(CustomerDetails customerDetails)
	{
		List<ParkingSlotReservation> parkedPerson = parkingSlotReservationRepository.findByVehicleNumber(customerDetails.getVehicleNumber());
		if(parkedPerson.size()>=1)
		{
			for(ParkingSlotReservation parkingSlotReservation:parkedPerson)
			{
				LocalDateTime checkIn = parkingSlotReservation.getInTime();
				LocalDateTime checkOut = parkingSlotReservation.getOutTime();
				LocalDate date=parkingSlotReservation.getBookingDate();
				if(checkIn!=null&&checkOut==null&&date!=null)
				{
					logger.info("Vehicle already check-in ");
					throw new VehicleAlreadyCheckedInException();
				}
			}
		}
	}
	public ParkingLot findCorrectOne(CustomerDetails customerDetails)
	{
		List<ParkingLot> parkingLotList = parkingLotService.findByVehicleType(customerDetails.getVehicleType());
		logger.debug("Getting suitable lot lists with looking height first.");

		if (parkingLotList != null) {
			for (ParkingLot parkingLot : parkingLotList) {
				if (parkingLot.getVehicleType()==customerDetails.getVehicleType() && parkingLot.isEmpty())
				{
					logger.debug("Found a suitable lot " + parkingLot.getName());
					return parkingLot;
				}
			}
		}
		logger.debug("Could not found a suitable lot.");
		return null;
	}


	@Transactional
	public ParkingSlotReservation updateParkingRecord(Integer parkingId) throws Exception {
		LocalDateTime checkOutDate = LocalDateTime.now();
		double unitPrice=0;

		logger.debug("Checking existing parking records, if not found throw an exception");
		ParkingSlotReservation existingParking = parkingSlotReservationRepository.getParkingSlotReservationById(parkingId)
				.orElseThrow(()-> new ParkingLotNotFoundException("there is no record here"));


		logger.debug("No record exists checking end date.");
		if (existingParking.getOutTime() != null)
			throw new VehicleAlreadyCheckedOutException();

		logger.debug("Find price for the lot");
		ParkingLot parkingLot = parkingLotService.findPricingPolicyByName(existingParking.getParkingLot());


		logger.debug("Calculating price for the lot");
		unitPrice = parkingLot.getPrice();

		logger.debug("Setting end date and price for record, setting lot as not empty");
		existingParking.setOutTime(checkOutDate);
		existingParking.setPrice(calculatePrice(existingParking.getInTime(), checkOutDate, unitPrice));
		parkingLot.setEmpty(true);

		return parkingSlotReservationRepository.save(existingParking);

	}


	public double calculatePrice(LocalDateTime checkInDate, LocalDateTime checkOutDate, double price) {
		int priceCheck = (int) ChronoUnit.HOURS.between(checkInDate, checkOutDate);
		logger.debug("Price is calculated for " + priceCheck);
		double pricevalue=priceCheck * price;
		if(pricevalue<=0)
		{
			return price;
		}
		return priceCheck*price;
	}



}
