package ar.edu.itba.paw.persistence;

public interface MentionDAO {

	/**
	 * Create a mention.
	 * 
	 * @param msg The mentioned user's ID. 
	 * @param tweet ID The tweet with the mention.
	 */
	void create(final String userID, final String tweetID);
}
