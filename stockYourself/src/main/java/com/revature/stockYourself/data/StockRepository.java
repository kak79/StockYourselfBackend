package com.revature.stockYourself.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.stockYourself.beans.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{
	public Stock findByName(String stockName);
}
