package ar.edu.itba.paw;

import ar.edu.itba.paw.models.User;

public interface UserService {
	
	public User register(final String username, final String password);
}
