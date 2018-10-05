package com.apap.tutorial4.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.model.PilotModel;
import com.apap.tutorial4.repository.PilotDb;

@Service
@Transactional
public class PilotServiceImpl implements PilotService {
	@Autowired
	private PilotDb pilotDb;

	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		return pilotDb.findByLicenseNumber(licenseNumber);
	}
	
	@Override
	public void addPilot(PilotModel pilot) {
		pilotDb.save(pilot);
	}
	
	@Override
	public void deletePilotDetailByLicenseNumber(String licenseNumber) {
		pilotDb.delete(getPilotDetailByLicenseNumber(licenseNumber));
	}
	
	@Override
	public void updatePilotDetailByLicenseNumber(String licenseNumber, PilotModel pilot) {
		PilotModel ProfilePilot = pilotDb.findByLicenseNumber(licenseNumber);

		ProfilePilot.setName(pilot.getName());
		ProfilePilot.setFlyHour(pilot.getFlyHour());
	}
}

//	@Override
//	public PilotModel getPilotDetailByLicenseNumber (String licenseNumber) {
//		PilotModel result = null;
//		
//		for (int i=0; i < pilotDb.length();i++) {
//			if (pilotDb.get(i).getLicenseNumber().equals(licenseNumber)) {
//				result = pilotDb.get(i).get;
//			}
//		}
//	}

//@Override
//public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
//	PilotModel result = null;
//	
//	for (int i=0; i < archivePilot.size(); i++) {
//		if (archivePilot.get(i).getLicenseNumber().equals(licenseNumber)) {
//			result = archivePilot.get(i);
//		}
//	}
//	return result;
//}