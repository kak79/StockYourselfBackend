package com.revature.stockYourself;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.revature.stockYourself.beans.Portfolio;
import com.revature.stockYourself.services.UserService;
import com.revature.stockYourself.services.UserServiceImpl;

import ch.qos.logback.core.net.SyslogOutputStream;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@SpringBootApplication
public class StockYourselfApplication {
	public static void main(String[] args) throws Exception {
			SpringApplication.run(StockYourselfApplication.class, args);
		}
//
//	@Bean
//	public YahooFinance corsConfigurer() {
//		return new YahooFinance();
	}


