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
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.revature.stockYourself.beans.Portfolio;
import com.revature.stockYourself.beans.Post;
import com.revature.stockYourself.beans.StockString;
import com.revature.stockYourself.beans.User;
<<<<<<< HEAD
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
=======
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
>>>>>>> fe6365e99fbb451a8fe44e9fb3e29719342c4890
import com.revature.stockYourself.exceptions.UsernameAlreadyExistsException;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
<<<<<<< HEAD
import yahoofinance.histquotes.Interval;
=======

@Service
public class UserServiceImpl implements UserService {
>>>>>>> f331e7c1e88b38598166930f13edcd170d229e78

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UserServiceImpl implements UserService {
	private UserRepository userRepo;
	private PostRepository postRepo;
	private StockStringRepository stockStringRepo;
<<<<<<< HEAD
	private PortfolioRepository portRepo;


=======
	
	@Autowired
	public UserServiceImpl(UserRepository userRepo,
				PostRepository postRepo,
				PortfolioRepository portfolioRepo) {
		this.userRepo = userRepo;
		this.postRepo = postRepo;
		this.portfolioRepo = portfolioRepo;
		
	}
	
>>>>>>> f331e7c1e88b38598166930f13edcd170d229e78
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
		
	public User getUserById(int id) {
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) return user.get();
		else return null;

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

	@Override
	public List<StockString> getPortfolio(Portfolio port) {
		// TODO Auto-generated method stub
		return null;
	}
<<<<<<< HEAD

	@Override
	public Portfolio addStockToPortfolio(Portfolio ExistingPort, StockString stockString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Portfolio removeStockFromPortfolio(Portfolio ExistingPort, StockString remStockString) {
		// TODO Auto-generated method stub
		return null;
	}
=======
	
//	@Override
//	@Transactional
//	public Portfolio addStockToPortfolio(Portfolio ExistingPort,StockString stockString) {
//		if(stockString !=null && stockString != null) {
//			Portfolio port = portfolioRepo.findByPortfolioId(ExistingPort.getPortfolioId());
//			StockString stock = stockStringRepo.findByStockName(stockString);
//			port.getPortfolioStringStocks().add(stock);
//			portfolioRepo.save(port);
//		}
//		return null;
//	}
	
//	@Override
//	@Transactional
//	public Portfolio removeStockFromPortfolio(Portfolio ExistingPort,StockString remStockString) {
//		if(ExistingPort != null && remStockString !=null) {
//			Portfolio port = portfolioRepo.findByPortfolioId(ExistingPort.getPortfolioId());
//			StockString stockString = stockStringRepo.findByStockName(remStockString);
//			port.getPortfolioStringStocks().forEach(stock -> {
//				if(stockString.getStockString().equals(stock.getStockString())) {
//					portfolioRepo.deleteById(stockString.getStockStringId());
//				}
//			});
//			
//		}
//		return null;
//	}
>>>>>>> f331e7c1e88b38598166930f13edcd170d229e78

	@Override
	public Post createPost(Post newPost) {
		// TODO Auto-generated method stub
		return null;
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
<<<<<<< HEAD
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
=======
	public Stock getStock(String stockname) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Stock> getListOfStocks(List<StockString> portfolioStringStocks) {
		// TODO Auto-generated method stub
		return null;
	}
>>>>>>> f331e7c1e88b38598166930f13edcd170d229e78
		

}
>>>>>>> 619ff788b8ff55624d19b9c66070ed89fcf47782
=======
}
>>>>>>> 6fb72ffccb81b8ccf41dbea5629265934019aeff
