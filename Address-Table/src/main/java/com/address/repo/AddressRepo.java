package com.address.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.address.entity.AddressEntity;

public interface AddressRepo extends JpaRepository<AddressEntity, Long> {

}
