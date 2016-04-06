package ar.edu.itba.paw.services;

import java.util.List;

public interface HashtagService {
	
	/**
	 * Store a hashtag.
	 * 
	 * @param hashtag The hashtag name.
	 * @param tweetID The tweet.
	 */
	public void register(final String hashtag, final String tweetID);
	
	/**
	 * Get a user's list of hashtags.
	 * 
	 * @return The recovered hashtags.
	 */
	public List<String> getTrendingTopics();

}
