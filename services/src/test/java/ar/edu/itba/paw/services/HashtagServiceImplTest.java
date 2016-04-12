package ar.edu.itba.paw.services;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ar.edu.itba.paw.models.Tweet;
import ar.edu.itba.paw.models.User;
import ar.edu.itba.paw.persistence.HashtagDAO;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

import java.sql.Timestamp;
import java.util.Set;


public class HashtagServiceImplTest {


@Mock
private HashtagDAO hashtagDao;

private HashtagServiceImpl hs;

private static Tweet t;
private static User u;

private static final String MESSAGE = "tweet", ID = "12345";

private static final String USERNAME = "@testUser", EMAIL = "testUser@gmail.com",
		FIRSTNAME = "test", LASTNAME = "user", UID = "12345abcd";

private static Timestamp timestamp;

private static int COUNT = 1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		timestamp = new Timestamp(System.currentTimeMillis());
		u = new User(USERNAME,EMAIL,FIRSTNAME,LASTNAME,UID);
		t = new Tweet(MESSAGE,ID, u, timestamp);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		hs = new HashtagServiceImpl();
		hs.setHashtagDAO(hashtagDao);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void registerTest() {
		hs.register(t);
		
		Set<String> hashtags = t.getHashtags();
		
		verify(hashtagDao,times(hashtags.size())).create(null,null);
		
		for (String string : hashtags) {
			verify(hashtagDao).create(eq(string), eq(ID));
		}
		
	}
	
	@Test
	public void getTrendingTopicsTest() {
		hs.getTrendingTopics(COUNT);
		verify(hashtagDao).getTrendingTopics(eq(COUNT));
		
	}

}
