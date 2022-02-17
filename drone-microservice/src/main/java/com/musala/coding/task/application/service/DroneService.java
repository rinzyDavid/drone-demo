package com.musala.coding.task.application.service;

import java.util.List;

import com.musala.coding.task.application.data.dto.AvailableDronesDTO;
import com.musala.coding.task.application.data.dto.DroneBatteryDTO;
import com.musala.coding.task.application.data.dto.DroneDTO;

public interface DroneService {
	
	public DroneDTO registerDrone(DroneDTO droneDto);
	public DroneDTO getDrone(String serialNumber);
	public List<DroneDTO> listDrones();
	public AvailableDronesDTO listAvailableDrones();
	public DroneBatteryDTO checkBattery(String serialNumber);

}
