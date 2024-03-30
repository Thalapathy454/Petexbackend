package com.anarghya.service;

import com.anarghya.entity.Payment;

public interface PaymentService {

	Payment savePayment(Payment payment);
	
	Payment getfindById(Long id);
}
