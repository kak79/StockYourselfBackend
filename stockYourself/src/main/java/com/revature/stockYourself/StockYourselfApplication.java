package com.revature.stockYourself;

import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.stockYourself.beans.Portfolio;
import com.revature.stockYourself.services.UserService;

import yahoofinance.Stock;

@SpringBootApplication
public class StockYourselfApplication {
	private static UserService userServ;
	public static void main(String[] args) throws Exception {
		
		
		
		Portfolio port = new Portfolio();
		Map<String, Stock> stock = userServ.getListOfStocks(port.getPortfolioStringStocks());
		System.out.println(stock);
//		SpringApplication.run(StockYourselfApplication.class, args);
//	}
//
//	@Bean
//	public YahooFinance corsConfigurer() {
//		return new YahooFinance();
	}

}
