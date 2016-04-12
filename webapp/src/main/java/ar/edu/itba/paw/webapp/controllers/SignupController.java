package ar.edu.itba.paw.webapp.controllers;

import ar.edu.itba.paw.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.itba.paw.services.UserService;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignupController {

	private final static String SIGNUP = "signup";

	private final static String MAP_SIGNUP = "/signup";
	private final static String MAP_REGISTER = "/registerUser";
	private final static String MAP_USER = "/user/";
	private final static String REDIRECT = "redirect:";

	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	private static final String EMAIL = "email";
	private static final String FIRSTNAME = "firstName";
	private static final String LASTNAME = "lastName";

	@Autowired
	private UserService userService;

	@RequestMapping(MAP_SIGNUP)
	public ModelAndView signUp() {
		final ModelAndView mav = new ModelAndView(SIGNUP);
		return mav;
	}

	@RequestMapping(value = MAP_REGISTER, method = RequestMethod.POST)
	public String registerAction(@RequestParam(value=PASSWORD, required=true) String password,
								 @RequestParam(value=USERNAME, required=true) String username,
								 @RequestParam(value=FIRSTNAME, required=true) String firstName,
								 @RequestParam(value=LASTNAME, required=true) String lastName,
								 @RequestParam(value=EMAIL, required=true) String email) {

		User user = userService.register(username, password, email, firstName, lastName);

		if(user == null){
			return REDIRECT + MAP_SIGNUP;
		}else{
			return REDIRECT + MAP_USER + user.getUsername();
		}
	}
}