package com.musala.coding.task.application.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musala.coding.task.application.data.dto.DroneActivityDTO;
import com.musala.coding.task.application.data.mapper.DroneActivityMapper;
import com.musala.coding.task.application.data.model.Drone;
import com.musala.coding.task.application.data.model.DroneActivity;
import com.musala.coding.task.application.data.model.DroneState;
import com.musala.coding.task.application.service.DroneActivityService;
import com.musala.coding.task.persistence.DroneActivityRepository;
import com.musala.coding.task.persistence.DroneRepository;


@Service
public class DroneActivityServiceImpl implements DroneActivityService{
	
	
	@Autowired
	private DroneActivityRepository activityRepo;
	
	@Autowired
	private DroneActivityMapper mapper;
	
	@Autowired private DroneRepository droneRepo;
	

	@Transactional
	@Override
	public String loadDrone(DroneActivityDTO drontActivityDto) {
		
		Drone drone = droneRepo.findBySerialNumber(drontActivityDto.getSerialNumber());
		
		DroneActivity activity = mapper.dtoToActivity(drontActivityDto, drone, drontActivityDto.getMedications().stream());
		if(drone.getDroneState() != DroneState.LOADING)
			return "Drone is no longer available, please try another drone";
		
		if(activity.getWeightLoaded()>drone.getMaxWeight())
			return "The weight loaded is heavier than the drone capacity";
		
		double availableWeight = drone.getMaxWeight() - drone.getCurrentWeight();
		
		if(activity.getWeightLoaded()>availableWeight)
			return "Weight loaded is greater than available space";
		
		double totalWeight = drone.getCurrentWeight()+activity.getWeightLoaded();
		
		drone.setCurrentWeight(totalWeight);
		if(drone.getMaxWeight() == totalWeight) {
			drone.setDroneState(DroneState.LOADED);
		}
		DroneActivity _activity =activityRepo.save(activity);
		droneRepo.save(drone);
		
		return drone.getSerialNumber()+"-"+_activity.getId();
		
		
	}

	@Override
	public DroneActivityDTO getDroneActivity(String activityRef) {
		
		String[] refs = activityRef.split("-");
		if(refs.length>1) {
			
			String _id = refs[1];
			Long id = Long.parseLong(_id);
			Optional<DroneActivity> opt= activityRepo.findById(id);
			Drone drone = droneRepo.findBySerialNumber(refs[0]);
			
			if(opt.isPresent()) {
				
				return mapper.activityToDTO(opt.get(), drone, opt.get().getMedications().stream());
			}
		}
		
		
		
		return null;
	}

}
