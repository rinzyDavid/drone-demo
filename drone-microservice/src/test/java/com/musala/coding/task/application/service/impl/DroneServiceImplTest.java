package com.musala.coding.task.application.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.musala.coding.task.application.data.dto.AvailableDronesDTO;
import com.musala.coding.task.application.data.dto.DroneDTO;
import com.musala.coding.task.application.data.model.DroneModel;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class DroneServiceImplTest {
	
	
	@Autowired
	private DroneServiceImpl droneService;
	
	
	private DroneDTO droneDTO;
	
	@BeforeAll
	public void setup() {
		droneDTO = new DroneDTO();
		droneDTO.setBatteryLife(100);
		droneDTO.setDroneModel(DroneModel.Heavyweight);
		droneDTO.setMaxWeight(500.0);
		droneDTO.setSerialNumber("110110TEST");
		
		
		
	}
	
	
	@Test
	void test_whenregisterdrone_returnsdto() {
		
		DroneDTO _dto = droneService.registerDrone(droneDTO);
		Assertions.assertNotNull(_dto.getSerialNumber());
		
	}
	
	
	@Test
	void whenavailableDrones_returnsList() {
		
		AvailableDronesDTO availableDrones = droneService.listAvailableDrones();
		Assertions.assertNotNull(availableDrones);
		
		Assertions.assertNotNull(availableDrones.getDrones());
		
		assertThat(availableDrones.getDrones()).isNotEmpty();
	}
	
	@Test
	void when_given_serialnumber_returns_droneDTO() {
		
		droneDTO = new DroneDTO();
		droneDTO.setBatteryLife(100);
		droneDTO.setDroneModel(DroneModel.Heavyweight);
		droneDTO.setMaxWeight(500.0);
		droneDTO.setSerialNumber("110110TEST2");
		
		
		droneService.registerDrone(droneDTO);
		DroneDTO dto = droneService.getDrone("110110TEST2");
		assertThat(dto.getSerialNumber()).isEqualTo(droneDTO.getSerialNumber());
	}
	
	

}
