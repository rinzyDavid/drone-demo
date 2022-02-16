package com.musala.coding.task.application.service;

import com.musala.coding.task.application.data.dto.DroneActivityDTO;

public interface DroneActivityService {
	
	public void loadDrone(DroneActivityDTO drontActivityDto);
	public DroneActivityDTO getDroneActivity(String serialNumber);

}
