package com.Clothing.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Clothing.Entity.ClothEntity;

public interface ClothingRepo extends JpaRepository<ClothEntity, Long> {

}
