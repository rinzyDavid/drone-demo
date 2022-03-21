package com.dronedemo.application.data.dto;

import java.util.List;

import lombok.Data;
/**
 * 
 * @author David
 * DTO class for displaying drones available for loading
 *
 */
public @Data class AvailableDronesDTO {
	
	private int total;
	private List<DroneDTO> drones;

}
