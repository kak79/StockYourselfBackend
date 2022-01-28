package com.revature.stockYourself.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.stockYourself.beans.Portfolio;
import com.revature.stockYourself.beans.Post;
import com.revature.stockYourself.beans.User;
import com.revature.stockYourself.exceptions.CouldNotFindAllPostsException;
import com.revature.stockYourself.exceptions.CreatorWasNullException;
import com.revature.stockYourself.exceptions.PortfolioEnteredWasNull;
import com.revature.stockYourself.services.UserService;

@RestController
@RequestMapping(path="/post")
@CrossOrigin(origins="http://localhost:4200")
public class PostController {
	private static UserService userServ;

	@Autowired
	public PostController(UserService userServ) {
		this.userServ=userServ;
	}
	
	@GetMapping(path="/all")
	public ResponseEntity<List<Post>> getAllPosts() throws CouldNotFindAllPostsException {
		List<Post> allPosts = userServ.getAllPosts();
		if (!(allPosts.isEmpty())) {
			return ResponseEntity.ok(allPosts);
		} else {
			return ResponseEntity.noContent().build();
		}		
	}
	
	@GetMapping(path="{creatorOfPosts}/posts")
	public ResponseEntity<List<Post>> allPostsByCreator(@RequestBody User creatorOfPosts) throws CreatorWasNullException {
	List<Post> postsByUser = userServ.getAllPostsByCreator(creatorOfPosts);
		 if (!(postsByUser.isEmpty())) {
			 return ResponseEntity.ok(postsByUser);
		 } else {
			 return ResponseEntity.notFound().build();
		 }
		
	}
	
	@GetMapping(path="{portfolio}/posts")
	public ResponseEntity<List<Post>> allPostsByPortfolio(@RequestBody Portfolio portfolioWithPosts) throws CreatorWasNullException, PortfolioEnteredWasNull {
	List<Post> postsByPortfolio = userServ.getAllPostsByPortfolio(portfolioWithPosts);
		 if (!(postsByPortfolio.isEmpty())) {
			 return ResponseEntity.ok(postsByPortfolio);
		 } else {
			 return ResponseEntity.notFound().build();
		 }
		
	}
}
