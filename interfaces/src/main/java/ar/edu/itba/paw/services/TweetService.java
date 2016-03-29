package ar.edu.itba.paw.services;

import java.util.List;

import ar.edu.itba.paw.models.Tweet;

public interface TweetService {

	/**
	 * Store a new Tweet (possibly in a database).
	 * 
	 * @param msg The tweet message. 
	 * @param id The tweet id.
	 * @param userID The user's ID.
	 * @return The registered tweet.
	 */
	public Tweet register(final String msg, final int id, final int userID);
	
	/**
	 * Get a user's list of tweets.
	 * 
	 * @param id The user id.
	 * @return The recovered tweets.
	 */
	public List<Tweet> getUserTweets(final int id);
	
	

	
	
}
