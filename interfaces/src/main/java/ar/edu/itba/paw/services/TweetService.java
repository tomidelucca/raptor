package ar.edu.itba.paw.services;

import java.util.List;

import ar.edu.itba.paw.models.Tweet;

public interface TweetService {

	/**
	 * Store a new Tweet.
	 * 
	 * @param msg The tweet's message. 
	 * @param userID The user's ID.
	 * @return The registered tweet.
	 */
	public Tweet register(final String msg, final String userID);
	
	/**
	 * Reweets a previous tweet.
	 * 
	 * @param tweetID The old tweet's id.
	 * @param userID The new tweet user's id.
	 * @return The new tweet.
	 */
	public Tweet retweet(final String tweetID, final String userID);
	
	
	/**
	 * Get a user's list of tweets.
	 * 
	 * @param id The user's ID.
	 * @return The recovered tweets.
	 */
	public List<Tweet> getTimeline(final String id);
	
	/**
	 * Get a user's feed tweets.
	 * 
	 * @param id The user's ID.
	 * @return The recovered feed.
	 */
	public List<Tweet> getFeed(final String id);
	
	/**
	 * Get a user's mentions.
	 * 
	 * @param id The user's ID.
	 * @return The recovered mentions.
	 */
	public List<Tweet> getMentions(final String id);
	
	/**
	 * Get a user's favourites.
	 * 
	 * @param id The user's ID.
	 * @return The recovered favourites.
	 */
	public List<Tweet> getFavourites(final String id);
	
	/**
	 * Get a list of tweets with a hashtag.
	 * 
	 * @param hashtag The key hashtag.
	 * @return The recovered list.
	 */
	public List<Tweet> getHashtag(final String hashtag);
	
	
	
	
}
