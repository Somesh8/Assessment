package com.assessment.Assessment.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Launcher {
	@Id
	private String id;
	
	private LauncherType type;

    private LocalDate registeredOn;

	public static enum LauncherType {
	    NEW, OLD, DEGRADED
	}

}
