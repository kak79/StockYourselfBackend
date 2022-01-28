package com.revature.stockYourself.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.stockYourself.beans.Portfolio;
import com.revature.stockYourself.beans.Post;
import com.revature.stockYourself.beans.User;
import com.revature.stockYourself.exceptions.CouldNotFindAllPostsException;
import com.revature.stockYourself.exceptions.CreatorWasNullException;
import com.revature.stockYourself.exceptions.NoPortfolioByUserIdException;
import com.revature.stockYourself.exceptions.PortfolioEnteredWasNull;
import com.revature.stockYourself.exceptions.PostDoesNotExistInDatabaseException;
import com.revature.stockYourself.exceptions.PostEnteredWasNullException;
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
	
	@PostMapping(path="/create")
	public ResponseEntity<Post> createPost(@RequestBody Post postToBeCreated) {
		if(postToBeCreated != null) {
			Post newPost = userServ.createPost(postToBeCreated);
			return ResponseEntity.ok(newPost);
		} else {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@PutMapping(path="/{postToUpdateId}/update")
	public ResponseEntity<Post> updatePost(@PathVariable int postToUpdateId, @RequestBody User postCreator) throws PostDoesNotExistInDatabaseException, PostEnteredWasNullException  {
		Post postToUpdate = userServ.getPostById(postToUpdateId);
		if(postCreator.getUserId() == postToUpdate.getCreator().getUserId()) {
			Post updatedPost = userServ.updatePost(postToUpdate);
			return ResponseEntity.ok(updatedPost);
		} else {
			return ResponseEntity.badRequest().build();
		}
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
	
	@GetMapping(path="{creatorOfPostsId}/posts")
	public ResponseEntity<List<Post>> allPostsByCreator(@PathVariable int creatorOfPostsId) throws CreatorWasNullException {
		User creatorOfPosts = userServ.getUserById(creatorOfPostsId);
		List<Post> postsByUser = userServ.getAllPostsByCreator(creatorOfPosts);
		 if (!(postsByUser.isEmpty())) {
			 return ResponseEntity.ok(postsByUser);
		 } else {
			 return ResponseEntity.notFound().build();
		 }
		
	}
	
	@GetMapping(path="{portfolioWithPostsId}/posts")
	public ResponseEntity<List<Post>> allPostsByPortfolio(@PathVariable int portfolioWithPostsId) throws CreatorWasNullException, PortfolioEnteredWasNull, NoPortfolioByUserIdException {
		Portfolio portfolioWithPosts = userServ.getPortfolioByPortfolioId(portfolioWithPostsId);
	List<Post> postsByPortfolio = userServ.getAllPostsByPortfolio(portfolioWithPosts);
		 if (!(postsByPortfolio.isEmpty())) {
			 return ResponseEntity.ok(postsByPortfolio);
		 } else {
			 return ResponseEntity.notFound().build();
		 }
		
	}
}
