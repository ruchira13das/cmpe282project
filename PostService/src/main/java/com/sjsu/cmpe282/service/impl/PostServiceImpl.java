/**
 * 
 */
package com.sjsu.cmpe282.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sjsu.cmpe282.dao.PostDAO;
import com.sjsu.cmpe282.entity.Post;
import com.sjsu.cmpe282.entity.PostCategory;
import com.sjsu.cmpe282.entity.PostContext;
import com.sjsu.cmpe282.service.PostService;

/**
 * @author ruchira
 *
 */
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDAO postDAO;

	@Override
	public Post addPost(Post post, String userId) {
		return postDAO.createPost(post, userId);
	}

	@Override
	public PostContext getPostById(UUID postId) {
		Post post = postDAO.getPostById(postId);
		PostContext postContext = null;
		if (post != null) {
			double rating = getPostRating(post.getId());
			String ownerId = postDAO.getPostOwner(post.getId());

			postContext = new PostContext(post, rating,
					StringUtils.isEmpty(ownerId) ? "Anonymous" : ownerId);
		}

		return postContext;
	}

	@Override
	public List<PostContext> getPostsForUser(String userId) {
		List<Post> posts = postDAO.getPostsForUser(userId);
		List<PostContext> postContexts = new ArrayList<PostContext>();

		if (posts != null && posts.size() > 0) {
			for (Post post : posts) {
				double rating = getPostRating(post.getId());
				String ownerId = postDAO.getPostOwner(post.getId());

				PostContext postContext = new PostContext(post, rating,
						StringUtils.isEmpty(ownerId) ? "Anonymous" : ownerId);
				postContexts.add(postContext);
			}
		}

		return postContexts;
	}

	@Override
	public Post updatePost(UUID postId, String userId, Post post) {
		// Check if the post exists and belongs to the user
		if (postDAO.doesPostBelongToUser(postId, userId)) {
			post.setId(postId);
			return postDAO.updatePost(post);
		} else {
			return null;
		}
	}

	@Override
	public void deletePost(UUID postId, String userId) {
		// Check if the post exists and belongs to the user
		if (postDAO.doesPostBelongToUser(postId, userId)) {
			postDAO.deletePost(postId, userId);
		}
	}

	@Override
	public void ratePost(UUID postId, int rating) {
		if (postDAO.doesPostExists(postId)) {
			postDAO.submitRatingForPost(rating, postId);
		}
	}

	@Override
	public double getPostRating(UUID postId) {
		double avgRating = 0;
		List<Integer> ratings = postDAO.getRatingsForPost(postId);

		// Get the average
		if (ratings != null && ratings.size() > 0) {
			int aggregateRating = 0;
			for (int rating : ratings) {
				aggregateRating += rating;
			}

			avgRating = (double) aggregateRating / ratings.size();
		}

		return avgRating;
	}

	@Override
	public List<Post> listAllPosts() {
		return postDAO.getAllPosts();
	}

	@Override
	public List<PostContext> listTopPosts() {

		List<Post> posts = postDAO.getRecentPosts();
		List<PostContext> postContexts = new ArrayList<PostContext>();

		if (posts != null && posts.size() > 0) {
			for (Post post : posts) {
				double rating = getPostRating(post.getId());
				String ownerId = postDAO.getPostOwner(post.getId());

				PostContext postContext = new PostContext(post, rating,
						StringUtils.isEmpty(ownerId) ? "Anonymous" : ownerId);
				postContexts.add(postContext);
			}
		}

		return postContexts;
	}

	@Override
	public List<PostCategory> getCategories() {
		return postDAO.getCategories();
	}

}
