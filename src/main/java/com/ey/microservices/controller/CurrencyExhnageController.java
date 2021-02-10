package com.ey.microservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ey.microservices.CurrencyExchangeRepository;
import com.ey.microservices.entity.CurrencyExchange;

@RestController
public class CurrencyExhnageController {

	private Logger logger = LoggerFactory.getLogger(CurrencyExhnageController.class);

	@Autowired
	private Environment env;

	@Autowired
	private CurrencyExchangeRepository currencyRepository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getCurrencyData(@PathVariable("from") String from, @PathVariable("to") String to) {

		logger.info("Called currecny Exchange Controller {} to {} ", from, to);

		CurrencyExchange findByfromAndTo = currencyRepository.findByfromAndTo(from, to);
		if (findByfromAndTo == null)
			throw new RuntimeException("Resource Not Found");

		String port = env.getProperty("server.port");
		findByfromAndTo.setEnviorment(port);

		return findByfromAndTo;
	}
}
