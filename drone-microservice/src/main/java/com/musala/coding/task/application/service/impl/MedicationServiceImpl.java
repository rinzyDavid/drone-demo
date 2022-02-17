package com.musala.coding.task.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musala.coding.task.application.data.dto.MedicationDTO;
import com.musala.coding.task.application.data.mapper.MedicationMapper;
import com.musala.coding.task.application.data.model.Medication;
import com.musala.coding.task.application.service.MedicationService;
import com.musala.coding.task.persistence.MedicationRepository;

@Service
public class MedicationServiceImpl implements MedicationService{
	
	
	@Autowired
	private MedicationRepository medRepo;
	
	@Autowired
	private MedicationMapper mapper;

	@Override
	public void createMedication(MedicationDTO medDto) {
		
		Medication med = mapper.dtoToMedication(medDto);
		medRepo.save(med);
		
	}

	@Override
	public void createMedication(List<MedicationDTO> medDtos) {
		
		List<Medication> meds = mapper.dtosToMedications(medDtos);
		medRepo.saveAll(meds);
		
	}

	@Override
	public List<Medication> listMedications() {
		// TODO Auto-generated method stub
		return medRepo.findAll();
	}

	@Override
	public List<Medication> listMedications(List<Long> ids) {
		// TODO Auto-generated method stub
		return medRepo.findAllByIdIn(ids);
	}

}
