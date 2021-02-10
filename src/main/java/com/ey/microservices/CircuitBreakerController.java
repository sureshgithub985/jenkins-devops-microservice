package com.ey.microservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

	@GetMapping("/sample-api")
	//@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
	//@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
	//@RateLimiter(name = "default")
	@Bulkhead(name = "default")
	public String getSamplApi() {

		logger.info("calling the dummy-url ");
		/*
		 * ResponseEntity<String> forEntity = new
		 * RestTemplate().getForEntity("http://localhost:8080/dummy-url", String.class);
		 */

		return "sample-api";
	}

	public String hardcodedResponse(Exception e) {
		return "hardcodedResponse from Suresh";
	}
}
