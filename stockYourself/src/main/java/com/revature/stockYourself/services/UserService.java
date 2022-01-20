package com.revature.stockYourself.services;

import java.util.List;
import java.util.Map;

import com.revature.stockYourself.beans.Portfolio;
import com.revature.stockYourself.beans.Post;
import com.revature.stockYourself.beans.StockString;
import com.revature.stockYourself.beans.User;
import com.revature.stockYourself.exceptions.IncorrectCredentialsException;
import com.revature.stockYourself.exceptions.UsernameAlreadyExistsException;

import yahoofinance.Stock;

public interface UserService {
	public User register(User newUser) throws UsernameAlreadyExistsException;
	public User logIn(String username, String password) throws IncorrectCredentialsException;
	public User getUserById(int id);
	public yahoofinance.Stock getStockByStockname(String stockname) throws Exception;
	public Map<String, Stock> getListOfStocks(List<StockString> listOfStocknames)throws Exception;
	public Stock getStockHistoryWeekly(String stockname,int years) throws Exception;
	public Portfolio addStockToPortfolio(User user,StockString stock);
	public Portfolio removeStockToPortfolio(User user,StockString stock);
	public Post createPost(Post newPost);
	public Post updatePost(Post existingPost);
	public List<Post> getAllPosts();
	public List<Post> getAllPostsByCreator(User creator);
	public List<Post> getAllPostsByPortfolio(Portfolio portfolioPostedOn);
}