package com.traintraining.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.traintraining.entity.Trainning;
@Repository
public interface TrainingRepo extends JpaRepository<Trainning, Long> {

}
