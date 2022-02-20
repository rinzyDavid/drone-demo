package com.musala.coding.task.application.model;

import org.springframework.data.annotation.Id;

import lombok.Data;

public @Data class DroneBatteryLog {
	
	@Id
	private String id;
	private String droneModel;
	private String serialNumber;
	private Integer batteryLife;

}
