package ar.edu.itba.paw.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import ar.edu.itba.paw.models.Tweet;

/**
 * 
 * Testing model
 *
 */
@Repository
public class HashtagJDBC implements HashtagDAO {

	private final JdbcTemplate jdbcTemplate;
	private final SimpleJdbcInsert jdbcInsert;
	
	private static final String HASHTAGS = "hashtags";
	private static final String HASHTAG = "hashtag";
	private static final String TWEET_ID = "tweetID";
	
	private static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "; 

	
	@Autowired
	public HashtagJDBC(final DataSource ds) {
		jdbcTemplate = new JdbcTemplate(ds);
		jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName(HASHTAGS);
		jdbcTemplate.execute(SQL_CREATE_TABLE + HASHTAGS + " ("
				+ HASHTAG +" varchar(256),"
				+ TWEET_ID +" varchar(256)," 
				+ "primary key ("+ TWEET_ID +"))");
	}

	public void create(final String hashtag, final String tweetID) {
		final Map<String, Object> args = new HashMap<String, Object>();
		args.put(HASHTAG, hashtag);
		args.put(TWEET_ID, tweetID);
		jdbcInsert.execute(args);
	}

	public List<String> getTrendingTopics() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Tweet> getTweetsByHashtag(String hashtag) {
		// TODO Auto-generated method stub
		return null;
	}

}
