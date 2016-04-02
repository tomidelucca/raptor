package ar.edu.itba.paw.models;

public class User {

	private final String id;
	private final String username;
	private final String password;
	
	public User(final String username, final String password, final String id) {
		this.username = username;
		this.password = password;
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
