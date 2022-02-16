package com.musala.coding.task.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.musala.coding.task.application.data.model.Drone;

@Repository
public interface DroneRepository extends CrudRepository<Drone,String>{

}
