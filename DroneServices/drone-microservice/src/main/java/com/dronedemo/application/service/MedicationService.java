package com.dronedemo.application.service;

import java.util.List;

import com.dronedemo.application.data.dto.MedicationDTO;
import com.dronedemo.application.data.model.Medication;

public interface MedicationService {
	
	public void createMedication(MedicationDTO medDto);
	public List<Medication> createMedication(List<MedicationDTO> medDtos);
	public List<Medication> listMedications();
	public List<Medication> listMedications(List<Long> ids);

}
