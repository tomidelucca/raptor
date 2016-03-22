package ar.edu.itba.paw.models;

public class User {

private final int id;
	
	private final String username;
	private final String password;
	
	public User(final String username, final String password, final int id) {
		this.username = username;
		this.password = password;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
