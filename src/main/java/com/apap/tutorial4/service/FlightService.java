package com.apap.tutorial4.service;

import java.util.List;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.model.PilotModel;

public interface FlightService {
	void addFlight(FlightModel flight);
	FlightModel getFlightDetailByFlightNumber(String flightNumber);
	void deleteFlightDetailByFlightNumber(String flightNumber);
	void updateFlightDetail(String flightNumber, FlightModel flights);
}
