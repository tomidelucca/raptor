package ar.edu.itba.paw.persistence;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.sql.Timestamp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import ar.edu.itba.paw.models.Tweet;
import ar.edu.itba.paw.models.User;

/**
 * 
 * Testing model
 *
 */
@Repository
public class TweetJDBC implements TweetDAO {
	
	private static final String ID = "tweetID";
	private static final String MESSAGE = "message";
	private static final String USER_ID = "userID";
	private static final String TIMESTAMP = "timestamp";
	private static final String TWEETS = "tweets";
	
	private static final String HASHTAGS = "hashtags";
	private static final String USERS = "users";
	private static final String USERNAME = "username";
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String EMAIL = "email";
	
	private static final int TIMELINE_SIZE = 10;
	
	private static final String TWEET_SELECT = ID + ", " + MESSAGE + ", " + TWEETS + "." + USER_ID 
						+ " AS " + USER_ID + ", " + TIMESTAMP + ", " + USERNAME + ", " + FIRST_NAME 
						+ ", " + LAST_NAME + ", " + EMAIL;
	
	private static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "; 
	
	private static final String SQL_GET_TWEETS = "select " + TWEET_SELECT + " from " + TWEETS + ", " 
						+ USERS + " where users.userID = tweets.userID AND users.userID = ? ORDER BY " 
						+ TIMESTAMP + " DESC LIMIT "+ TIMELINE_SIZE;

	private static final String SQL_GET_TWEETS_WITH_HASHTAG = "select " + TWEET_SELECT + " from " + TWEETS + ", " 
			+ HASHTAGS + " where hashtags.tweetID = tweets.tweetID AND hashtags.hashtag = ? ORDER BY " 
			+ TIMESTAMP + " DESC LIMIT "+ TIMELINE_SIZE;
	
	private static final String SQL_GET_TWEETS_CONTAINING = "select " + TWEET_SELECT + " from " + TWEETS 
						+ ", " + USERS + " where users.userID = tweets.userID AND " + MESSAGE 
						+ " LIKE ('%' || ? || '%') ORDER BY " + TIMESTAMP + " DESC LIMIT "+ TIMELINE_SIZE;
	
	private final JdbcTemplate jdbcTemplate;
	private final SimpleJdbcInsert jdbcInsert;
	private final TweetRowMapper tweetRowMapper;
	
	@Autowired
	public TweetJDBC(final DataSource ds) {
		tweetRowMapper = new TweetRowMapper();
		jdbcTemplate = new JdbcTemplate(ds);
		jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName(TWEETS);
		try{
		jdbcTemplate.execute(SQL_CREATE_TABLE + TWEETS + " ("
				+ ID +" varchar(256) NOT NULL,"
				+ MESSAGE +" varchar(256) NOT NULL,"
				+ USER_ID +" varchar(256) NOT NULL," 
				+ TIMESTAMP +" TIMESTAMP NOT NULL,"
				+ "PRIMARY KEY ("+ ID +"),"
				+ "FOREIGN KEY (" + USER_ID + ") REFERENCES " + USERS + " ON DELETE CASCADE ON UPDATE RESTRICT);");
		} catch (DataAccessException e) {
			//TODO db error
		}
	}

	@Override
	public Tweet create(final String msg, final User owner) {
		final Map<String, Object> args = new HashMap<String, Object>();
		Tweet ans;
		String id = randomTweetId();
		Timestamp thisMoment = new Timestamp(new Date().getTime());
		try {
			ans = new Tweet(msg, id, owner, thisMoment);
		} catch (IllegalArgumentException e) { return null; }
		args.put(ID, id);
		args.put(MESSAGE, msg);
		args.put(USER_ID, owner.getId());
		args.put(TIMESTAMP, thisMoment);
		jdbcInsert.execute(args);
		return ans;
	}

	@Override
	public List<Tweet> getTweetsByUserID(final String id) { //TODO update adding retweets
		try{
			return jdbcTemplate.query(SQL_GET_TWEETS, tweetRowMapper, id);
		}catch(Exception e) { return null; } //DataAccessException or SQLException
	}

	/**
	 * Generates random tweet ID.
	 * 
	 * @return Tweet ID.
	 */
	private String randomTweetId() {
		String charactersString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "0123456789";
		char[] characterArray = charactersString.toCharArray();
		String id = "";
		Random rand = new Random();

		int i = 12;
		while(i>0){
			id += characterArray[rand.nextInt(characterArray.length)];
			i--;
		}

		return id;
	}
	
	@Override
	public List<Tweet> getTweetsByHashtag(final String hashtag) {
		try{
			return jdbcTemplate.query(SQL_GET_TWEETS_WITH_HASHTAG, tweetRowMapper, hashtag);
		}catch(Exception e) { return null; } //DataAccessException or SQLException
	}
	
	@Override
	public List<Tweet> searchTweets(String text) {
		try{
			final List<Tweet> ans = jdbcTemplate.query(SQL_GET_TWEETS_CONTAINING, tweetRowMapper, text);
			return ans;
		} catch(Exception e){
			return null;
		}
	}

	private static class TweetRowMapper implements RowMapper<Tweet>{

		@Override
		public Tweet mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Tweet(rs.getString(MESSAGE),rs.getString(ID),new User(rs.getString(USERNAME), rs.getString(EMAIL), rs.getString(FIRST_NAME), rs.getString(LAST_NAME), rs.getString(USER_ID)), rs.getTimestamp(TIMESTAMP));
		}

	}
	
}
