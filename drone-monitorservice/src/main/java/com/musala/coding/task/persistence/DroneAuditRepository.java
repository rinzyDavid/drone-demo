package com.musala.coding.task.persistence;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.musala.coding.task.application.model.DroneAudit;

public interface DroneAuditRepository extends MongoRepository<DroneAudit,String>{

	List<DroneAudit> findAll();
}
