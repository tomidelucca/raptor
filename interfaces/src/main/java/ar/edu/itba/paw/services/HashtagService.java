package ar.edu.itba.paw.services;

import java.util.List;

import ar.edu.itba.paw.models.Tweet;

public interface HashtagService {
	
	/**
	 * Store a hashtag.
	 * 
	 * @param msg The hashtag name.
	 */
	public void register(final String msg);
	
	/**
	 * Get a user's list of hashtags.
	 * 
	 * @return The recovered hashtags.
	 */
	public List<String> getTrendingTopics();
	
	/**
	 * 
	 * @param hashtag
	 * @return
	 */
	public List<Tweet> getTweetsByHashatag(final String hashtag);
}
