package com.ey.microservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ey.microservices.entity.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	public CurrencyExchange findByfromAndTo(String from, String to);
}

