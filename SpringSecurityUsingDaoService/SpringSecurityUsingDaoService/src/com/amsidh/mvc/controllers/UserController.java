package com.amsidh.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amsidh.mvc.model.User;
import com.amsidh.mvc.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String accessPublicPage(Model model) {
		model.addAttribute("message",
				"This page is publicly accessible. No authentication is required to view.");

		return "public";
	}

	@RequestMapping(value = { "login" })
	public ModelAndView loginPage(@RequestParam(required = false) String error,
			String logout) {

		String message = "";

		if (error != null) {
			message = "Invalid username or password, try again !" + error;

		} else if (logout != null) {

			message = "Logged Out successfully, login again to continue !";
		}
		return new ModelAndView("login", "message", message);
	}

	@RequestMapping("profile")
	public ModelAndView profilePage(Authentication authentication) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		System.out.println(userDetails.getUsername() + "   "
				+ userDetails.getAuthorities().size());
		return new ModelAndView("success", "message",
				"You are authorised user!");
	}

	@RequestMapping("registerform")
	public ModelAndView registerUserform(@ModelAttribute("user") User user) {
		user = new User();
		return new ModelAndView("register", "user", user);
	}

	@RequestMapping(value={"register"},method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("user") User user,
			BindingResult result) {
		if (user.getUsername() != null) {
			user.getUserRole().setUser(user);
			userService.registerUser(user);
		}
		
		return new ModelAndView("register","users",userService.getAllUsers());
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
