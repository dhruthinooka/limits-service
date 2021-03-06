package com.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.limitsservice.model.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigController {

	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsConfigurations()
	{
		return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
		
	}
	
	@GetMapping("/fault-tolerance")
	@HystrixCommand(fallbackMethod="fallbackRetrieveConfig")
	public LimitConfiguration retrieveConfigurations()
	{
		throw new RuntimeException("Not Available");
		
	}
	
	public LimitConfiguration fallbackRetrieveConfig()
	{
		return new LimitConfiguration(999, 9);
		
	}
}
