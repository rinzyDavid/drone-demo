package com.dronedemo.application.config;

import com.dronedemo.application.service.DroneActivityService;
import com.dronedemo.application.service.DroneService;
import com.dronedemo.application.service.MedicationService;
import com.dronedemo.application.service.impl.DroneActivityServiceImpl;
import com.dronedemo.application.service.impl.DroneServiceImpl;
import com.dronedemo.application.service.impl.MedicationServiceImpl;
import com.dronedemo.persistence.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dronedemo.application.data.mapper.DroneMapper;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;



/**
 * 
 * @author David
 *Configuration file for Bean initialization
 */

@Configuration
public class AppConfig {
	
	@Autowired
	private DroneRepository droneRepo;
	
	@Autowired
	private DroneMapper droneMapper;
	
	@Bean
	public OpenAPI customOpenAPI(@Value("${application-description}") String appDesciption,
			@Value("${application-version}") String appVersion) {

		return new OpenAPI()
				.info(new Info()
						.title("Drone Microservice APIs")
						.version(appVersion)
						.description(appDesciption)
						.termsOfService("http://swagger.io/terms/")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));

	}
	
	
	@Bean
	public DroneService droneService() {
		return new DroneServiceImpl(droneRepo,droneMapper);
	}
	
	@Bean
	public MedicationService medicationService() {
		return new MedicationServiceImpl();
	}
	
	@Bean
	public DroneActivityService activityService() {
		return new DroneActivityServiceImpl(medicationService());
	}

}
