package ar.edu.itba.paw.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.edu.itba.paw.models.Tweet;

public class TweetMapper implements RowMapper<Tweet>{

	@Override
	public Tweet mapRow(ResultSet rs, int rowNum) throws SQLException {
		Tweet t = new Tweet(rs.getString("message"),rs.getInt("ID"),rs.getInt("userID"));
		return t;
	}

}
