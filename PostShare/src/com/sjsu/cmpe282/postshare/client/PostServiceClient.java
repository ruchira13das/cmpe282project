/**
 * 
 */
package com.sjsu.cmpe282.postshare.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.sjsu.cmpe282.postshare.model.Post;
import com.sjsu.cmpe282.postshare.model.PostCategory;
import com.sjsu.cmpe282.postshare.model.PostContext;

/**
 * @author ruchira
 *
 */
public class PostServiceClient {

	// private static final String BASE_URL = "http://52.37.69.82/post/rest/";

	private static final String BASE_URL = "http://localhost:8081/post/rest/";

	public List<PostCategory> getPostCategories() {
		List<PostCategory> categories = new ArrayList<PostCategory>();

		String serviceEndPoint = BASE_URL + "categories";
		System.out.println(">>>>> Invoking service end point: "
				+ serviceEndPoint);

		try {
			ResponseEntity<List<PostCategory>> response = ServiceClientUtil
					.getRestTemplate()
					.exchange(
							serviceEndPoint,
							HttpMethod.GET,
							null,
							new ParameterizedTypeReference<List<PostCategory>>() {
							});

			categories = response.getBody();
		} catch (Exception e) {
			System.out
					.println("Exception while fetching trending posts. Details: "
							+ e.getMessage());
		}

		System.out.println("::: return type: " + categories);

		for (PostCategory category : categories) {
			System.out.println(":::: Category: " + category.toString());
		}

		return categories;
	}

	public List<PostContext> getTopPosts() {
		List<PostContext> topPosts = new ArrayList<PostContext>();

		String serviceEndPoint = BASE_URL + "all";
		System.out.println(">>>>> Invoking service end point: "
				+ serviceEndPoint);

		ResponseEntity<List<PostContext>> response = ServiceClientUtil
				.getRestTemplate().exchange(serviceEndPoint, HttpMethod.GET,
						null,
						new ParameterizedTypeReference<List<PostContext>>() {
						});

		topPosts = response.getBody();
		for (PostContext post : topPosts) {
			System.out.println(":::: Top post: " + post.toString());
		}

		return topPosts;
	}

	public List<PostContext> getUserPosts(String userId) {
		List<PostContext> userPosts = new ArrayList<PostContext>();

		String serviceEndPoint = BASE_URL + "user/" + userId + "/";
		System.out.println(">>>>> Invoking service end point: "
				+ serviceEndPoint);

		try {
			ResponseEntity<List<PostContext>> response = ServiceClientUtil
					.getRestTemplate()
					.exchange(
							serviceEndPoint,
							HttpMethod.GET,
							null,
							new ParameterizedTypeReference<List<PostContext>>() {
							});

			userPosts = response.getBody();
		} catch (Exception e) {
			System.out.println("Exception while fetching user posts for: "
					+ userId + ". Details: " + e.getMessage());
		}

		for (PostContext post : userPosts) {
			System.out.println(":::: User post: " + post.toString());
		}

		return userPosts;
	}

	public Post createNewPost(Post post, String userId) {
		Post newPost = new Post();
		String serviceEndPoint = BASE_URL + "add/" + userId + "/";
		System.out.println(">>>>> Invoking service end point: "
				+ serviceEndPoint);

		try {
			newPost = ServiceClientUtil.getRestTemplate().postForObject(
					serviceEndPoint, post, Post.class);

		} catch (Exception e) {
			System.out.println("Exception while creating new post for user: "
					+ userId + ". Details: " + e.getMessage());
		}

		System.out.println(":::: Created User post: " + newPost.toString());

		return newPost;

	}

}
