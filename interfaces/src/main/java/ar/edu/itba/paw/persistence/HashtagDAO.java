package ar.edu.itba.paw.persistence;

import java.util.List;

import ar.edu.itba.paw.models.Tweet;

public interface HashtagDAO {

	/**
	 * Create a hashtag.
	 * 
	 * @param msg The hashtag name. 
	 * @param tweet ID The tweet with the hashtag.
	 */
	void create(final String hashtag, final String tweetID);
	
	/**
	 * Get a list of hashtags.
	 * 
	 * @return The list of TT.
	 */
	List<String> getTrendingTopics();
	
	/**
	 * Get a list of tweets with a hashtag.
	 * 
	 * @param hashtag The hashtag name.
	 * @return The list of tweets.
	 */
	List<Tweet> getTweetsByHashtag(final String hashtag);

}
