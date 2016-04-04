package ar.edu.itba.paw.models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tweet {

	private final static int MAX_LENGTH=256;
	private final static String HASHTAG_PATTERN = "(?:\\s|\\A)[##]+([A-Za-z0-9-_]+)";
	private final static String MENTION_PATTERN = "(?:\\s|\\A)[@]+([A-Za-z0-9-_]+)";

	private final String msg;
	private final int id;
	private final int userID;
	//TODO private final Date/TimeStamp
	
	/**
	 * Create a tweet. 
	 * 
	 * @param msg The tweet's message.
	 * @param id The tweet's ID.
	 * @param userID The user's ID.
	 * @throws IllegalArgumentException
	 */
	public Tweet(final String msg, final int id, final int userID) throws IllegalArgumentException {
		if (msg.length()>MAX_LENGTH) {
			throw new IllegalArgumentException("A tweet can not have more than "+ MAX_LENGTH +" characters.");
		}
		this.msg = msg;
		this.id = id;
		this.userID = userID;
	}
	
	public static Map<String, List<String>> getHashtagAndMentions(Tweet t){
		Map<String, List<String>> results = new HashMap<String, List<String>>();
		results.put("hashtags", patternFilter(t.msg, HASHTAG_PATTERN, "#"));
		results.put("mentions", patternFilter(t.msg, MENTION_PATTERN, "@"));
		return results;
	}
	
	private static List<String> patternFilter(String msg, String pattern, String c) {
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tweet other = (Tweet) obj;
		if (id != other.id)
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

	public int getId() {
		return id;
	}

	public int getUserID() {
		return userID;
	}

	@Override
	public int hashCode() {
		return id;
	}
}
