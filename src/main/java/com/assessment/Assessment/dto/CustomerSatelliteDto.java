package com.assessment.Assessment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerSatelliteDto {
	
	private String id;
	private String country;
	private String launch_date;
	private String mass;
	private String launcher;	
}
