package com.diego.hrpayroll.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.diego.hrpayroll.model.Payment;
import com.diego.hrpayroll.model.Worker;

@Service
public class PaymentService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${hr-worker.host}")
	private String workerRost;
	
	public Payment getPayment(Long workerId, int days) {
		var uriVariables = new HashMap<String, String>();
		uriVariables.put("id", ""+workerId);
		
		var worker = restTemplate.getForObject(workerRost + "/workers/{id}", Worker.class, uriVariables);
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
