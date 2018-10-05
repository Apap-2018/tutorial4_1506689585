package com.apap.tutorial4.service;

import java.util.List;

import com.apap.tutorial4.model.PilotModel;

public interface PilotService {
	PilotModel getPilotDetailByLicenseNumber(String licenseNumber);
//  List<PilotModel> getPilotList();
	void addPilot(PilotModel pilot);
	void deletePilotDetailByLicenseNumber(String licenseNumber);
	void updatePilotDetailByLicenseNumber(String licenseNumber, PilotModel pilot);
}
