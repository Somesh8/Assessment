package com.assessment.Assessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.assessment.Assessment.exception.NotFoundException;
import com.assessment.Assessment.model.Launcher;
import com.assessment.Assessment.model.LaunchersResponse;
import com.assessment.Assessment.repository.LauncherRepository;

@Service
public class LauncherService {
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private LauncherRepository launcherRepository;

    private static final String URL = "https://isro.vercel.app/api/launchers";
//    public LauncherService(RestTemplate restTemplate, LauncherRepository launcherRepository) {
//        this.restTemplate = restTemplate;
//        this.launcherRepository = launcherRepository;
//    }

    public List<Launcher> getLaunchers() {

        LaunchersResponse response = restTemplate.getForObject(URL, LaunchersResponse.class);

        if (response != null && response.getLaunchers() != null) {
            launcherRepository.saveAll(response.getLaunchers());
        }

        return launcherRepository.findAll();
    }

	public Launcher getLauncher(String lid) {
		return launcherRepository.findById(lid).orElseThrow(
				() -> new NotFoundException("Laucher id :"+lid+" is not existing."));
	}

	public List<Launcher> getAllLaunchers() {
		return launcherRepository.findAll();
	}

	public Launcher saveLauncher(Launcher launcher) {
		return launcherRepository.save(launcher);
	}

	public Launcher updateLauncher(String lid, Launcher launcher) {
		Launcher newLauncher = Launcher.builder()
				.id(lid)
				.registeredOn(launcher.getRegisteredOn())
				.type(launcher.getType())
				.build();
		newLauncher.setId(lid);
		return launcherRepository.save(newLauncher);
	}

	public String deleteLauncher(String lid) {
		Launcher l = launcherRepository.findById(lid).get();
		launcherRepository.delete(l);
		return "Deleted";
	}
}
