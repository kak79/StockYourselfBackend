package com.revature.stockYourself.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.stockYourself.beans.Portfolio;
import com.revature.stockYourself.beans.Post;
import com.revature.stockYourself.beans.StockData;
import com.revature.stockYourself.beans.StockString;
import com.revature.stockYourself.beans.User;
import com.revature.stockYourself.data.PortfolioRepository;
import com.revature.stockYourself.data.PostRepository;
import com.revature.stockYourself.data.StockStringRepository;
import com.revature.stockYourself.data.UserRepository;
import com.revature.stockYourself.exceptions.CouldNotFindAllPostsException;
import com.revature.stockYourself.exceptions.CreatorWasNullException;
import com.revature.stockYourself.exceptions.IncorrectCredentialsException;
import com.revature.stockYourself.exceptions.PostAndOrUserWasNull;
import com.revature.stockYourself.exceptions.PostDoesNotExistInDatabaseException;
import com.revature.stockYourself.exceptions.PostEnteredWasNullException;
import com.revature.stockYourself.exceptions.UserIsNotThePostCreatorException;
import com.revature.stockYourself.exceptions.UsernameAlreadyExistsException;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;
@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepo;
	private PostRepository postRepo;
	private PortfolioRepository portfolioRepo;
	private StockStringRepository stockStringRepo;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepo,
				PostRepository postRepo,
				PortfolioRepository portfolioRepo,
				StockStringRepository stockStringRepo) {
		this.userRepo = userRepo;
		this.postRepo = postRepo;
		this.portfolioRepo = portfolioRepo;
		this.stockStringRepo = stockStringRepo;
	}
	
	@Override
	public User register(User newUser) throws UsernameAlreadyExistsException {
		try {
			newUser = userRepo.save(newUser);
			return newUser;
		} catch (Exception e) {
			if (e.getMessage()!=null && e.getMessage().contains("unique"))
				throw new UsernameAlreadyExistsException();
			else return null;
		}
	}

	@Override
	public User logIn(String username, String password) throws IncorrectCredentialsException {
		User userFromDatabase = userRepo.findByUsername(username);
		if (userFromDatabase != null && userFromDatabase.getPasswrd().equals(password)) {
			return userFromDatabase;
		} else {
			throw new IncorrectCredentialsException();
		}

	}

	@Override
	public User getUserById(int id) {
		Optional<User> usr = userRepo.findById(id);
		if (usr.isPresent()) return usr.get();
		else return null;
	}

	/**
	 * 
	 * public static Stock get(String symbol) throws IOException {
       		return YahooFinance.get(symbol, true);
	   }
	   
	   
     * Same as the <code>YahooFinance.get(String)</code> method, but with the option to include
     * historical stock quote data. Including historical data will cause the {@link Stock}
     * object's member field {@link yahoofinance.histquotes.HistoricalQuote} to be filled in
     * with the default past year term at monthly intervals.
     * Returns null if the data can't be retrieved from Yahoo Finance.
     * 
     * this also uses our StockData bean and the StockString bean for the symbol. it retrieves 
     * stock name
     * price
     * change in price
     * currency value
     * 
     * @param symbol                the symbol of the stock for which you want to retrieve information
     * @param includeHistorical     indicates if the historical quotes should be included.
     * @return                      a {@link Stock} object containing the requested information
     * @throws java.io.IOException when there's a connection problem
     */
	/*@Override
	public StockData getStockInfo(StockString stockName)throws Exception{
		String stockString = stockName.getStockString();
		Stock stock = YahooFinance.get(stockString, true);
		return new StockData(stock.getName(),stock.getQuote().getPrice(),stock.getQuote().getChange(),stock.getCurrency());
	}*/

	
	/**
     * Same as the <code>YahooFinance.get(String)</code> method, 
     * Returns null if the data can't be retrieved from Yahoo Finance.
     * 
     * @param symbol                the symbol of the stock for which you want to retrieve information
     * @param includeHistorical     indicates if the historical quotes should be included.
     * @return                      a {@link Stock} object containing the requested information
     * @throws java.io.IOException when there's a connection problem
     
    public static Stock get(String symbol, boolean includeHistorical) throws IOException {
        Map<String, Stock> result = YahooFinance.getQuotes(symbol, includeHistorical);
        return result.get(symbol.toUpperCase());
    }
    
	@Override
	public Map<String,Stock> getListOfStocks(Portfolio port) throws Exception {
		List<StockString> listOfStocknames = port.getPortfolioStringStocks();
		String[] stockString= new String [] {};
		
		listOfStocknames.forEach(stock ->{
			stock.getStockString();
			for(int i=0;i<=listOfStocknames.size();i++) {
				stockString[i]= stock.getStockString();
			}
			});
		Map<String, Stock> stocks = YahooFinance.get(stockString);
		return stocks;
		=============================================================
		=============================================================
	}*/
	
	
	
	@Override
	public List<StockString> getPortfolio(Portfolio port) {
		List<StockString> stocks = new ArrayList<StockString>();
		if(port != null) {
			stocks.forEach(stock ->{
				stockStringRepo.findBystockString(stock);
			});
		}
		return null;
	}
	
	@Override
	@Transactional
	public Portfolio addStockToPortfolio(Portfolio ExistingPort,StockString stockString) {
		if(stockString !=null && stockString != null) {
			Portfolio port = portfolioRepo.findByPortfolioId(ExistingPort.getPortfolioId());
			StockString stock = stockStringRepo.findBystockString(stockString);
			port.getPortfolioStringStocks().add(stock);
			portfolioRepo.save(port);
		}
		return null;
	}
	
	@Override
	@Transactional
	public Portfolio removeStockFromPortfolio(Portfolio ExistingPort,StockString remStockString) {
		if(ExistingPort != null && remStockString !=null) {
			Portfolio port = portfolioRepo.findByPortfolioId(ExistingPort.getPortfolioId());
			StockString stockString = stockStringRepo.findBystockString(remStockString);
			port.getPortfolioStringStocks().forEach(stock -> {
				if(stockString.getStockString().equals(stock.getStockString())) {
					portfolioRepo.deleteById(stockString.getStockStringId());
				}
			});
			
		}
		return null;
	}

	

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
	@Transactional
	public void deletePost(Post postToDelete, User loggedInUser) throws UserIsNotThePostCreatorException, PostAndOrUserWasNull {
		if(postToDelete != null && loggedInUser != null) {
			if(postToDelete.getCreator().getUserId() == loggedInUser.getUserId()) {
				postRepo.delete(postToDelete);
			} else {
				throw new UserIsNotThePostCreatorException();
			}
		} else {
			throw new PostAndOrUserWasNull();
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
	public List<Post> getAllPostsByPortfolio(Portfolio portfolioPostedOn) throws CreatorWasNullException {
		List<Post> allPostByPortfolio = new ArrayList<Post>();
		if (portfolioPostedOn != null) {
			List<Post> allPost = postRepo.findAll();
			for ( Post post : allPost) {
				if (post.getPortfolioPostedOn().getPortfolioId() == portfolioPostedOn.getPortfolioId()) {
					allPostByPortfolio.add(post);
				}
			}
		} else {
			throw new CreatorWasNullException();
		}
			return allPostByPortfolio;
		
	}
		

}