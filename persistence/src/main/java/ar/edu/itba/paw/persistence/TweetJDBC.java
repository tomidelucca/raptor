package ar.edu.itba.paw.persistence;

import java.util.HashMap;
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
public class TweetJDBC implements TweetDAO {

	private final JdbcTemplate jdbcTemplate;
	private final SimpleJdbcInsert jdbcInsert;

	@Autowired
	public TweetJDBC(final DataSource ds) {
		jdbcTemplate = new JdbcTemplate(ds);
		jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("tweets");
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS tweets ("
				+ "message varchar(256)" + ")");//TODO update
	}

	@Override
	public Tweet create(final String msg, final int id, final int userID) {
		final Map<String, Object> args = new HashMap<String, Object>();
		args.put("message", msg);
		jdbcInsert.execute(args);

		Tweet t = null;
		try {
			t= new Tweet(msg, id, userID);
		} catch (IllegalArgumentException e) { // TODO: handle exception
			
		}
		
		return t;
	}

}
