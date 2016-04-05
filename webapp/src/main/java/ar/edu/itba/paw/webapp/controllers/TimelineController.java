package ar.edu.itba.paw.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.itba.paw.models.User;
import ar.edu.itba.paw.services.UserService;

@Controller
public class TimelineController {
	
	private static final String MAP_USER = "/user/{username}";
	
	private static final String TIMELINE = "timeline";
	private static final String USER_EXIST = "userExists";
	private static final String PASSWORD_COUNT = "passwordCount";
	
	private static final String USERNAME = "username";
	private static final String EMAIL = "email";
	private static final String FIRSTNAME = "firstName";
	private static final String LASTNAME = "lastName";
	private static final String USER_ID = "userId";
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value=MAP_USER, method= RequestMethod.GET)
	public ModelAndView timeline(@PathVariable(value=USERNAME) String username) {	
		final ModelAndView mav = new ModelAndView(TIMELINE);
		User u = userService.getUserWithUsername(username);

		mav.addObject(USER_EXIST, u == null);

		if(u != null){
			mav.addObject(FIRSTNAME, u.getFirstName());
			mav.addObject(LASTNAME, u.getLastName());
			mav.addObject(USERNAME, u.getUsername());
			mav.addObject(EMAIL, u.getEmail());
			mav.addObject(USER_ID, u.getId());
			int passwordLength = u.getPassword().length();
			String passwordCount = "";
			while (passwordLength>0) {
				passwordCount += "*";
				passwordLength--;
			}
			mav.addObject(PASSWORD_COUNT, passwordCount);
		}
		return mav;
	}
}
