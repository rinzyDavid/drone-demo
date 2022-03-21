package com.dronedemo.application.service.impl;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.dronedemo.application.service.DroneActivityService;
import com.dronedemo.application.service.MedicationService;

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
