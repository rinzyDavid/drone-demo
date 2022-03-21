package com.dronedemo.application.service;

import com.dronedemo.application.data.dto.DroneActivityDTO;
import com.dronedemo.application.data.dto.LoadDroneDTO;
import com.dronedemo.resource.api.Response;

public interface DroneActivityService {
	
	public Response loadDrone(LoadDroneDTO drontActivityDto);
	public DroneActivityDTO getDroneActivity(String serialNumber);

}
