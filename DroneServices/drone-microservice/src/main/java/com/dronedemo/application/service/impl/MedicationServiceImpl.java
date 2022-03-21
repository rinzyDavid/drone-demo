package com.dronedemo.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.dronedemo.application.data.dto.MedicationDTO;
import com.dronedemo.application.data.mapper.MedicationMapper;
import com.dronedemo.application.data.model.Medication;
import com.dronedemo.application.service.MedicationService;
import com.dronedemo.persistence.MedicationRepository;


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
	public List<Medication> createMedication(List<MedicationDTO> medDtos) {
		
		List<Medication> meds = mapper.dtosToMedications(medDtos);
		
		List<Medication> actualList = new ArrayList<>();
		medRepo.saveAll(meds).iterator().forEachRemaining(actualList::add);
		
		return actualList;
		
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
