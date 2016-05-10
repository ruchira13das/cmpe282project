/**
 * 
 */
package com.sjsu.cmpe282.postshare.model;

import java.util.UUID;

/**
 * @author ruchira
 *
 */
public class PostRatings {

	private UUID id;

	private UUID postId;

	private int rating;

	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @return the postId
	 */
	public UUID getPostId() {
		return postId;
	}

	/**
	 * @param postId
	 *            the postId to set
	 */
	public void setPostId(UUID postId) {
		this.postId = postId;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * @param id
	 * @param postId
	 * @param rating
	 */
	public PostRatings(UUID id, UUID postId, int rating) {
		super();
		this.id = id;
		this.postId = postId;
		this.rating = rating;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PostRatings [id=" + id + ", postId=" + postId + ", rating="
				+ rating + "]";
	}

	/**
	 * 
	 */
	public PostRatings() {
		super();
	}

}
