package com.apap.tutorial4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.model.PilotModel;
import com.apap.tutorial4.service.FlightService;
import com.apap.tutorial4.service.PilotService;

@Controller
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.GET)
	private String add(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		FlightModel flight = new FlightModel();
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		flight.setPilot(pilot);
		
		model.addAttribute("flight", flight);
		return "addFlight";
	}
	
	@RequestMapping(value = "/flight/add", method = RequestMethod.POST)
	private String addFlightSubmit(@ModelAttribute FlightModel flight) {
		flightService.addFlight(flight);
		return "add";
	}
	
	@RequestMapping("/flight/view")
	private String viewPilotFlights(@RequestParam(value="flightNumber") String flightNumber, Model model) {
		FlightModel flightProfile = flightService.getFlightDetailByFlightNumber(flightNumber);
		
		model.addAttribute("flight", flightProfile);
		return "view-flight";
	}
	
	@RequestMapping("/flight/delete/{flightNumber}")
	private String deleteflight(@PathVariable String flightNumber, Model model) {
		flightService.deleteFlightDetailByFlightNumber(flightNumber);
		return "delete-pilot";
	}
	
	@RequestMapping(value = "/flight/update/{flightNumber}", method = RequestMethod.GET)
	private String updateFlight (@PathVariable(value="flightNumber") String flightNumber, Model model) {
		FlightModel flights = flightService.getFlightDetailByFlightNumber(flightNumber);
		model.addAttribute("flight", flights);
		return "update-flight";	
	}
	
	@RequestMapping(value = "/flight/update/{flightNumber}", method = RequestMethod.POST)
	private String saveUpdate (@ModelAttribute FlightModel flights, @PathVariable(value="flightNumber") String flightNumber) {
		flightService.updateFlightDetail(flightNumber, flights);
		return "add";
	}
	
}