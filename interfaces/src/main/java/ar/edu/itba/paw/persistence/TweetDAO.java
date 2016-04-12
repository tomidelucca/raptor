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
	List<Tweet> getTweetsByUserID(final String id, final int resultsPerPage, final int page);
	
	/**
	 * Get a list of Tweets with a hashtag.
	 * 
	 * @param hashtag
	 * @param resultsPerPage limit number of tweets per page.
	 * @param page number of page needed.
	 * @return the list
	 */
	List<Tweet> getTweetsByHashtag(final String hashtag, final int resultsPerPage, final int page);

	/**
	 * Get a list of Tweets mentioning a user.
	 * 
	 * @param userID the id of the user.
	 * @param resultsPerPage limit number of tweets per page.
	 * @param page number of page needed.
	 * @return the list
	 */
	List<Tweet> getTweetsByMention(final String userID, final int resultsPerPage, final int page);

	 /**
     * Search for tweets.
     * 
     * @param text the searched text.
	 * @param resultsPerPage limit number of tweets per page.
	 * @param page number of page needed.
     * @return the list of tweets.
     */
    List<Tweet> searchTweets(final String text, final int resultsPerPage, final int page);

	/**
	 * Get a list of the latest tweets in the whole network
	 *
	 * @param resultsPerPage limit number of tweets per page.
	 * @param page number of page needed.
     * @return
     */
	List<Tweet> getGlobalFeed(final int resultsPerPage, final int page);
}
