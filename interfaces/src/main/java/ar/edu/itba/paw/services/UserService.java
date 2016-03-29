package ar.edu.itba.paw.services;

import ar.edu.itba.paw.models.User;

public interface UserService {
	
	/**
     * Register a new user.
     * 
     * @param username The name of the user.
     * @param password The user's password.
     * @param id The user's id.
     * @return The registered user.
     */
	public User register(final String username, final String password, final int id);
}
