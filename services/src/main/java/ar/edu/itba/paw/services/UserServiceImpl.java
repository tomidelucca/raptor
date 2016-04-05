package ar.edu.itba.paw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.itba.paw.models.User;
import ar.edu.itba.paw.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;

	public User register(String username, String password, String email, String firstName, String lastName) {
		User user = userDao.create(username, password, email, firstName, lastName);
		//TODO handle null
		return user;
	}

	public User login(String username, String password) {
		return null;
	}

	public User getUserWithId(String userId) {
		return null;
	}

	public User getUserWithUsername(String username) {
		return userDao.getByUsername(username);
	}
}
