package com.anarghya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.anarghya.entity.Payment;
import com.anarghya.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private final PaymentRepository paymentRepository;
	


	public PaymentServiceImpl(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}


	@Override
	public Payment getfindById(Long id) {
		return paymentRepository.findById(id).orElse(null);
	}

	@Override
	public Payment savePayment(Payment payment) {
	    // Perform necessary operations to save the payment into the database
	    // For example, you might use a repository or DAO to interact with the database
	    // Here is a hypothetical implementation using a repository:
	    try {
	        Payment savedPayment = paymentRepository.save(payment);
	        return savedPayment;
	    } catch (Exception e) {
	        // Handle any exceptions that may occur during the saving process
	        e.printStackTrace();
	        return null; // Or throw a custom exception to indicate failure
	    }
	}

}