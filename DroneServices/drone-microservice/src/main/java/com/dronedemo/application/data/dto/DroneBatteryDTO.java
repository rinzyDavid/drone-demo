package com.dronedemo.application.data.dto;

import lombok.Data;

/**
 * 
 * @author David
 *DTO class for displaying a drone's battery life
 */
public @Data class DroneBatteryDTO {
	
	private String serialNumber;
	private String model;
	private int batteryLife;

}
