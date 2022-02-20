package com.musala.coding.task.application.service;

import com.musala.coding.task.application.data.dto.DroneActivityDTO;
import com.musala.coding.task.application.data.dto.LoadDroneDTO;
import com.musala.coding.task.resource.api.Response;

public interface DroneActivityService {
	
	public Response loadDrone(LoadDroneDTO drontActivityDto);
	public DroneActivityDTO getDroneActivity(String serialNumber);

}
