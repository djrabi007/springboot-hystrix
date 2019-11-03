package com.rabi.bookmyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
@EnableHystrix
@RestController
@RequestMapping("/bookMyShow")
public class BookMyShowController {
	
	@Autowired
	RestTemplate temp;
	
	String EMAIL_SERV_URL
			="http://localhost:8181/emailService/send";
	String PAY_SERV_URL
			="http://localhost:8282/paymentService/pay";
	
	@GetMapping("/bookNowWithotHystrix")
	public String bookWithoutHystrix() {
		return serviceCall();
	}
	
	@HystrixCommand(groupKey="Rabi Techie",
			commandKey="Rabi Techie",
			fallbackMethod="showFallback")
	@GetMapping("/bookNow")
	public String bookNow() {
		return serviceCall();
	}
	
	public String showFallback() {
		return "One of the Service Down!!!";
	}
	
	private String serviceCall() {
		String EMAIL_RESP
				=temp.getForObject(EMAIL_SERV_URL, String.class);
		String PAY_RESP
				=temp.getForObject(PAY_SERV_URL, String.class);
		return EMAIL_RESP+"\n"+PAY_RESP;
	}
	@Bean
	RestTemplate myRest() {
		return new RestTemplate();
	}
	
}
