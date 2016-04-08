package ar.edu.itba.paw.persistence;

import java.util.List;

import ar.edu.itba.paw.models.Tweet;
import ar.edu.itba.paw.models.User;

public interface TweetDAO {
	
	/**
	 * Create a new tweet.
	 * 
	 * @param msg The tweet's message. 
	 * @param owner The user who wrote this tweet.
	 * @return The registered tweet.
	 */
	Tweet create(final String msg, final User owner);
	
	/**
	 * Get a list of user's tweets.
	 * 
	 * @param id The user's ID.
	 * @param resultsPerPage Limit number of tweets per page.
	 * @param page Number of page needed.
	 * @return The user's list of tweets.
	 */
	List<Tweet> getTweetsByUserID(final String id, int resultsPerPage, int page);
	
	/**
	 * Get a list of Tweets with a hashtag.
	 * 
	 * @param hashtag
	 * @param resultsPerPage limit number of tweets per page.
	 * @param page number of page needed.
	 * @return the list
	 */
	List<Tweet> getTweetsByHashtag(final String hashtag, int resultsPerPage, int page);

	 /**
     * Search for tweets.
     * 
     * @param text the searched text.
	 * @param resultsPerPage limit number of tweets per page.
	 * @param page number of page needed.
     * @return the list of tweets.
     */
    List<Tweet> searchTweets(final String text, int resultsPerPage, int page);
}
