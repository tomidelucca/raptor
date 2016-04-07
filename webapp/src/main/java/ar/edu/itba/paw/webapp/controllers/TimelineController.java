package ar.edu.itba.paw.webapp.controllers;

import ar.edu.itba.paw.models.Tweet;
import ar.edu.itba.paw.services.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.itba.paw.models.User;
import ar.edu.itba.paw.services.UserService;

import java.util.List;

@Controller
public class TimelineController {
	
	private static final String MAP_USER = "/user/{username}";
	private final static String REDIRECT = "redirect:";

	private static final String TIMELINE = "timeline";
	private static final String USER_EXIST = "userExists";

	private final static String MAP_TWEET_ACTION = "/tweetAction";
	
	private static final String USERNAME = "username";
	private static final String EMAIL = "email";
	private static final String FIRSTNAME = "firstName";
	private static final String LASTNAME = "lastName";
	private static final String USER_ID = "userId";

	private static final String TWEET_LIST = "tweetList";

	private static final String MESSAGE = "message";
	
	@Autowired
	private UserService userService;

	@Autowired
	private TweetService tweetService;

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

			List<Tweet> tweetList = tweetService.getTimeline(u.getId());

			mav.addObject(TWEET_LIST, tweetList);

		}
		return mav;
	}

	@RequestMapping(value = MAP_USER + MAP_TWEET_ACTION, method = RequestMethod.POST)
	public String registerAction(@RequestParam(value=MESSAGE, required=true) String message,
								 @PathVariable(USERNAME) String username) {

		tweetService.register(message, userService.getUserWithUsername(username).getId());

		return REDIRECT + "/user/" + username;
	}
}
