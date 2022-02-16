package com.musala.coding.task.application.service;

import java.util.List;

import com.musala.coding.task.application.data.dto.DroneDTO;

public interface DroneService {
	
	public void registerDrone(DroneDTO droneDto);
	public DroneDTO getDrone(String serialNumber);
	public List<DroneDTO> listDrones();
	public List<DroneDTO> listAvailableDrones();
	public DroneDTO checkBattery(String serialNumber);

}
