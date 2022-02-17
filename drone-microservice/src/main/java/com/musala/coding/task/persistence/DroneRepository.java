package com.musala.coding.task.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.musala.coding.task.application.data.model.Drone;
import com.musala.coding.task.application.data.model.DroneState;

@Repository
public interface DroneRepository extends CrudRepository<Drone,String>{
	
	Drone findBySerialNumber(String serialNumber);
	List<Drone> findAll();
	
	List<Drone> findByDroneState(DroneState state);

}
