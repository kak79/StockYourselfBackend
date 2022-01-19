package com.revature.stockYourself;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.stockYourself.beans.Stock;

import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;

@SpringBootApplication
public class StockYourselfApplication {

	public static void main(String[] args) throws Exception {
		//SpringApplication.run(StockYourselfApplication.class, args);
		/*yahoofinance.Stock stock = YahooFinance.get("AAPL");
		yahoofinance.Stock stock2 = YahooFinance.get("GOOG");
		BigDecimal price = stock.getQuote(true).getPrice();
		System.out.println(price.doubleValue());
		BigDecimal price2 = stock.getQuote(true).getPrice();
		System.out.println(stock2.getQuote().toString());
		System.out.println(stock.getQuote().toString());
	
		System.out.println(price.add(price2));
		*/
		Calendar to = Calendar.getInstance();
		to.set(2021, 8, 2);
		Calendar from = Calendar.getInstance();
		from.add(Calendar.YEAR, -5);
		yahoofinance.Stock apple = YahooFinance.get("AAPL", from, to, Interval.WEEKLY);
		System.out.println(apple);
		/*
		yahoofinance.Stock tesla = YahooFinance.get("TSLA", true);
		System.out.println(tesla.getHistory());*/
	}

}
