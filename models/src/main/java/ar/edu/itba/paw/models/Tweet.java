package ar.edu.itba.paw.models;

import ar.edu.itba.paw.exceptions.IllegalLengthException;

public class Tweet {

	private final static int MAX_LENGTH=256;

	private final String msg;
	private final int id;
	private final int userID;
	//TODO private final Date/TimeStamp
	
	public Tweet(final String msg, final int id, final int userID) throws IllegalLengthException {
		if (msg.length()>MAX_LENGTH) {
			throw new IllegalLengthException("A tweet can not have more than "+ MAX_LENGTH +" characters.");
		}
		this.msg = msg;
		this.id = id;
		this.userID = userID;
	}

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
	
}
