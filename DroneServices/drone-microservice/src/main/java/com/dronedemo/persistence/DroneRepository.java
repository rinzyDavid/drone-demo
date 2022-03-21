package com.dronedemo.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dronedemo.application.data.model.Drone;
import com.dronedemo.application.data.model.DroneState;

@Repository
public interface DroneRepository extends CrudRepository<Drone,String>{
	
	Drone findBySerialNumber(String serialNumber);
	List<Drone> findAll();
	
	List<Drone> findByDroneState(DroneState state);

}
