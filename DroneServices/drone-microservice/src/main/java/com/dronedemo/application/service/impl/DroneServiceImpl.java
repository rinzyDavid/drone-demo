package com.dronedemo.application.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dronedemo.application.data.dto.AuditDTO;
import com.dronedemo.application.data.dto.AvailableDronesDTO;
import com.dronedemo.application.data.dto.DroneBatteryDTO;
import com.dronedemo.application.data.dto.DroneDTO;
import com.dronedemo.application.data.mapper.DroneMapper;
import com.dronedemo.application.data.model.Drone;
import com.dronedemo.application.data.model.DroneState;
import com.dronedemo.application.service.DroneService;
import com.dronedemo.persistence.DroneRepository;


/**
 * 
 * @author David
 * A Concrete implementation of DroneService interface
 *
 */

@Service
public class DroneServiceImpl implements DroneService{
	
	
	private DroneRepository droneRepo;
	

	private DroneMapper droneMapper;
	
	private int BATTERY_LIMIT=25;
	
	@Autowired
	public DroneServiceImpl(DroneRepository droneRepo,DroneMapper droneMapper) {
		this.droneRepo = droneRepo;
		this.droneMapper = droneMapper;
	}
	
	
	

	@Override
	public DroneDTO registerDrone(DroneDTO droneDto) {
		
		Drone drone = droneMapper.dtoToDrone(droneDto);
		if(drone.getBatteryLife()>BATTERY_LIMIT) {
			drone.setDroneState(DroneState.LOADING);
		}
		else {
			drone.setDroneState(DroneState.IDLE);
		}
		
		
		drone.setCurrentWeight(0.0);
		Drone _drone = droneRepo.save(drone);
		
		return droneMapper.modelToDto(_drone);
		
	}

	@Override
	public DroneDTO getDrone(String serialNumber) {
	
		Drone drone = droneRepo.findBySerialNumber(serialNumber);
		
		return droneMapper.modelToDto(drone);
	}

	@Override
	public AuditDTO getDroneAudit() {
		
		List<Drone> drones = droneRepo.findAll();
		
		
		List<DroneBatteryDTO> dtos= droneMapper.dronesToBatteryLog(drones);
		AuditDTO audit = new AuditDTO();
		audit.setDateTime(LocalDateTime.now());
		audit.setDrones(dtos);
		audit.setTotal(dtos.size());
		return audit;
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
