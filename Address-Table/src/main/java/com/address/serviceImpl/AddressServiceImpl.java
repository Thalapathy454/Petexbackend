package com.address.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.address.entity.AddressEntity;
import com.address.repo.AddressRepo;
import com.address.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Override
    public Boolean saveAddress(AddressEntity entity) {
        addressRepo.save(entity);
        return true;
    }
}
