package com.musala.coding.task.application.service;

import java.util.List;

import com.musala.coding.task.application.data.dto.MedicationDTO;
import com.musala.coding.task.application.data.model.Medication;

public interface MedicationService {
	
	public void createMedication(MedicationDTO medDto);
	public void createMedication(List<MedicationDTO> medDtos);
	public List<Medication> listMedications();
	public List<Medication> listMedications(List<Long> ids);

}
