package ar.edu.itba.paw.webapp.controllers;

import ar.edu.itba.paw.models.Tweet;
import ar.edu.itba.paw.services.HashtagService;
import ar.edu.itba.paw.services.TweetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.itba.paw.models.User;
import ar.edu.itba.paw.services.UserService;

import java.util.List;
import java.util.Map;

@Controller
public class MentionsController {
	
	private static final String USERNAME = "username";
	private static final String PAGE = "page";
	private static final String MENTIONS = "mentions";
	private static final String MAP_USER = "/user/";
	private static final String MAP_USERS = MAP_USER + "{" + USERNAME + "}";
	private static final String MAP_USER_MENTIONS = MAP_USERS +"/" + MENTIONS;
	private static final String MAP_USER_MENTIONS_WITH_PAGING = MAP_USER_MENTIONS + "/{" + PAGE + "}";
	private static final int 	TIMELINE_SIZE = 10;

	private static final String TIMELINE = "timeline";
	
	private static final String USER = "user";
	
	private static final String TWEET_LIST = "tweetList";
	private static final String TRENDS_LIST = "trendsList";
	private static final String TAB_SELECTED = "tabSelected";
	
	private static final int TRENDING_TOPIC_LIMIT = 5;
	
	@Autowired
	private UserService userService;

	@Autowired
	private TweetService tweetService;

	@Autowired
	private HashtagService hashtagService;

	@RequestMapping(value={MAP_USER_MENTIONS, MAP_USER_MENTIONS_WITH_PAGING}, method= RequestMethod.GET)
	public ModelAndView timeline(@PathVariable Map<String, String> pathVariables){
	//(value=USERNAME) String username) {
		String username = pathVariables.get(USERNAME);
		int page = Integer.valueOf(pathVariables.getOrDefault(PAGE, "1"));
		final ModelAndView mav = new ModelAndView(TIMELINE);
		User u = userService.getUserWithUsername(username);

		if(u != null){
			mav.addObject(USER, u);

			List<Tweet> mentionList = tweetService.getMentions(u.getId(), TIMELINE_SIZE, page);
			List<String> trendsList = hashtagService.getTrendingTopics(TRENDING_TOPIC_LIMIT);

			mav.addObject(TWEET_LIST, mentionList);
			mav.addObject(TRENDS_LIST, trendsList);
			mav.addObject(TAB_SELECTED, MENTIONS);
		}
		return mav;
	}
}