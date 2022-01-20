package com.revature.stockYourself.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.revature.stockYourself.beans.Portfolio;
import com.revature.stockYourself.beans.Post;
import com.revature.stockYourself.beans.StockString;
import com.revature.stockYourself.beans.User;
import com.revature.stockYourself.data.PortfolioRepository;
import com.revature.stockYourself.data.PostRepository;
import com.revature.stockYourself.data.UserRepository;
import com.revature.stockYourself.exceptions.IncorrectCredentialsException;
import com.revature.stockYourself.exceptions.UsernameAlreadyExistsException;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;

public class UserServiceImpl implements UserService {

	private UserRepository userRepo;
	private PostRepository postRepo;
	private PortfolioRepository portfolioRepo;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepo,
				PostRepository postRepo,
				PortfolioRepository portfolioRepo) {
		this.userRepo = userRepo;
		this.postRepo = postRepo;
		this.portfolioRepo = portfolioRepo;
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

	@Override
	public Stock getStockByStockname(String stockname) throws Exception {
		Stock stock = YahooFinance.get(stockname);
		return stock;
	}

	@Override
	public Map<String, Stock> getListOfStocks(List<StockString> listOfStocknames) throws Exception {
		String[] stockString= new String [] {};
		
		listOfStocknames.forEach(stock ->{
			stock.getStockString();
			for(int i=0;i<=listOfStocknames.size();i++) {
				stockString[i]= stock.getStockString();
			}
			});
		Map<String, Stock> stocks = YahooFinance.get(stockString);
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
	
	@Override
	public Portfolio addStockToPortfolio(User user,StockString stock) {
		Portfolio port = user.getPortfolio();
		port.getPortfolioStingStocks().add(stock);
		return port;
	}
	
	@Override
	public Portfolio removeStockToPortfolio(User user,StockString stock) {
		Portfolio port = user.getPortfolio();
		port.getPortfolioStingStocks().remove(stock);
		return port;
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
	public Post updatePost(Post existingPost) {
		if(existingPost != null) {
			Post post = postRepo.findByPostId(existingPost.getPostId());
			if(post != null) {
				postRepo.save(existingPost);
				Post postOutput = postRepo.getById(existingPost.getPostId());
				return postOutput;
				
			} else {
//				throw new PostDoesNotExistInDatabaseException();
			}
		} else { 
//			throw new PostWasNullException();
		}
		return null;
	}

	@Override
	public List<Post> getAllPosts() {
		List<Post> listOfAllPosts = postRepo.findAll();
		if (!(listOfAllPosts.isEmpty())) {
			return listOfAllPosts;
		} else {
//			throw new CouldNotFindAllPostsException();
		}
		return null;
	}

	@Override
	public List<Post> getAllPostsByCreator(User creator) {
		List<Post> allPostByCreator = new ArrayList<Post>();
		if (creator != null) {
			List<Post> allPost = postRepo.findAll();
			for ( Post post : allPost) {
				if (post.getCreator().getUserId() == creator.getUserId()) {
					allPostByCreator.add(post);
				}
			}
		} else {
//			throw new CreatorWasNullException();
		}
			return allPostByCreator;
		
	}

	@Override
	public List<Post> getAllPostsByPortfolio(Portfolio portfolioPostedOn) {
		List<Post> allPostByPortfolio = new ArrayList<Post>();
		if (portfolioPostedOn != null) {
			List<Post> allPost = postRepo.findAll();
			for ( Post post : allPost) {
				if (post.getPortfolioPostedOn().getPortfolioId() == portfolioPostedOn.getPortfolioId()) {
					allPostByPortfolio.add(post);
				}
			}
		} else {
//			throw new CreatorWasNullException();
		}
			return allPostByPortfolio;
		
	}
		

}