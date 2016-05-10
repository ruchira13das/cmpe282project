package com.sjsu.cmpe282.service;

import java.util.List;
import java.util.UUID;

import com.sjsu.cmpe282.entity.Post;
import com.sjsu.cmpe282.entity.PostCategory;
import com.sjsu.cmpe282.entity.PostContext;

public interface PostService {

	public Post addPost(Post post, String userId);

	public PostContext getPostById(UUID postId);

	public List<PostContext> getPostsForUser(String userId);

	public Post updatePost(UUID postId, String userId, Post post);

	public void deletePost(UUID postId, String userId);

	public void ratePost(UUID postId, int rating);

	public double getPostRating(UUID postId);

	public List<Post> listAllPosts();

	public List<PostContext> listTopPosts();

	public List<PostCategory> getCategories();

}
