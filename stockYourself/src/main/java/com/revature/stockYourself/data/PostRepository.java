package com.revature.stockYourself.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.stockYourself.beans.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	public Post findByPostId(int postId);
	public Post findByPostContent(String postContent);
}
