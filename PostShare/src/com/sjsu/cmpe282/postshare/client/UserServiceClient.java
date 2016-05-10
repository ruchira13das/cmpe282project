/**
 * 
 */
package com.sjsu.cmpe282.postshare.client;

import org.springframework.util.StringUtils;

import com.sjsu.cmpe282.postshare.model.User;
import com.sjsu.cmpe282.postshare.model.UserContext;

/**
 * @author ruchira
 *
 */
public class UserServiceClient {

	// private static final String BASE_URL = "http://52.37.69.82/user/rest/";
	private static final String BASE_URL = "http://localhost:8082/user/rest/";

	public boolean authenticateUser(User user) {
		boolean isAuthUser = false;

		if (user != null && !StringUtils.isEmpty(user.getUserId())
				&& !StringUtils.isEmpty(user.getPassword())) {

			String serviceEndPoint = BASE_URL + "auth";
			System.out.println(">>>>> Invoking service: " + serviceEndPoint);

			isAuthUser = ServiceClientUtil.getRestTemplate().postForObject(
					serviceEndPoint, user, Boolean.class);

			System.out.println(">>>>> isAuthUser: " + isAuthUser);
		}

		return isAuthUser;
	}

	public UserContext createUser(UserContext userContext) {
		UserContext newUserContext = null;
		if (isValid(userContext)) {

			String serviceEndPoint = BASE_URL + "create";
			System.out.println(">>>>> Invoking service: " + serviceEndPoint);

			newUserContext = ServiceClientUtil.getRestTemplate().postForObject(
					serviceEndPoint, userContext, UserContext.class);

			System.out.println(">>>>> createUser: " + newUserContext);

		}
		return newUserContext;
	}

	public UserContext getUser(String userId) {
		UserContext userContext = null;
		if (!StringUtils.isEmpty(userId)) {

			String serviceEndPoint = BASE_URL + "get/" + userId.trim() + "/";
			System.out.println(">>>>> Invoking service: " + serviceEndPoint);

			userContext = ServiceClientUtil.getRestTemplate().getForObject(
					serviceEndPoint, UserContext.class);

			System.out.println(">>>>> User detail: " + userContext);

		}
		return userContext;
	}

	private boolean isValid(UserContext userContext) {
		boolean isValid = false;

		if (userContext != null && userContext.getUser() != null
				&& userContext.getUserPreferences() != null) {
			isValid = true;
		}

		return isValid;
	}

}
