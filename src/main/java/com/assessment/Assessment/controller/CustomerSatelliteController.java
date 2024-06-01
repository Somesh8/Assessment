package com.assessment.Assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.Assessment.dto.CustomerSatelliteDto;
import com.assessment.Assessment.model.CustomerSatellite;
import com.assessment.Assessment.service.CustomerSatelliteService;


@RestController
@RequestMapping("/satellite")
public class CustomerSatelliteController {

	@Autowired
	private CustomerSatelliteService service;
	
	@GetMapping("/getdata")
	public List<CustomerSatellite> getAll() {
		return service.getlists();
	}
	
	@GetMapping()
	public List<CustomerSatellite> getAllCustomerSatellites() {
		return service.getAllCustomerSatellites();
	}
	
	@GetMapping("/search")
	public List<CustomerSatellite> searchCustomerSatellites(@RequestParam final String q) {
		return service.searchCustomerSatellites(q);
	}
	
	@GetMapping("/get/{cid}")
	public CustomerSatellite getCustomerSatellite(@PathVariable String cid) {
		return service.getCustomerSatellite(cid);
	}
	
	@PostMapping()
	public CustomerSatellite saveCustomerSatellite(@RequestBody CustomerSatelliteDto customerSatellite) {
		return service.saveCustomerSatellite(customerSatellite);
	}
	
	@PutMapping("/{cid}")
	public CustomerSatellite updateCustomerSatellite(@PathVariable String cid, @RequestBody CustomerSatelliteDto customerSatellite) {
		return service.updateCustomerSatellite(cid, customerSatellite);
	}

	@DeleteMapping("/{cid}")
	public String deleteCustomerSatellite(@PathVariable String cid) {
		return service.deleteCustomerSatellite(cid);
	}
	

}
