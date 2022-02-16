package com.musala.coding.task.application.data.model;

import javax.persistence.*;
import lombok.Data;


/**
 * 
 * @author mac
 * Entity class to map drone activity when the drone is been loaded
 *
 */

@Entity
@Table(name="drone_activity")
public @Data class DroneActivity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="drone_id")
	private String droneId;
	
	@Column(name="medication_id")
	private Long medicationId;
	
	@Column(name="quantity_loaded")
	private Integer quantity;
	
	@Column(name="max_weight_loaded")
	private Double weightLoaded;
	
	@Column(name="destinationm_address",columnDefinition="TEXT")
	private String address;

}
