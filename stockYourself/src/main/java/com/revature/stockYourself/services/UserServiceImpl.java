package com.revature.stockYourself.services;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.stockYourself.beans.Portfolio;
import com.revature.stockYourself.beans.Post;
import com.revature.stockYourself.beans.StockString;
import com.revature.stockYourself.beans.User;
import com.revature.stockYourself.data.PortfolioRepository;
import com.revature.stockYourself.data.PostRepository;
import com.revature.stockYourself.data.StockStringRepository;
import com.revature.stockYourself.data.UserRepository;
import com.revature.stockYourself.exceptions.CouldNotFindAllPostsException;
import com.revature.stockYourself.exceptions.CreatorWasNullException;
import com.revature.stockYourself.exceptions.IncorrectCredentialsException;
import com.revature.stockYourself.exceptions.NoPortfolioByUserIdException;
import com.revature.stockYourself.exceptions.PostAndOrUserWasNull;
import com.revature.stockYourself.exceptions.PostDoesNotExistInDatabaseException;
import com.revature.stockYourself.exceptions.PostEnteredWasNullException;
import com.revature.stockYourself.exceptions.UserIsNotThePostCreatorException;
import com.revature.stockYourself.exceptions.UsernameAlreadyExistsException;


@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepo;
	private PostRepository postRepo;
	private StockStringRepository stockStringRepo;
	private PortfolioRepository portRepo;

	
	@Autowired
	public UserServiceImpl(UserRepository userRepo,
				PostRepository postRepo,
				PortfolioRepository portfolioRepo,
				StockStringRepository stockStringRepo) {
		this.userRepo = userRepo;
		this.postRepo = postRepo;
		this.portRepo = portfolioRepo;
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
	
	public User getUserById(int id) {
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) return user.get();
		else return null;

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
	public List<Post> getAllPosts() throws CouldNotFindAllPostsException {
		List<Post> listOfAllPosts = postRepo.findAll();
		if (!(listOfAllPosts.isEmpty())) {
			return listOfAllPosts;
		} else {
			throw new CouldNotFindAllPostsException();
		}
	}


	@Override
	public Post getPostById(int postId) throws PostDoesNotExistInDatabaseException {
		Post post = postRepo.findByPostId(postId);
		if(post != null) {
			return post;
		} else {
			throw new PostDoesNotExistInDatabaseException();
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
	public List<StockString> getPortfolioStocks(Portfolio port) {
		if(port != null) {
			Portfolio existingPort = portRepo.findByPortfolioId(port.getPortfolioId());
			List<StockString> stocks = new ArrayList<>();
			existingPort.getPortfolioStringStocks().forEach(stock ->{
				stockStringRepo.getById(stock.getStockStringId());
				stocks.add(stock);
			});
			return stocks;
		}
		return null;
	}

	@Override
	public Portfolio getPortfolioByPortfolioId(int portfolioWithPostsId) throws NoPortfolioByUserIdException {
			Portfolio portfolio = portRepo.findByPortfolioId(portfolioWithPostsId);
			if (portfolio != null) {
				return portfolio;
			} else {
				throw new NoPortfolioByUserIdException();
			}
	}

	
	@Override
	public Portfolio addStockToPortfolio(Portfolio port, StockString stock) {
		if(port != null && stock != null) {
			Portfolio existingport = portRepo.findByPortfolioId(port.getPortfolioId());
			if(existingport.getPortfolioStringStocks().contains(stock)) {
				return existingport;
			}else {
				existingport.getPortfolioStringStocks().add(stockStringRepo.findBystockStringId(stock.getStockStringId()));
				return existingport;
			}
			
		}
		return null;
	}

	@Override
	public Portfolio removeStockFromPortfolio(Portfolio port,StockString stock) {
		if(port != null && stock != null) {
			Portfolio existingport = portRepo.findByPortfolioId(port.getPortfolioId());
			if(existingport.getPortfolioStringStocks().contains(stock)) {
				existingport.getPortfolioStringStocks().remove(stockStringRepo.findBystockStringId(stock.getStockStringId()));
				return existingport;
			}
		return null;
	}
	return null;
}
}
