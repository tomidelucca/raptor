package ar.edu.itba.paw.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	private static final String EMAIL = "email";
	private static final String FIRSTNAME = "firstName";
	private static final String LASTNAME = "lastName";
	private static final String ID = "id";
	private static final String USERS = "users";
	
	private static final int USERLIST_SIZE = 10;
	
	private static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS ";
	private static final String SQL_GET_BY_USERNAME = "SELECT * FROM users WHERE username = ? LIMIT 1";
	private static final String SQL_GET_USERS_CONTAINING = "select * from " + USERS + " where " + USERNAME + " LIKE ('%' || ? || '%') LIMIT "+ USERLIST_SIZE;
	
	private final JdbcTemplate jdbcTemplate;
	private final SimpleJdbcInsert jdbcInsert;
	private final UserRowMapper userRowMapper;

	@Autowired
	public UserJDBC(final DataSource ds) {
		userRowMapper = new UserRowMapper();
		jdbcTemplate = new JdbcTemplate(ds);
		jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName(USERS);
		try {
		jdbcTemplate.execute(SQL_CREATE_TABLE + USERS +" ("
				+ USERNAME + " varchar(100)," 
				+ PASSWORD + " varchar(100),"
				+ EMAIL + " varchar(100),"
				+ FIRSTNAME + " varchar(100),"
				+ LASTNAME + " varchar(100),"
				+ ID + " varchar(100)"+ ")");
		} catch (DataAccessException e) {
			//TODO db error
		}
	}

	/**
	 * Sketchy method needed to be replaced
	 *
	 * @return a "random" userId
     */

	private String randomUserId() {
		String charactersString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "0123456789";
		char[] characterArray = charactersString.toCharArray();
		String userId = "";
		Random rand = new Random();

		int i = 12;
		while(i>0){
			userId += characterArray[rand.nextInt(characterArray.length)];
			i--;
		}

		return userId;
	}

	@Override
	public User create(final String username, final String password, final String email, final String firstName, final String lastName) {
		final Map<String, Object> args = new HashMap<String, Object>();
		args.put(USERNAME, username);
		args.put(PASSWORD, password);
		args.put(EMAIL, email);
		args.put(FIRSTNAME, firstName);
		args.put(LASTNAME, lastName);
        String userId = randomUserId();
		args.put(ID, userId);
		jdbcInsert.execute(args);

		return new User(username, email, firstName, lastName, userId);
	}

	//TODO SQL injection?
	@Override
	public User getByUsername(String username) {

		try{
			final List<User> list = jdbcTemplate.query(SQL_GET_BY_USERNAME, userRowMapper, username);
	        if (list.isEmpty()) {
	                return null;
	        }
	        return list.get(0);
		} catch(Exception e){ //SQLException or DataAccessException
			//TODO difference between no user found and DataAccessException pending
			return null;
		}
	}
	
	private static class UserRowMapper implements RowMapper<User> {

        public User mapRow(final ResultSet rs, final int rowNum) throws SQLException {
                return new User(rs.getString(USERNAME),
                		rs.getString(EMAIL),
                		rs.getString(FIRSTNAME),
                		rs.getString(LASTNAME),
                		rs.getString(ID));
        }
}

	@Override
	public List<User> searchUsers(String text) {
		try{
			final List<User> ans = jdbcTemplate.query(SQL_GET_USERS_CONTAINING, new UserRowMapper(), text);
			return ans;
		} catch(Exception e){
			return null;
		}
	}
}
