package com.musala.coding.task.application.data.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * 
 * @author mac
 *Entity class to map medications in database
 */

@Entity
@Table(name="medications")
public @Data class Medication {
	
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "medication_name")
	@NotNull()
	private String name;
	
	@Column(name ="weight")
	private Double weight;
	
	@Column(name="medication_code")
	private String code;
	
	@Column(name ="picture_url")
	private String image;

}
