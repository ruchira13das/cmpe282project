/**
 * 
 */
package com.sjsu.cmpe282.postshare.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ruchira
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserContext {

	private User user;
	private List<UserPreferences> userPreferences;

	/**
	 * 
	 */
	public UserContext() {
		super();
	}

	/**
	 * @param user
	 * @param userPreferences
	 */
	public UserContext(User user, List<UserPreferences> userPreferences) {
		super();
		this.user = user;
		this.userPreferences = userPreferences;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the userPreferences
	 */
	public List<UserPreferences> getUserPreferences() {
		return userPreferences;
	}

	/**
	 * @param userPreferences
	 *            the userPreferences to set
	 */
	public void setUserPreferences(List<UserPreferences> userPreferences) {
		this.userPreferences = userPreferences;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserContext [user=" + user.toString() + ", userPreferences="
				+ userPreferences.toString() + "]";
	}

}
