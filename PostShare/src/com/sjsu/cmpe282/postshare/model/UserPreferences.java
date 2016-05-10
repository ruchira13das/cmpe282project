/**
 * 
 */
package com.sjsu.cmpe282.postshare.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ruchira
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPreferences {
	private UUID id;

	private UUID categoryId;

	private String userId;

	/**
	 * 
	 */
	public UserPreferences() {
		super();
	}

	/**
	 * @param id
	 * @param categoryId
	 * @param userId
	 */
	public UserPreferences(UUID id, UUID categoryId, String userId) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.userId = userId;
	}

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
	 * @return the categoryId
	 */
	public UUID getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId
	 *            the categoryId to set
	 */
	public void setCategoryId(UUID categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserPreferences [id=" + id + ", categoryId=" + categoryId
				+ ", userId=" + userId + "]";
	}

}
