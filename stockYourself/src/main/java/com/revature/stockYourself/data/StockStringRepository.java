package com.revature.stockYourself.data;

import org.springframework.stereotype.Repository;

import com.revature.stockYourself.beans.StockString;


@Repository
public interface StockStringRepository {
	public StockString findByStockName(StockString stock);
}
