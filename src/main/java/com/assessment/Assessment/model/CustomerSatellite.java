package com.assessment.Assessment.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerSatellite {
	
	@Id
	private String id;
	private String country;
	private LocalDate launch_date; 
	private String mass;
//	private String launcher;
	@ManyToOne
	private Launcher launcher;
	
}
