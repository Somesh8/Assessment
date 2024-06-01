package com.assessment.Assessment.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.Assessment.dto.LaucherDto;
import com.assessment.Assessment.model.Launcher;
import com.assessment.Assessment.model.Launcher.LauncherType;
import com.assessment.Assessment.service.LauncherService;



@RestController
@RequestMapping("/launcher")
public class LauncherController {
	
	@Autowired
	private LauncherService launcherService;

	@GetMapping("/getdata")
	public List<Launcher> getLaunchers() {
		return launcherService.getLaunchers();
	}
	
	@GetMapping()
	public List<Launcher> getAllLaunchers() {
		return launcherService.getAllLaunchers();
	}
	
	@GetMapping("/get/{lid}")
	public Launcher getLauncher(@PathVariable String lid) {
		return launcherService.getLauncher(lid);
	}
	
	@PostMapping()
	public Launcher saveLauncher(@RequestBody LaucherDto launcherDto) {
		return launcherService.saveLauncher(getLauncherFromDto(launcherDto));
	}
	
	@PutMapping("/{lid}")
	public Launcher updateLauncher(@PathVariable String lid, @RequestBody LaucherDto launcherDto) {
		return launcherService.updateLauncher(lid, getLauncherFromDto(launcherDto));
	}

	@DeleteMapping("/{lid}")
	public String deleteLauncher(@PathVariable String lid) {
		return launcherService.deleteLauncher(lid);
	}
	
	
	private Launcher getLauncherFromDto(LaucherDto launcherDto) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse(launcherDto.getRegisteredOn(), formatter);
		Launcher launcher = Launcher.builder()
			.id(launcherDto.getId())
			.registeredOn(date)
			.type(Launcher.LauncherType.valueOf(launcherDto.getType()) )
			.build();
		return launcher;
	}
}
