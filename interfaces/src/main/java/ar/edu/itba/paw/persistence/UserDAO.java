package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.User;

public interface UserDAO {
	
    /**
     * Create a new user.
     * 
     * @param username The name of the user.
     * @param password The user's password.
     * @param firstName The user's first name.
     * @param lastName The user's last name.
     * @param email The user's email.
     * @param id The user's id.
     * @return The created user.
     */

    User create(final String username, final String password, final String email, final String firstName, final String lastName, final String id);
    
    /**
     * 
     * 
     * @param username the searched username
     * @return the user
     */
    User getByUsername(final String username);
}
