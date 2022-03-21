package com.dronemonitor.application.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dronemonitor.application.dto.AuditDTO;
import com.dronemonitor.application.dto.DroneBatteryDTO;
import com.dronemonitor.application.model.DroneAudit;
import com.dronemonitor.application.model.DroneBatteryLog;

@Mapper(componentModel="spring")
public interface AuditMapper {
	
	AuditMapper INSTANCE = Mappers.getMapper(AuditMapper.class);
	
	@Mapping(target="model", source="log.droneModel")
	DroneBatteryDTO baterryToDTO(DroneBatteryLog log);
	
	List<DroneBatteryDTO> modelsToDto(List<DroneBatteryLog> logs);
	
	@InheritInverseConfiguration
	DroneBatteryLog dtoToBatteryModel(DroneBatteryDTO dto);
	
	
	@InheritInverseConfiguration
	DroneAudit dtoToAudit(AuditDTO auditDTO);
	
	AuditDTO auditToDTO(DroneAudit audit);

}
