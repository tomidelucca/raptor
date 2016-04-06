package ar.edu.itba.paw.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

/**
 * 
 * Testing model
 *
 */
@Repository
public class HashtagJDBC implements HashtagDAO {

	private static final String HASHTAGS = "hashtags";
	private static final String HASHTAG = "hashtag";
	private static final String TWEET_ID = "tweetID";
	private static final String TIME = "time";
	
	private static final int LIMIT = 5;
	private static final int INTERVAL = 12;
	
	private static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "; 
	private static final String SQL_GET_TRENDINGS = "SELECT " + HASHTAG + " FROM " 
					+ HASHTAGS + " WHERE " + TIME + " >= NOW() - INTERVAL " 
					+ INTERVAL + " HOUR ORDER BY SUM(" + HASHTAG + ") DESCLIMIT " + LIMIT; //TODO fix

	private final JdbcTemplate jdbcTemplate;
	private final SimpleJdbcInsert jdbcInsert;
	private final HashtagRowMapper hashtagRowMapper;
	
	@Autowired
	public HashtagJDBC(final DataSource ds) {
		hashtagRowMapper = new HashtagRowMapper();
		jdbcTemplate = new JdbcTemplate(ds);
		jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName(HASHTAGS);
		try {
		jdbcTemplate.execute(SQL_CREATE_TABLE + HASHTAGS + " ("
				+ HASHTAG +" varchar(256),"
				+ TWEET_ID +" varchar(256),"
				+ "primary key ("+ TWEET_ID +"))");
		} catch (DataAccessException e) {
			//TODO db error
		}
	}

	@Override
	public void create(final String hashtag, final String tweetID) {
		final Map<String, Object> args = new HashMap<String, Object>();
		args.put(HASHTAG, hashtag);
		args.put(TWEET_ID, tweetID);
		jdbcInsert.execute(args);
	}

	@Override
	public List<String> getTrendingTopics() {
		List<String> ans = null;
		try{
			ans = jdbcTemplate.query(SQL_GET_TRENDINGS, hashtagRowMapper);
		} catch(Exception e) {} //DataAccessException or SQLException
		return ans;
	}
	
	private static class HashtagRowMapper implements RowMapper<String> {

		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString(HASHTAG);
		}
		
	}

}
