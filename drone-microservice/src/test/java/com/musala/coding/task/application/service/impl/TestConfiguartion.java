package com.musala.coding.task.application.service.impl;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.musala.coding.task.application.service.DroneActivityService;
import com.musala.coding.task.application.service.DroneService;
import com.musala.coding.task.application.service.MedicationService;

@TestConfiguration
class TestConfiguartion {

	
	
	@Bean
	public MedicationService medicationService() {
		return new MedicationServiceImpl();
	}
	
	@Bean
	public DroneActivityService activityService() {
		return new DroneActivityServiceImpl(medicationService());
	}
}
