package ar.edu.itba.paw.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import ar.edu.itba.paw.models.User;

/**
 * 
 *Testing model 
 *
 */
@Repository
public class UserJDBC implements UserDAO {

	private final JdbcTemplate jdbcTemplate;
	private final SimpleJdbcInsert jdbcInsert;

	@Autowired
	public UserJDBC(final DataSource ds) {
		jdbcTemplate = new JdbcTemplate(ds);
		jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("users");

		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS users ("
				+ "username varchar(100)," + "password varchar(100)" + ")");
	}

	@Override
	public User create(final String username, final String password,
			final int id) {
		final Map<String, Object> args = new HashMap<String, Object>();
		args.put("username", username);
		args.put("password", password);
		args.put("id", id);
		jdbcInsert.execute(args);

		return new User(username, password, id);
	}

}
