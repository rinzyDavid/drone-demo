package com.musala.coding.task.application.service;

import java.util.List;

import com.musala.coding.task.application.data.dto.MedicationDTO;

public interface MedicationService {
	
	public void createMedication(MedicationDTO medDto);
	public void createMedication(List<MedicationDTO> medDtos);

}
