package ar.edu.itba.paw.services;

import ar.edu.itba.paw.models.User;

public interface UserService {

	/**
	 * Registers a new user if it doesn't exist
	 * @param username the new user's username
	 * @param password the new user's password
	 * @param email the new user's email
	 * @param firstName the new user's first name
	 * @param lastName the new user's last name
	 * @return the newly created user
	 */
	public User register(final String username, final String password, final String email, final String firstName, final String lastName, final String id);

	/**
	 * Logs the user
	 *
	 * @param username
	 * @param password
	 * @return the newly logged user
	 */
	public User login(final String username, final String password);

	/**
	 * @param userId
	 * @return the user with the given identifier
	 */
	public User getUserWithId(final String userId);

	/**
	 * @param username
	 * @return the user with the given username
	 */
	public User getUserWithUsername(final String username);
}
