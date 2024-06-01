package com.assessment.Assessment.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.assessment.Assessment.dto.CustomerSatelliteDto;
import com.assessment.Assessment.exception.NotFoundException;
import com.assessment.Assessment.model.CustomerSatellite;
import com.assessment.Assessment.model.CustomerSatelliteResponse;
import com.assessment.Assessment.model.Launcher;
import com.assessment.Assessment.repository.CustomerSatelliteRepository;

@Service
public class CustomerSatelliteService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CustomerSatelliteRepository repository;

	@Autowired
	private LauncherService launcherService;
	
	
	public static final String URL = "https://isro.vercel.app/api/customer_satellites";

	public List<CustomerSatellite> getlists() {
		
		CustomerSatelliteResponse response = restTemplate.getForObject(URL, CustomerSatelliteResponse.class);
		if (response != null && response.getCustomer_satellites() != null) {
			for( CustomerSatelliteDto csDto: response.getCustomer_satellites()) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDate date = LocalDate.parse(csDto.getLaunch_date(), formatter);
				
				Launcher launcher = launcherService.getLauncher(csDto.getLauncher());
				System.out.println("Laucher "+ launcher);
				
				CustomerSatellite cs = CustomerSatellite.builder()
					.country(csDto.getCountry())
					.id(csDto.getId())
					.launch_date(date)
					.launcher(launcher)
					.mass(csDto.getMass())
					.build();
				repository.save(cs);
			}
        }
		return repository.findAll();
	}

	public List<CustomerSatellite> getAllCustomerSatellites() {
		return repository.findAll();
	}
	
	public List<CustomerSatellite> searchCustomerSatellites(String q) {
		List<CustomerSatellite> allData = repository.findAll();
		List<CustomerSatellite> data = allData.stream()
			.filter((cSat) -> cSat.getCountry().contains(q) || cSat.getId().contains(q) || cSat.getMass().contains(q)
					|| cSat.getLauncher().getId().contains(q) || cSat.getLaunch_date().toString().contains(q))
			.collect(Collectors.toList());	
		return data;
	}

	public CustomerSatellite getCustomerSatellite(String cid) {
		return repository.findById(cid).orElseThrow(
				() -> new NotFoundException("Satellite id :"+cid+" is not existing."));
	}

	public CustomerSatellite saveCustomerSatellite(CustomerSatelliteDto customerSatelliteDto) {
		CustomerSatellite cSatellite = getLauncherFromDto(customerSatelliteDto);
		return repository.save(cSatellite);
	}

	public CustomerSatellite updateCustomerSatellite(String cid, CustomerSatelliteDto customerSatelliteDto) {
		customerSatelliteDto.setId(cid);
		CustomerSatellite cSatellite = getLauncherFromDto(customerSatelliteDto);
		return repository.save(cSatellite);
	}

	public String deleteCustomerSatellite(String cid) {
		CustomerSatellite cSatellite = repository.findById(cid).orElseThrow(
				() -> new NotFoundException("Satellite id :"+cid+" is not existing."));
		repository.delete(cSatellite);
		return "Deleted";
	}
	
	private CustomerSatellite getLauncherFromDto(CustomerSatelliteDto dto) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse(dto.getLaunch_date(), formatter);
		Launcher launcher = launcherService.getLauncher(dto.getLauncher());
		
		CustomerSatellite cSatellite = CustomerSatellite.builder()
				.id(dto.getId())
				.country(dto.getCountry())
				.launch_date(date)
				.mass(dto.getMass())
				.launcher(launcher)
				.build();
		return cSatellite;
	}
}
