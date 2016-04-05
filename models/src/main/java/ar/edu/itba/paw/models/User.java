package ar.edu.itba.paw.models;

public class User {

	private final String id;
	private final String username;
	private final String password;
	private final String email;
	private final String firstName;
	private final String lastName;
	private final String miniBio = null;

	public User(String username, String password, String email, String firstName, String lastName, String id) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
