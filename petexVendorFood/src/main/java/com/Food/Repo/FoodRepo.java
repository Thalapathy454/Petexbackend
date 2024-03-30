package com.Food.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Food.Entity.FoodEntity;

public interface FoodRepo extends JpaRepository<FoodEntity, Long> {

}
