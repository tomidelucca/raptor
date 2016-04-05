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
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/{username}", method= RequestMethod.GET)
	public ModelAndView timeline(@PathVariable(value="username") String username) {	
		final ModelAndView mav = new ModelAndView("timeline");
		User u = userService.getUserWithUsername(username);

		mav.addObject("userExists", u == null);

		if(u != null){
			mav.addObject("firstName", u.getFirstName());
			mav.addObject("lastName", u.getLastName());
			mav.addObject("username", u.getUsername());
			mav.addObject("email", u.getEmail());
			mav.addObject("userId", u.getId());
			int passwordLength = u.getPassword().length();
			String passwordCount = "";
			while (passwordLength>0) {
				passwordCount += "*";
				passwordLength--;
			}
			mav.addObject("passwordCount", passwordCount);
		}
		return mav;
	}
}
