package ar.edu.itba.paw.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ar.edu.itba.paw.models.Tweet;

/**
 * 
 * Testing model
 *
 */
@Repository
public class TweetJDBC implements TweetDAO {
	
	private static final String ID = "ID";
	private static final String MESSAGE = "message";
	private static final String USER_ID = "userID";
	private static final String TWEETS = "tweets";
	
	private static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "; 
	private static final String SQL_GET_TWEETS = "select * from tweets where id = ?";
	
	private final JdbcTemplate jdbcTemplate;
	private final SimpleJdbcInsert jdbcInsert;

	@Autowired
	public TweetJDBC(final DataSource ds) {
		jdbcTemplate = new JdbcTemplate(ds);
		jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName(TWEETS);
		jdbcTemplate.execute(SQL_CREATE_TABLE + TWEETS + " ("
				+ ID +" int,"
				+ MESSAGE +" varchar(256),"
				+ USER_ID +" int," 
				+ "primary key ("+ ID +"))");
	}

	@Override
	public Tweet create(final String msg, final int id, final int userID) {
		final Map<String, Object> args = new HashMap<String, Object>();
		args.put(ID, id);
		args.put(MESSAGE, msg);
		args.put(USER_ID, userID);
		jdbcInsert.execute(args);
		Tweet t = null;
		try {
			t= new Tweet(msg, id, userID);
		} catch (IllegalArgumentException e) { // TODO: handle exception
			
		}
		
		return t;
	}

	@Override
	public List<Tweet> getTweetsByUserID(final int id) { //TODO update adding retweets
		String SQL = SQL_GET_TWEETS;
		List<Tweet> ans = jdbcTemplate.query(SQL, new Object[]{id}, new TweetRowMapper());
		return ans;
	}

	private static class TweetRowMapper implements RowMapper<Tweet>{

		@Override
		public Tweet mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Tweet(rs.getString(MESSAGE),rs.getInt(ID),rs.getInt(USER_ID));
		}

	}

}
