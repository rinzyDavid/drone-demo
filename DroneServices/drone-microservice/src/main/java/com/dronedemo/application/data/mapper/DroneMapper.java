package com.dronedemo.application.data.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dronedemo.application.data.dto.AvailableDronesDTO;
import com.dronedemo.application.data.dto.DroneBatteryDTO;
import com.dronedemo.application.data.dto.DroneDTO;
import com.dronedemo.application.data.model.Drone;

@Mapper(componentModel="spring")
public interface DroneMapper {
	
	DroneMapper INSTANCE = Mappers.getMapper(DroneMapper.class);
	
	
	@Mapping(target="weightLoaded",source="drone.currentWeight")
	DroneDTO modelToDto(Drone drone);
	
	List<DroneDTO> dronesToDto(List<Drone> drones);
	
	List<DroneBatteryDTO> dronesToBatteryLog(List<Drone> drones);
	
	
	@InheritInverseConfiguration
	Drone dtoToDrone(DroneDTO dto);
	
	@Mapping(target="serialNumber",source="drone.serialNumber")
	@Mapping(target="model",source="drone.droneModel")
	@Mapping(target="batteryLife",source="drone.batteryLife")
	DroneBatteryDTO droneToBetteryDto(Drone drone);
	
	@Mapping(target="total",source="total")
	@Mapping(target="drones",source="availableDrones")
	AvailableDronesDTO dronesToAvailableDTO(int total,List<Drone> availableDrones);

}
