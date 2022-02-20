package com.musala.coding.task.application.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.musala.coding.task.application.data.mapper.DroneMapper;
import com.musala.coding.task.application.service.DroneService;
import com.musala.coding.task.persistence.DroneRepository;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DroneServiceImplTest {
	
	@Autowired
	private DroneService droneService;
	
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
