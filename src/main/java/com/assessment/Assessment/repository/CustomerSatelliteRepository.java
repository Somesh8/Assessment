package com.assessment.Assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.Assessment.model.CustomerSatellite;

@Repository
public interface CustomerSatelliteRepository extends JpaRepository<CustomerSatellite, String>{

}
