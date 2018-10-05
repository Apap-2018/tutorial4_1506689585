package com.apap.tutorial4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.model.PilotModel;
import com.apap.tutorial4.service.PilotService;

@Controller
public class PilotController {
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping("/")
	private String home() {
		return "home";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("pilot", new PilotModel());
		return "addPilot";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
	private String addPilotSubmit(@ModelAttribute PilotModel pilot) {
		pilotService.addPilot(pilot);
		return "add";
	}
	
	@RequestMapping("/pilot/view")
	private String viewPilot(@RequestParam(value="licenseNumber") String licenseNumber, Model model) {
		PilotModel pilotProfile = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("pilot", pilotProfile);
		return "view-pilot";
	}
	
	@RequestMapping("/pilot/delete/{licenseNumber}")
	private String deletePilot(@PathVariable String licenseNumber, Model model) {
		pilotService.deletePilotDetailByLicenseNumber(licenseNumber);
		return "delete-pilot";
	}
	
	@RequestMapping(value = "/pilot/update/{licenseNumber}", method = RequestMethod.GET)
	private String updatePilot (@PathVariable(value="licenseNumber") String licenseNumber, Model model) {
		PilotModel pilots = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("pilot", pilots);
		return "update-pilot";	
	}
	
	@RequestMapping(value = "/pilot/update/{licenseNumber}", method = RequestMethod.POST)
	private String saveUpdate (@ModelAttribute PilotModel pilots, @PathVariable(value="licenseNumber") String licenseNumber) {
		pilotService.updatePilotDetailByLicenseNumber(licenseNumber, pilots);
		return "add";
	}
}

//
//@RequestMapping("pilot/view/license-number/{lcsNumber}")
//public String pilotPage(@PathVariable String lcsNumber, Model model) {
//	PilotModel viewPilot = pilotService.getPilotDetailByLicenseNumber(lcsNumber);
//	
//	if (viewPilot == null) {
//		return "view-error";
//	} else {
//		model.addAttribute("pilot", viewPilot);
//		return "view-profile";
//	}
//}
//
//@RequestMapping("/challenge")
//public String challenge(@RequestParam(value = "name") String name, Model model) {
//	model.addAttribute("name",name);
//	return "challenge";
//}