package com.musala.coding.task.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.musala.coding.task.application.data.model.DroneActivity;
import com.musala.coding.task.application.data.model.DroneState;

@Repository
public interface DroneActivityRepository extends CrudRepository<DroneActivity,Long>{

	List<DroneActivity> findByDroneIdAndStateIn(String droneId,List<DroneState> states);
}
