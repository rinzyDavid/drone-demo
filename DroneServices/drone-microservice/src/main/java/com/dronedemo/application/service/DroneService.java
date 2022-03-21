package com.dronedemo.application.service;

import com.dronedemo.application.data.dto.AuditDTO;
import com.dronedemo.application.data.dto.AvailableDronesDTO;
import com.dronedemo.application.data.dto.DroneBatteryDTO;
import com.dronedemo.application.data.dto.DroneDTO;

public interface DroneService {
	
	public DroneDTO registerDrone(DroneDTO droneDto);
	public DroneDTO getDrone(String serialNumber);
	public AuditDTO getDroneAudit();
	public AvailableDronesDTO listAvailableDrones();
	public DroneBatteryDTO checkBattery(String serialNumber);

}
