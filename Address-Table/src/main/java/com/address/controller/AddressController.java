package com.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.address.entity.AddressEntity;
import com.address.service.AddressService;

@RestController
@CrossOrigin(origins="http://localhost:3000/")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("save")
    public ResponseEntity<String> saveAddress(@RequestBody AddressEntity addressEntity) {
        boolean saved = addressService.saveAddress(addressEntity);
        
        if (saved) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Address saved successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save address");
        }
    }
}
