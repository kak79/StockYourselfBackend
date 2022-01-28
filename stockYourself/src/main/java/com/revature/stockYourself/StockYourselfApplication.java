package com.revature.stockYourself;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;

@SpringBootApplication
public class StockYourselfApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StockYourselfApplication.class, args);

	}
}

