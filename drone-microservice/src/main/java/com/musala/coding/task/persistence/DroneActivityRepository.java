package com.musala.coding.task.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.musala.coding.task.application.data.model.DroneActivity;

@Repository
public interface DroneActivityRepository extends CrudRepository<DroneActivity,Long>{

	
}
