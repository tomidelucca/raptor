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
		if(u == null){
			mav.addObject("greeting", "Ups! The requested user doesn't exist!");

			mav.addObject("imageLink", "http://i.imgur.com/icWJ1Qx.png");
		}else{
			mav.addObject("greeting", "Rawrrrr " + u.getFirstName() +" "+ u.getLastName()+ "(@"+ u.getUsername()+")!");
			mav.addObject("imageLink", "https://s-media-cache-ak0.pinimg.com/736x/cf/7e/7d/cf7e7db68d7926e96ca586411c1bf9ca.jpg");
		}
		return mav;
	}
}
