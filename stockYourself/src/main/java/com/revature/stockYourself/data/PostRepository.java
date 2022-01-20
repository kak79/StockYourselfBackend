package com.revature.stockYourself.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.stockYourself.beans.Portfolio;
import com.revature.stockYourself.beans.Post;
import com.revature.stockYourself.beans.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	public Post findByPostId(int postId);
	public Post findByPortfolioPostedOn(Portfolio portfolio);
	public Post findByCreator(User creator);
}
