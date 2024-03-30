package com.petex.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petex.entity.HospitalizedEntity;

public interface HospitalizedRepo extends JpaRepository<HospitalizedEntity, Integer>{

}
