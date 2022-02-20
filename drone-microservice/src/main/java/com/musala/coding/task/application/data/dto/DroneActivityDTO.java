package com.musala.coding.task.application.data.dto;

import java.util.List;

import lombok.Data;

/**
 * 
 * @author David
 * DTO class for displaying a drone's activity and loaded medications
 *
 */
public @Data class DroneActivityDTO {

	private int total;
	private List<LoadDroneDTO> activities;
}
