/**
 * 
 */
package com.sjsu.cmpe282.postshare.model;

/**
 * @author ruchira
 *
 */
public class PostContext {

	private Post post;
	private double rating;
	private String postOwner;

	/**
	 * @param post
	 * @param rating
	 * @param post_owner
	 */
	public PostContext(Post post, double rating, String postOwner) {
		super();
		this.post = post;
		this.rating = rating;
		this.postOwner = postOwner;
	}

	/**
	 * 
	 */
	public PostContext() {
		super();
	}

	/**
	 * @return the post
	 */
	public Post getPost() {
		return post;
	}

	/**
	 * @param post
	 *            the post to set
	 */
	public void setPost(Post post) {
		this.post = post;
	}

	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	 * @return the postOwner
	 */
	public String getPostOwner() {
		return postOwner;
	}

	/**
	 * @param post_owner
	 *            the postOwner to set
	 */
	public void setPostOwner(String postOwner) {
		this.postOwner = postOwner;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PostContext [post=" + post + ", rating=" + rating
				+ ", postOwner=" + postOwner + "]";
	}

}
