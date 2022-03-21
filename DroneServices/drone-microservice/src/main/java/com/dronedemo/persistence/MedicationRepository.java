package com.dronedemo.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dronedemo.application.data.model.Medication;

@Repository
public interface MedicationRepository extends CrudRepository<Medication,Long>{
	
	List<Medication> findAll();
	List<Medication> findAllByIdIn(List<Long> ids);

}
