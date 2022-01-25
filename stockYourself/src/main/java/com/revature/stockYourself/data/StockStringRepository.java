package com.revature.stockYourself.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.stockYourself.beans.StockString;
import com.revature.stockYourself.beans.User;


@Repository
public interface StockStringRepository extends JpaRepository<StockString, Integer>{
	public StockString findBystockString(StockString stockString);
}
