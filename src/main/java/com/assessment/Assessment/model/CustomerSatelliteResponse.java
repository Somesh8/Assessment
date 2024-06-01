package com.assessment.Assessment.model;

import java.util.List;

import com.assessment.Assessment.dto.CustomerSatelliteDto;

public class CustomerSatelliteResponse {
	
	private List<CustomerSatelliteDto> customer_satellites;

	public List<CustomerSatelliteDto> getCustomer_satellites() {
		return customer_satellites;
	}

	public void setCustomer_satellites(List<CustomerSatelliteDto> customer_satellites) {
		this.customer_satellites = customer_satellites;
	}

}
