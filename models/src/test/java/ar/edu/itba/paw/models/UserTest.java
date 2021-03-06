package ar.edu.itba.paw.models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {

	private static final String USERNAME = "@testUser", EMAIL = "testUser@gmail.com",
			FIRSTNAME = "test", LASTNAME = "user", UID = "12345abcd";
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void userTest() {
		User u = new User(USERNAME,EMAIL,FIRSTNAME,LASTNAME,UID);
		assert(u.getUsername().equals(USERNAME));
		assert(u.getEmail().equals(EMAIL));
		assert(u.getFirstName().equals(FIRSTNAME));
		assert(u.getLastName().equals(LASTNAME));
		assert(u.getId().equals(UID));
	}

}
