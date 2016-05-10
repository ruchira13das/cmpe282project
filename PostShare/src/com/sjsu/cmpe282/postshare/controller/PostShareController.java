/**
 * 
 */
package com.sjsu.cmpe282.postshare.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sjsu.cmpe282.postshare.client.PostServiceClient;
import com.sjsu.cmpe282.postshare.client.UserServiceClient;
import com.sjsu.cmpe282.postshare.model.Post;
import com.sjsu.cmpe282.postshare.model.PostCategory;
import com.sjsu.cmpe282.postshare.model.PostContext;
import com.sjsu.cmpe282.postshare.model.User;
import com.sjsu.cmpe282.postshare.model.UserContext;
import com.sjsu.cmpe282.postshare.model.UserRegistrationForm;

/**
 * @author ruchira
 *
 */
@Controller
public class PostShareController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView homepage2(ModelMap model) {
		System.out.println("xxxxxxxxxxxx");
		model.addAttribute("userForm", new User());
		return new ModelAndView("index", model);
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(ModelMap modelMap) {
		System.out.println("@@@@@@@@@@@@@");

		PostServiceClient client = new PostServiceClient();
		List<PostCategory> categories = client.getPostCategories();

		modelMap.addAttribute("userForm", new UserRegistrationForm());

		return new ModelAndView("register", "categories", categories);

		// return new ModelAndView("register", modelMap);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUser(
			@ModelAttribute("userForm") UserRegistrationForm userForm,
			BindingResult result, ModelMap modelMap) {
		System.out.println("@@@@@!!!!@@@@@@@");

		UserServiceClient client = new UserServiceClient();
		UserContext newUserContext = client.createUser(userForm
				.modelToUserConext());

		System.out.println("::: newUserContext: " + newUserContext.toString());

		// String message = "<br><div style='text-align:center;'>"
		// + "<h3>********** " + "New User created for: "
		// + userForm.getUserId() + "**********</div><br><br>";

		return new ModelAndView("register", "message", "User created!");
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("userForm") User user,
			BindingResult result, ModelMap modelMap) {

		UserServiceClient userClient = new UserServiceClient();
		PostServiceClient postClient = new PostServiceClient();

		if (userClient.authenticateUser(user)) {
			UserContext userContext = userClient.getUser(user.getUserId());
			// List<PostContext> topPosts = postClient.getTopPosts();

			// for (PostContext topPost : topPosts) {
			// System.out.println("*** Top Post: " + topPost.toString());
			// }

			ModelAndView modelAndView = new ModelAndView("dashboard");

			modelAndView.addObject("user", userContext.getUser());
			// modelAndView.addObject("topPosts", topPosts);

			return modelAndView;

		} else {
			return new ModelAndView("index", "message", "Login Failed!");
		}
	}

	@RequestMapping(value = "/trending", method = RequestMethod.GET)
	public ModelAndView getTrendingPosts(ModelMap modelMap) {

		PostServiceClient postClient = new PostServiceClient();

		List<PostContext> topPosts = postClient.getTopPosts();

		for (PostContext topPost : topPosts) {
			System.out.println("*** Top Post: " + topPost.toString());
		}

		ModelAndView modelAndView = new ModelAndView("trending");

		modelAndView.addObject("topPosts", topPosts);

		return modelAndView;
	}

	@RequestMapping(value = "/compose", method = RequestMethod.GET)
	public ModelAndView composeNewPost(ModelMap modelMap,
			@RequestParam("userId") String userId) {

		PostServiceClient client = new PostServiceClient();
		List<PostCategory> categories = client.getPostCategories();

		ModelAndView modelAndView = new ModelAndView("compose");
		modelAndView.addObject("categories", categories);

		// PostContext postContext = new PostContext();
		// postContext.setPostOwner(userId);
		// postContext.setRating(rating);

		modelAndView.addObject("newPost", new Post());
		modelAndView.addObject("userId", userId);

		return modelAndView;
	}

	@RequestMapping(value = "/compose", method = RequestMethod.POST)
	public ModelAndView submitNewPost(@ModelAttribute("newPost") Post post,
			@RequestParam("userId") String userId) {

		System.out.println(">>>>> Post input::: " + post.toString());

		System.out.println(">>>> User id: " + userId);
		PostServiceClient postClient = new PostServiceClient();
		postClient.createNewPost(post, userId);

		// Load the trending page
		UserServiceClient userClient = new UserServiceClient();
		UserContext userContext = userClient.getUser(userId);

		ModelAndView modelAndView = new ModelAndView("dashboard");
		modelAndView.addObject("user", userContext.getUser());

		return modelAndView;

	}

	@RequestMapping(value = "/myposts", method = RequestMethod.GET)
	public ModelAndView getUserPosts(@RequestParam("userId") String userId) {

		// String userId = "john@mail.com";
		System.out.println("Request parameter: " + userId);
		PostServiceClient postClient = new PostServiceClient();
		List<PostContext> userPosts = new ArrayList<PostContext>();
		userPosts = postClient.getUserPosts(userId);

		for (PostContext userPost : userPosts) {
			System.out.println("*** User Post: " + userPost.toString());
		}

		ModelAndView modelAndView = new ModelAndView("myposts");

		modelAndView.addObject("userPosts", userPosts);

		return modelAndView;
	}
}
