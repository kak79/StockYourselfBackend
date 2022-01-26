package com.revature.stockYourself.services;

<<<<<<< HEAD
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
=======
>>>>>>> 6fb72ffccb81b8ccf41dbea5629265934019aeff
import java.util.Map;




import com.revature.stockYourself.beans.User;
<<<<<<< HEAD
import com.revature.stockYourself.data.PortfolioRepository;
import com.revature.stockYourself.data.PostRepository;
import com.revature.stockYourself.data.UserRepository;
import com.revature.stockYourself.exceptions.CouldNotFindAllPostsException;
import com.revature.stockYourself.exceptions.CreatorWasNullException;
=======
>>>>>>> 6fb72ffccb81b8ccf41dbea5629265934019aeff
import com.revature.stockYourself.exceptions.IncorrectCredentialsException;
import com.revature.stockYourself.exceptions.PortfolioEnteredWasNull;
import com.revature.stockYourself.exceptions.PostDoesNotExistInDatabaseException;
import com.revature.stockYourself.exceptions.PostEnteredWasNullException;
import com.revature.stockYourself.exceptions.UsernameAlreadyExistsException;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;

import java.util.Calendar;

public class UserServiceImpl implements UserService {

	@Override
	public User register(User newUser) throws UsernameAlreadyExistsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User logIn(String username, String password) throws IncorrectCredentialsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stock getStockByStockname(String stockname) throws Exception {
		Stock stock = YahooFinance.get(stockname);
		return stock;
	}

	@Override
	public Map<String, Stock> getListOfStocks(String[] listOfStocknames) throws Exception {
		Map<String, Stock> stocks = YahooFinance.get(listOfStocknames);
		return stocks;
	}

	@Override
	public Stock getStockHistoryWeekly(String stockname,int years) throws Exception {
		Calendar from = Calendar.getInstance();
		Calendar to = Calendar.getInstance();
		from.add(Calendar.YEAR, -years);
		Stock stock = YahooFinance.get(stockname, from, to, Interval.WEEKLY);
		return stock;
	}
	
	

<<<<<<< HEAD
	@Override
	@Transactional
	public Post createPost(Post newPost) {
		 if (newPost != null) {
			 postRepo.save(newPost);
		 }
		return null;
	}

	@Override
	@Transactional
	public Post updatePost(Post existingPost) throws PostDoesNotExistInDatabaseException, PostEnteredWasNullException {
		if(existingPost != null) {
			Post post = postRepo.findByPostId(existingPost.getPostId());
			if(post != null) {
				postRepo.save(existingPost);
				Post postOutput = postRepo.getById(existingPost.getPostId());
				return postOutput;
				
			} else {
				throw new PostDoesNotExistInDatabaseException();
			}
		} else { 
			throw new PostEnteredWasNullException();
		}
	}

	@Override
	public List<Post> getAllPosts() throws CouldNotFindAllPostsException {
		List<Post> listOfAllPosts = postRepo.findAll();
		if (!(listOfAllPosts.isEmpty())) {
			return listOfAllPosts;
		} else {
			throw new CouldNotFindAllPostsException();
		}
	}

	@Override
	public List<Post> getAllPostsByCreator(User creator) throws CreatorWasNullException {
		List<Post> allPostByCreator = new ArrayList<Post>();
		if (creator != null) {
			List<Post> allPost = postRepo.findAll();
			for ( Post post : allPost) {
				if (post.getCreator().getUserId() == creator.getUserId()) {
					allPostByCreator.add(post);
				}
			}
		} else {
			throw new CreatorWasNullException();
		}
			return allPostByCreator;
		
	}

	@Override
	public List<Post> getAllPostsByPortfolio(Portfolio portfolioPostedOn) throws PortfolioEnteredWasNull {
		List<Post> allPostByPortfolio = new ArrayList<Post>();
		if (portfolioPostedOn != null) {
			List<Post> allPost = postRepo.findAll();
			for ( Post post : allPost) {
				if (post.getPortfolioPostedOn().getPortfolioId() == portfolioPostedOn.getPortfolioId()) {
					allPostByPortfolio.add(post);
				}
			}
		} else {
			throw new PortfolioEnteredWasNull();
		}
			return allPostByPortfolio;
		
	}

	@Override
	public Map<String, Stock> getListOfStocks(String[] listOfStocknames) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
<<<<<<< HEAD

	@Override
	public void buyStock(User loggedInUser, com.revature.stockYourself.beans.Stock stockToBuy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sellStock(User loggedInUser, com.revature.stockYourself.beans.Stock stockToSell) {
		// TODO Auto-generated method stub
		
	}
}
=======
		

}
>>>>>>> 619ff788b8ff55624d19b9c66070ed89fcf47782
=======
}
>>>>>>> 6fb72ffccb81b8ccf41dbea5629265934019aeff
