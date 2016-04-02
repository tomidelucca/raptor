package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.User;

public interface UserDAO {
	
    /**
     * Create a new user.
     * 
     * @param username The name of the user.
     * @param password The user's password.
     * @param id The user's id.
     * @return The created user.
     */
    User create(final String username, final String password, final String id);
}
