package com.krixy.springboot.microservice.example.forex.sbmstutor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.krixy.springboot.microservice.example.forex.sbmstutor.model.ExchangeValue;
import com.krixy.springboot.microservice.example.forex.sbmstutor.model.ExchangeValueRepository;

@RestController
public class ForexService {
	
	@Autowired
	private ExchangeValueRepository exchangeValueRepository;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue calculateExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		ExchangeValue result = exchangeValueRepository.findByFromAndTo(from, to);
		
		result.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		
		return result;
	}
	
	
	
	
}
