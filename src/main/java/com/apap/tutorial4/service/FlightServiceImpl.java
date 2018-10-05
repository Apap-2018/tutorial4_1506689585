package com.apap.tutorial4.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.model.PilotModel;
import com.apap.tutorial4.repository.FlightDb;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightDb flightDb;
	
	@Override
	public void addFlight(FlightModel flight) {
		flightDb.save(flight);
	}

	@Override
	public FlightModel getFlightDetailByFlightNumber(String flightNumber) {
		return flightDb.findByFlightNumber(flightNumber);
	}
	
	@Override
	public void deleteFlightDetailByFlightNumber(String flightNumber) {
		flightDb.delete(getFlightDetailByFlightNumber(flightNumber));
	}

	@Override
	public void updateFlightDetail(String flightNumber, FlightModel flights) {
		FlightModel allFlight = flightDb.findByFlightNumber(flightNumber);
//		allFlight.setOrigin(Origin);
//		allFlight.setDestination(destination);
//		allFlight.setTime(Time);
		allFlight.setOrigin(flights.getOrigin());
		allFlight.setDestination(flights.getDestination());
		allFlight.setTime(flights.getTime());
	}
}

//@Override
//public List<FlightModel> getFlights() {
//  return flightDb.findAll();
//}

//@Override
//public FlightModel getFlightDetailByLicenseNumber(String licenseNumber) {
//	return flightDb.findByLicenseNumber(licenseNumber);
//}