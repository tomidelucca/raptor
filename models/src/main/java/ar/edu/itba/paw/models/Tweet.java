package ar.edu.itba.paw.models;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tweet {
	
	private final static String HASHTAG_PATTERN = "(?:\\s|\\A)[##]+([A-Za-z0-9-_]+)";
	private final static String MENTION_PATTERN = "(?:\\s|\\A)[@]+([A-Za-z0-9-_]+)";
	
	private final static int MAX_LENGTH=256;
	
	private final static String ERROR_LENGTH = "A tweet can not have more than "+ MAX_LENGTH +" characters.";
	
	private final static SimpleDateFormat sdf = new SimpleDateFormat("h:mm a - d MMMM yyyy");
	
	private final String msg;
	private final String id;
	private final String userID;
	private final Timestamp timestamp;
	
	/**
	 * Create a tweet. 
	 * 
	 * @param msg The tweet's message.
	 * @param id The tweet's ID.
	 * @param userID The user's ID.
	 * @throws IllegalArgumentException
	 */
	public Tweet(final String msg, final String id, final String userID, final Timestamp timestamp) throws IllegalArgumentException {
		if (msg.length()>MAX_LENGTH) {
			throw new IllegalArgumentException(ERROR_LENGTH);
		}
		this.msg = msg;
		this.id = id;
		this.userID = userID;
		this.timestamp = timestamp;
	}
	
	/**
	 * Get hashtags from a tweet.
	 * 
	 * @param msg The tweet's message.
	 * @return List of hashtags.
	 */
	public static List<String> getHashtag(String msg){
		return patternFilter(msg, HASHTAG_PATTERN, "#");
	}
	
	/**
	 * Get  mentions from a tweet.
	 * 
	 * @param msg The tweet's message.
	 * @return List of mentinos.
	 */
	public static List<String> getMentions(String msg){
		return patternFilter(msg, MENTION_PATTERN, "@");
	}
	
	/**
	 * Filters a String with a given RegEx.
	 * 
	 * @param msg The string to be filtered. 
	 * @param pattern The RegEx.
	 * @param c A Special character.
	 * @return
	 */
	private static List<String> patternFilter(String msg, String pattern, String c) { //TODO SET - NO REPET!
		List<String> ans = new LinkedList<String>();
	     Pattern pt = Pattern.compile(pattern);
	     Matcher matcher = pt.matcher(msg);
	     String result = "";
	 
	     while (matcher.find()) {
	         result = matcher.group();
	         result = result.replace(" ", "");
	         String elem = result.replace(c, "");
	         ans.add(elem);
	     }
		
		return ans;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tweet other = (Tweet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tweet [" + msg + "]";
	}
	
	/*
	 * 
	 * Getters
	 * 
	 * */

	public static int getMaxLength() {
		return MAX_LENGTH;
	}

	public String getMsg() {
		return msg;
	}

	public String getId() {
		return id;
	}

	public String getUserID() {
		return userID;
	}
	
	public String getTimestamp(){
		return sdf.format(timestamp);
	}

}
