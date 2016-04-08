package ar.edu.itba.paw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.itba.paw.models.User;
import ar.edu.itba.paw.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;

	//test
	void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public User register(String username, String password, String email, String firstName, String lastName) {
		User user = userDao.create(username, password, email, firstName, lastName);
		//TODO handle null
		return user;
	}

	@Override
	public List<User> searchUsers(String text, int resultsPerPage, int page) {
		List<User> ans = userDao.searchUsers(text, resultsPerPage, page);
		if (ans == null) {
			//TODO handle null
		}
		return ans;
	}
	
	@Override
	public User login(String username, String password) {
		return null;
	}

	@Override
	public User getUserWithId(String userId) {
		return null;
	}

	@Override
	public User getUserWithUsername(String username) {
		return userDao.getByUsername(username);
	}
}
