package com.slotBooking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slotBooking.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
