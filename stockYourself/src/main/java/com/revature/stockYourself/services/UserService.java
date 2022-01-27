package com.revature.stockYourself.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.revature.stockYourself.beans.Portfolio;
import com.revature.stockYourself.beans.Post;
import com.revature.stockYourself.beans.StockString;
import com.revature.stockYourself.beans.User;
import com.revature.stockYourself.exceptions.CouldNotFindAllPostsException;
import com.revature.stockYourself.exceptions.CreatorWasNullException;
import com.revature.stockYourself.exceptions.IncorrectCredentialsException;
<<<<<<< HEAD
import com.revature.stockYourself.exceptions.PortfolioEnteredWasNull;
import com.revature.stockYourself.exceptions.PostDoesNotExistInDatabaseException;
import com.revature.stockYourself.exceptions.PostEnteredWasNullException;
=======
import com.revature.stockYourself.exceptions.PostAndOrUserWasNull;
import com.revature.stockYourself.exceptions.PostDoesNotExistInDatabaseException;
import com.revature.stockYourself.exceptions.PostEnteredWasNullException;
import com.revature.stockYourself.exceptions.UserIsNotThePostCreatorException;
>>>>>>> fe6365e99fbb451a8fe44e9fb3e29719342c4890
import com.revature.stockYourself.exceptions.UsernameAlreadyExistsException;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public interface UserService {
	public User register(User newUser) throws UsernameAlreadyExistsException;
	public User logIn(String username, String password) throws IncorrectCredentialsException;
	public User getUserById(int id);
//	public Stock getStock(String stockname) throws IOException;
//	public StockData getStockInfo(StockString stockName)throws Exception;
	public List<StockString> getPortfolio(Portfolio port) ;
//	public Portfolio addStockToPortfolio(Portfolio ExistingPort,StockString stockString);
//	public Portfolio removeStockFromPortfolio(Portfolio ExistingPort,StockString remStockString);
	public Post createPost(Post newPost);
<<<<<<< HEAD
	public Post updatePost(Post existingPost) throws PostDoesNotExistInDatabaseException, PostEnteredWasNullException;
	public List<Post> getAllPosts() throws CouldNotFindAllPostsException;
	public List<Post> getAllPostsByCreator(User creator) throws CreatorWasNullException;
	public List<Post> getAllPostsByPortfolio(Portfolio portfolioPostedOn) throws CreatorWasNullException;
	public void deletePost(Post postToDelete, User loggedInUser) throws UserIsNotThePostCreatorException, PostAndOrUserWasNull;
	public yahoofinance.Stock getStockByStockname(String stockname) throws Exception;
	public Map<String, Stock> getListOfStocks(String[] listOfStocknames)throws Exception;
	public Stock getStockHistoryWeekly(String stockname,int years) throws Exception;
<<<<<<< HEAD
	public Portfolio addStockToPortfolio(User user,StockString stock);
	public Portfolio removeStockToPortfolio(User user,StockString stock);
	public Post createPost(Post newPost);
	public Post updatePost(Post existingPost) throws PostDoesNotExistInDatabaseException, PostEnteredWasNullException;
	public List<Post> getAllPosts() throws CouldNotFindAllPostsException;
	public List<Post> getAllPostsByCreator(User creator) throws CreatorWasNullException;
	public List<Post> getAllPostsByPortfolio(Portfolio portfolioPostedOn) throws PortfolioEnteredWasNull;
	public Map<String, Stock> getListOfStocks(String[] listOfStocknames) throws Exception;
}
=======
}
>>>>>>> 6fb72ffccb81b8ccf41dbea5629265934019aeff
=======
	public Post updatePost(Post existingPost);
	public List<Post> getAllPosts();
	public List<Post> getAllPostsByCreator(User creator);
	public List<Post> getAllPostsByPortfolio(Portfolio portfolioPostedOn);
	public Map<String, Stock> getListOfStocks(List<StockString> portfolioStringStocks);
}
>>>>>>> f331e7c1e88b38598166930f13edcd170d229e78
