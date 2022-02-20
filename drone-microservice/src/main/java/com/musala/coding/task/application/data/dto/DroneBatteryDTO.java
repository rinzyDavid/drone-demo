package com.musala.coding.task.application.data.dto;

import lombok.Data;

/**
 * 
 * @author mac
 *DTO class for displaying a drone's battery life
 */
public @Data class DroneBatteryDTO {
	
	private String serialNumber;
	private String model;
	private int batteryLife;

}
