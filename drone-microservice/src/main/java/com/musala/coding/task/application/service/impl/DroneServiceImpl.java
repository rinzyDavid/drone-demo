package com.musala.coding.task.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musala.coding.task.application.data.dto.AvailableDronesDTO;
import com.musala.coding.task.application.data.dto.DroneBatteryDTO;
import com.musala.coding.task.application.data.dto.DroneDTO;
import com.musala.coding.task.application.data.mapper.DroneMapper;
import com.musala.coding.task.application.data.model.Drone;
import com.musala.coding.task.application.data.model.DroneState;
import com.musala.coding.task.application.service.DroneService;
import com.musala.coding.task.persistence.DroneRepository;


@Service
public class DroneServiceImpl implements DroneService{
	
	@Autowired
	private DroneRepository droneRepo;
	
	@Autowired
	private DroneMapper droneMapper;
	
	private int BETTERY_LIMIT=25;
	
	
	

	@Override
	public DroneDTO registerDrone(DroneDTO droneDto) {
		
		Drone drone = droneMapper.dtoToDrone(droneDto);
		Drone _drone = droneRepo.save(drone);
		
		return droneMapper.modelToDto(_drone);
		
	}

	@Override
	public DroneDTO getDrone(String serialNumber) {
	
		Drone drone = droneRepo.findBySerialNumber(serialNumber);
		
		return droneMapper.modelToDto(drone);
	}

	@Override
	public List<DroneDTO> listDrones() {
		
		List<Drone> drones = droneRepo.findAll();
		
		
		return droneMapper.dronesToDto(drones);
	}

	@Override
	public AvailableDronesDTO listAvailableDrones() {
		
		List<Drone> drones = droneRepo.findByDroneState(DroneState.LOADING);
		
		return droneMapper.dronesToAvailableDTO(drones.size(), drones);
	}

	@Override
	public DroneBatteryDTO checkBattery(String serialNumber) {
		// TODO Auto-generated method stub
		Drone drone = droneRepo.findBySerialNumber(serialNumber);
		return droneMapper.droneToBetteryDto(drone);
	}

}
