package com.revature.stockYourself.services;

import java.util.List;
import java.util.Map;

import com.revature.stockYourself.beans.Portfolio;
import com.revature.stockYourself.beans.Post;
import com.revature.stockYourself.beans.StockData;
import com.revature.stockYourself.beans.StockString;
import com.revature.stockYourself.beans.User;
import com.revature.stockYourself.exceptions.IncorrectCredentialsException;
import com.revature.stockYourself.exceptions.UsernameAlreadyExistsException;

import yahoofinance.Stock;

public interface UserService {
	public User register(User newUser) throws UsernameAlreadyExistsException;
	public User logIn(String username, String password) throws IncorrectCredentialsException;
	public User getUserById(int id);
	public StockData getStockInfo(StockString stockName)throws Exception;
	public Map<String,Stock> getListOfStocks(Portfolio port) throws Exception;
	public Portfolio addStockToPortfolio(Portfolio ExistingPort,StockString stockString);
	public Portfolio removeStockFromPortfolio(Portfolio ExistingPort,StockString remStockString)
	public Post createPost(Post newPost);
	public Post updatePost(Post existingPost);
	public List<Post> getAllPosts();
	public List<Post> getAllPostsByCreator(User creator);
	public List<Post> getAllPostsByPortfolio(Portfolio portfolioPostedOn);
}