package com.revature.stockYourself.services;

import java.io.IOException;
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
	public Stock getStock(String stockname) throws IOException;
	public StockData getStockInfo(StockString stockName)throws Exception;
	public List<StockString> getPortfolio(Portfolio port) ;
	public Portfolio addStockToPortfolio(Portfolio ExistingPort,StockString stockString);
	public Portfolio removeStockFromPortfolio(Portfolio ExistingPort,StockString remStockString);
	public Post createPost(Post newPost);
	public Post updatePost(Post existingPost);
	public List<Post> getAllPosts();
	public List<Post> getAllPostsByCreator(User creator);
	public List<Post> getAllPostsByPortfolio(Portfolio portfolioPostedOn);
	public Map<String, Stock> getListOfStocks(List<StockString> portfolioStringStocks);
}