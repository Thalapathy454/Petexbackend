package com.booking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.entity.DayCareBooking;

public interface BookRepo  extends JpaRepository<DayCareBooking, Long>{

}
