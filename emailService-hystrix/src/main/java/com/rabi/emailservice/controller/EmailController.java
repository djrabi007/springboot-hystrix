package com.rabi.emailservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emailService")
public class EmailController {

	@GetMapping("/send")
	public String sendEmail() {
		return "Email service invoked";
	}
}
