package ar.edu.itba.paw.persistence;

import java.util.List;

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

}
