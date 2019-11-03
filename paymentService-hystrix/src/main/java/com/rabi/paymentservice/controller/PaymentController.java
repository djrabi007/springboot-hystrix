package com.rabi.paymentservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paymentService")
public class PaymentController {

	@GetMapping("/pay")
	public String paymentProcess() {
		return "Payment service invoked";
	}
}
