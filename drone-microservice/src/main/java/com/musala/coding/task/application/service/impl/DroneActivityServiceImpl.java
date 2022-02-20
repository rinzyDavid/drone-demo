package com.musala.coding.task.application.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import com.musala.coding.task.application.data.dto.DroneActivityDTO;
import com.musala.coding.task.application.data.dto.LoadDroneDTO;
import com.musala.coding.task.application.data.mapper.DroneActivityMapper;
import com.musala.coding.task.application.data.model.Drone;
import com.musala.coding.task.application.data.model.DroneActivity;
import com.musala.coding.task.application.data.model.DroneState;
import com.musala.coding.task.application.data.model.Medication;
import com.musala.coding.task.application.service.DroneActivityService;
import com.musala.coding.task.application.service.MedicationService;
import com.musala.coding.task.persistence.DroneActivityRepository;
import com.musala.coding.task.persistence.DroneRepository;
import com.musala.coding.task.resource.api.Response;

/**
 * 
 * @author mac
 * 
 *A concrete implementation of  DroneActivityService
 */

public class DroneActivityServiceImpl implements DroneActivityService{
	
	
	@Autowired
	private DroneActivityRepository activityRepo;
	
	@Autowired
	private DroneActivityMapper mapper;
	
	@Autowired private DroneRepository droneRepo;
	
	private MedicationService medService;
	
	@Autowired
	public DroneActivityServiceImpl(MedicationService medService) {
		this.medService = medService;
	}
	
	
	/**
	 * This function will perform the following actions
	 * 1. Find the drone with the serial number
	 * 2. Check if the drone is in loading state
	 * 3. Check if the total weight loaded is heavier than the drone capacity. Though this check is performed using bean validation api,
	 * but just to perform additional check;
	 * 4. Check if the weight loaded is heavier than the available space. Might happen when the drone is partially loaded
	 * 5. Load the drone and update drone status if necessary
	 * 
	 * @param drontActivityDto DroneActivityDTO object
	 */

	@Transactional
	@Override
	public Response loadDrone(LoadDroneDTO drontActivityDto) {
		//Get the drone
		Drone drone = droneRepo.findBySerialNumber(drontActivityDto.getSerialNumber());
		
		if(drone == null)
			return parseResponse("Drone does not exist. Check the serial number","error");
		
		List<Medication> meds = medService.createMedication(drontActivityDto.getMedications());
		
		
		DroneActivity activity = mapper.dtoToActivity(drontActivityDto, drone);
		
		//Perform checks
		if(drone.getDroneState() != DroneState.LOADING)
			return parseResponse("Drone is fully loaded and no longer available, please try another drone","error");
		
		if(activity.getWeightLoaded()>drone.getMaxWeight())
			return parseResponse("The weight loaded is heavier than the drone capacity","error");
		
		double availableWeight = drone.getMaxWeight() - drone.getCurrentWeight();
		
		if(activity.getWeightLoaded()>availableWeight)
			return parseResponse("Weight loaded is greater than available space","error");
		
		double totalWeight = drone.getCurrentWeight()+activity.getWeightLoaded();
		
		//Load drone and update status
		
		drone.setCurrentWeight(totalWeight);
		if(drone.getMaxWeight() == totalWeight) {
			drone.setDroneState(DroneState.LOADED);
		}
		activity.setState(drone.getDroneState());
		activity.setMedications(meds);
		activityRepo.save(activity);
		droneRepo.save(drone);
		
		return parseResponse(drone.getSerialNumber(),"OK");
		
		
	}
	
	private Response parseResponse(String res,String status) {
		Response resp = new Response();
		resp.setData(res);
		resp.setStatus(status);
		return resp;
		
	}

	/**
	 * This function will load the activities of a given drone using it's serial number if the drone is in
	 * LOADING OR LOADED state.
	 * 
	 * @param serialnumber
	 */
	
	@Override
	public DroneActivityDTO getDroneActivity(String serialnumber) {
		
		
		Drone drone = droneRepo.findBySerialNumber(serialnumber);
		List<DroneState> states = new ArrayList<>();
		states.add(DroneState.LOADING);
		states.add(DroneState.LOADED);
		
		
		List<DroneActivity> activities = activityRepo.findByDroneIdAndStateIn(serialnumber, states);
		System.out.println(activities);
		List<LoadDroneDTO> loadedActivities = new ArrayList<>();
		activities.forEach(activity->{
			loadedActivities.add(mapper.activityToDTO(activity, drone, activity.getMedications().stream()));
			
		});
		
		
		DroneActivityDTO dto = new DroneActivityDTO();
		dto.setTotal(activities.size());
		dto.setActivities(loadedActivities);
		
		return dto;
	}

}
