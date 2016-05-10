/**
 * 
 */
package com.sjsu.cmpe282.postshare.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ruchira
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRegistrationForm {
	private String userId;

	private String firstName;

	private String lastName;

	private String password;

	private Date createDate;

	private String[] userPreferences;

	/**
	 * @param userId
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param createDate
	 * @param userPreferences
	 */
	public UserRegistrationForm(String userId, String firstName,
			String lastName, String password, Date createDate,
			String[] userPreferences) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.createDate = createDate;
		this.userPreferences = userPreferences;
	}

	/**
	 * 
	 */
	public UserRegistrationForm() {
		super();
		// TODO Auto-generated constructor stub
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

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 *            the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the userPreferences
	 */
	public String[] getUserPreferences() {
		return userPreferences;
	}

	/**
	 * @param userPreferences
	 *            the userPreferences to set
	 */
	public void setUserPreferences(String[] userPreferences) {
		this.userPreferences = userPreferences;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserRegistrationForm [userId=" + userId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", password="
				+ password + ", createDate=" + createDate
				+ ", userPreferences=" + userPreferences + "]";
	}

	public UserContext modelToUserConext() {

		User user = new User(userId, firstName, lastName, password, null);

		List<UserPreferences> userPrefList = new ArrayList<UserPreferences>();
		for (String preference : userPreferences) {
			UserPreferences pref = new UserPreferences();
			pref.setUserId(userId);
			pref.setCategoryId(UUID.fromString(preference));
			userPrefList.add(pref);
		}

		UserContext userContext = new UserContext(user, userPrefList);

		System.out.println(">>>> Modelled UserContext: "
				+ userContext.toString());

		return userContext;
	}
}
