package com.dronedemo.application.data.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dronedemo.application.data.dto.MedicationDTO;
import com.dronedemo.application.data.model.Medication;

@Mapper(componentModel="spring")
public interface MedicationMapper {
	
	MedicationMapper INSTANCE = Mappers.getMapper(MedicationMapper.class);
	
	MedicationDTO medicationToDTOo(Medication medication);
	
	@InheritInverseConfiguration
	Medication dtoToMedication(MedicationDTO dto);
	
	@InheritInverseConfiguration
	List<Medication> dtosToMedications(List<MedicationDTO> dtos);

}
