package ar.edu.itba.paw.services;

import java.util.List;

import ar.edu.itba.paw.models.Tweet;

public interface HashtagService {
	
	/**
	 * Store all hashtag from a tweet.
	 * 
	 * @param tweet the hashtag's container.
	 */
	public void register(final Tweet tweet);
	
	/**
	 * Get a user's list of hashtags.
	 * 
	 * @return The recovered hashtags.
	 */
	public List<String> getTrendingTopics();

}
