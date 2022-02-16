package com.musala.coding.task.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musala.coding.task.application.data.dto.DroneDTO;
import com.musala.coding.task.application.service.DroneService;
import com.musala.coding.task.persistence.DroneRepository;


@Service
public class DroneServiceImpl implements DroneService{
	
	@Autowired
	private DroneRepository droneRepo;
	
	
	

	@Override
	public void registerDrone(DroneDTO droneDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DroneDTO getDrone(String serialNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DroneDTO> listDrones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DroneDTO> listAvailableDrones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DroneDTO checkBattery(String serialNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
