package ar.edu.itba.paw.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
	private final UserRowMapper userRowMapper;

	@Autowired
	public UserJDBC(final DataSource ds) {
		userRowMapper = new UserRowMapper();
		jdbcTemplate = new JdbcTemplate(ds);
		jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("users");

		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS users ("
				+ "username varchar(100)," 
				+ "password varchar(100),"
				+ "email varchar(100),"
				+ "firstName varchar(100),"
				+ "lastName varchar(100),"
				+ "id varchar(100)"+ ")");
	}

	public User create(final String username, final String password, final String email, final String firstName, final String lastName, 
			final String id) {
		final Map<String, Object> args = new HashMap<String, Object>();
		args.put("username", username);
		args.put("password", password);
		args.put("email", email);
		args.put("firstName", firstName);
		args.put("lastName", lastName);
		args.put("id", id);
		jdbcInsert.execute(args);

		return new User(username, password, email, firstName, lastName, id);
	}

	@Override
	public User getByUsername(String username) {
		final List<User> list = jdbcTemplate.query("SELECT * FROM users WHERE username = ? LIMIT 1", userRowMapper, username);
        if (list.isEmpty()) {
                return null;
        }
        return list.get(0);
	}
	
	private static class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(final ResultSet rs, final int rowNum) throws SQLException {
                return new User(rs.getString("username"), 
                		rs.getString("password"),
                		rs.getString("email"),
                		rs.getString("firstName"),
                		rs.getString("lastName"),
                		rs.getString("id"));
        }
}
}
