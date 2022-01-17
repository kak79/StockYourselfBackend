package com.revature.stockYourself.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.stockYourself.beans.Portfolio;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> {
	public Portfolio findByPortfolioId(int profolioId);
	

}
