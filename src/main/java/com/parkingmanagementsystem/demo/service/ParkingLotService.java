package com.parkingmanagementsystem.demo.service;


import com.parkingmanagementsystem.demo.enums.VehicleType;
import com.parkingmanagementsystem.demo.model.entity.ParkingLot;
import com.parkingmanagementsystem.demo.repository.ParkingLotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingLotService {

	@Autowired
	private ParkingLotRepository parkingLotRepository;

	private static Logger logger = LoggerFactory.getLogger(ParkingLotService.class);

	public Iterable<ParkingLot> getParkingLots(){
		return parkingLotRepository.findAll();
	}

	public ParkingLot createParkingLot(@RequestBody ParkingLot parkingLot)
	{
		parkingLot.setEmpty(true);
		logger.info("parking lot created"+parkingLot.getName());
		return parkingLotRepository.save(parkingLot);
	}

	public ParkingLot findPricingPolicyByName(String name) throws Exception {
		Optional<ParkingLot> parkingLot=parkingLotRepository.findPriceByName(name);
		return parkingLot.orElseThrow(Exception::new);
	}

	public List<ParkingLot> findByVehicleType(VehicleType vehicleType)
	{
		return parkingLotRepository.findParkingLotByVehicleType(vehicleType);
	}

//	public ParkingLot findFreeSpace()
//	{
//		List<ParkingLot> parkingLot= parkingLotRepository.findAllParkingLotByIsEmpty(true);
//		return  parkingLot;
//	}
}
