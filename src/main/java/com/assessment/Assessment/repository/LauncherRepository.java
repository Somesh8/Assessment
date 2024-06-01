package com.assessment.Assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.Assessment.model.Launcher;

@Repository
public interface LauncherRepository extends JpaRepository<Launcher, String>{

}
