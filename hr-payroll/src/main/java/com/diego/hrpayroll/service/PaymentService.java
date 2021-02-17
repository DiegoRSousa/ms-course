package com.diego.hrpayroll.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.diego.hrpayroll.model.Payment;

@Service
public class PaymentService {

	public Payment getPayment(Long workerId, int days) {
		return new Payment("Bob", new BigDecimal("200.00"), days);
	}
}
