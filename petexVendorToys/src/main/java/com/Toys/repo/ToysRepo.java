package com.Toys.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Toys.entity.ToysEntity;

public interface ToysRepo extends JpaRepository<ToysEntity, Long> {

}
