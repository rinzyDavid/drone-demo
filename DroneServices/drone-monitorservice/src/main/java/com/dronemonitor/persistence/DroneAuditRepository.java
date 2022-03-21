package com.dronemonitor.persistence;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dronemonitor.application.model.DroneAudit;

public interface DroneAuditRepository extends MongoRepository<DroneAudit,String>{

	List<DroneAudit> findAll();
}
