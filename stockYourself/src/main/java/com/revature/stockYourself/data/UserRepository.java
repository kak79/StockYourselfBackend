package com.revature.stockYourself.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.stockYourself.beans.Portfolio;
import com.revature.stockYourself.beans.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByEmail(String userEmail);
	public User findByUsername(String username);
	public User findByUserId(int userId);
	public User findByPortfolio(Portfolio portfolioId);

}
