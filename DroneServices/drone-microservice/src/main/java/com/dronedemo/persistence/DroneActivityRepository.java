package com.dronedemo.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dronedemo.application.data.model.DroneActivity;
import com.dronedemo.application.data.model.DroneState;

@Repository
public interface DroneActivityRepository extends CrudRepository<DroneActivity,Long>{

	List<DroneActivity> findByDroneIdAndStateIn(String droneId,List<DroneState> states);
}
