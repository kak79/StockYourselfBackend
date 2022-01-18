package com.revature.stockYourself.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.stockYourself.beans.Portfolio;
import com.revature.stockYourself.beans.Post;
import com.revature.stockYourself.beans.Stock;
import com.revature.stockYourself.beans.User;
import com.revature.stockYourself.data.PortfolioRepository;
import com.revature.stockYourself.data.PostRepository;
import com.revature.stockYourself.data.StockRepository;
import com.revature.stockYourself.data.UserRepository;
import com.revature.stockYourself.exceptions.AllStocksAreEmptyException;
import com.revature.stockYourself.exceptions.BadGetAllPortfolios;
import com.revature.stockYourself.exceptions.DataNotFoundException;
import com.revature.stockYourself.exceptions.IncorrectCredentialsException;
import com.revature.stockYourself.exceptions.NoPortfolioByStock;
import com.revature.stockYourself.exceptions.NoPortfolioByUserException;
import com.revature.stockYourself.exceptions.NoPortfolioByUserIdException;
import com.revature.stockYourself.exceptions.NoPortfolioByUsernameException;
import com.revature.stockYourself.exceptions.PortfolioIdUserIdConflictException;
import com.revature.stockYourself.exceptions.PortfolioToUpdateIsNullException;
import com.revature.stockYourself.exceptions.StockListWasEmptyException;
import com.revature.stockYourself.exceptions.UsernameAlreadyExistsException;
import com.revature.stockYourself.services.UserService;

@Service 
public class UserServiceImpl implements UserService {
	private PortfolioRepository portfolioRepo;
	private UserRepository userRepo;
	private PostRepository postRepo;
	private StockRepository stockRepo;
	
	@Autowired
	public UserServiceImpl( PortfolioRepository portfolioRepo, UserRepository userRepo, PostRepository postRepo, StockRepository stockRepo) {
		this.portfolioRepo = portfolioRepo;
		this.userRepo = userRepo;
		this.postRepo = postRepo;
		this.stockRepo = stockRepo;
	}

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
	public Portfolio getPortfolioByUsername(String username) throws NoPortfolioByUsernameException {
		User user = userRepo.findByUsername(username);
		if(user != null) {
			Portfolio usernamePortfolio = user.getPortfolio();
			return usernamePortfolio;
		} else {
			throw new NoPortfolioByUsernameException();
		}
	
	}


	@Override
	public Portfolio getPortfolioByUserId(int userId) throws NoPortfolioByUserIdException {
		User user = userRepo.findByUserId(userId);
		if(user != null) {
			Portfolio usernamePortfolio = user.getPortfolio();
			return usernamePortfolio;
		} else {
			throw new NoPortfolioByUserIdException();
		}
	
	}

	@Override
	public List<Portfolio> getPortfolioByStock(String stockName) throws NoPortfolioByStock {
		List<Portfolio> portfolioByStock = new ArrayList<Portfolio>();
		List<Stock> allPortfolioStocks = null;
		
		//Stock stock = stockRepo.findByName(stockName);
		List<Portfolio> allPortfolios = portfolioRepo.findAll();
		for (Portfolio portfolio : allPortfolios) {
			Stock stock = new Stock();
//			allPortfolioStocks = portfolio.getPortfolioStocks();
		 allPortfolioStocks = new ArrayList<Stock>();
			allPortfolioStocks.add(portfolio.getStock1());
			allPortfolioStocks.add(portfolio.getStock2());
			allPortfolioStocks.add(portfolio.getStock3());
			allPortfolioStocks.add(portfolio.getStock4());
			allPortfolioStocks.add(portfolio.getStock5());
//			
//			if(allPortfolioStocks.iterator().toString() != null {
//				portfolioByStock.add(portfolio);
//			}
//		}
//			for(Stock stock : allPortfolioStocks) {
//				if(stock.getName().equals(stockName)) {
//					
//				portfolioByStock.add(portfolio);
//			
//			} else {
//				throw new NoPortfolioByStockException();
//			}
//	
		}

		return portfolioByStock;
		
	}

	@Override
	public List<Portfolio> getAllPortfolios() throws BadGetAllPortfolios {
		List<Portfolio> allPortfolios = portfolioRepo.findAll();
		if(!(allPortfolios.isEmpty())) {
			return allPortfolios;
		} else {
			throw new BadGetAllPortfolios();
		}
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updatePortfolio(User loggedInUser, Portfolio portfolioToUpdate) throws PortfolioIdUserIdConflictException, PortfolioToUpdateIsNullException {
		if (portfolioToUpdate != null && loggedInUser != null) {
						if (portfolioToUpdate.getPortfolioId() == loggedInUser.getPortfolio().getPortfolioId()) {
								portfolioRepo.save(portfolioToUpdate);
						} else {
							throw new PortfolioIdUserIdConflictException(); // create PortfolioIdUserIdConflict() exception
						}
		} else {
			throw new PortfolioToUpdateIsNullException();  //create PortfolioToUpdateIsNull() exception
		}
	}
	

	@Override
	@Transactional
	public void buyStock(User loggedInUser, Stock stockToBuy) throws StockListWasEmptyException, DataNotFoundException, NoPortfolioByUserException {
		if (loggedInUser != null && stockToBuy != null) {
			Portfolio loggedInUserPortfolio = loggedInUser.getPortfolio();
			
			if(loggedInUserPortfolio != null) {
				List<Stock> loggedInUserPortfolioStocks = loggedInUserPortfolio.getPortfolioStocks();
				loggedInUserPortfolioStocks.add(stockToBuy);
				loggedInUserPortfolio.setPortfolioStocksToStocks(loggedInUserPortfolioStocks);
				
			} else {
				throw new NoPortfolioByUserException();
			}
		} else {
			throw new DataNotFoundException();  
		}
		
	}

	@Override
	@Transactional
	public void sellStock(User loggedInUser, Stock stockToSell) throws StockListWasEmptyException, NoPortfolioByUserException, DataNotFoundException {
		if (loggedInUser != null && stockToSell != null) {
			Portfolio loggedInUserPortfolio = loggedInUser.getPortfolio();
			
			if(loggedInUserPortfolio != null) {
				List<Stock> loggedInUserPortfolioStocks = loggedInUserPortfolio.getPortfolioStocks();
				for (Stock stock : loggedInUserPortfolioStocks) {
					if(stock.getName().equals(stockToSell.getName())) {
						loggedInUserPortfolioStocks.remove(stock);
					}
				}
				loggedInUserPortfolio.setPortfolioStocksToStocks(loggedInUserPortfolioStocks);
				
			} else {
				throw new NoPortfolioByUserException();
			}
		} else {
			throw new DataNotFoundException();
		}
		
	}

	@Override
	public List<Stock> getAllStocks() throws AllStocksAreEmptyException {
		List<Stock> allStocks = stockRepo.findAll();
		if(!(allStocks.isEmpty())) {
			return allStocks;
		} else {
			throw new AllStocksAreEmptyException();
		}
	}

	@Override
	public void deletePost(User loggedInUser, Post postToDelete) {
		// TODO Auto-generated method stub
		
	}
}
