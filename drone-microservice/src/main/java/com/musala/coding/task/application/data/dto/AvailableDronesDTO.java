package com.musala.coding.task.application.data.dto;

import java.util.List;

import lombok.Data;
/**
 * 
 * @author mac
 * DTO class for displaying drones available for loading
 *
 */
public @Data class AvailableDronesDTO {
	
	private int total;
	private List<DroneDTO> drones;

}
