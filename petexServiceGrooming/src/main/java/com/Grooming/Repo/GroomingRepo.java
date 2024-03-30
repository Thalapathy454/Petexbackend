package com.Grooming.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Grooming.entity.Grooming;

public interface GroomingRepo extends JpaRepository<Grooming, Long> {

}
