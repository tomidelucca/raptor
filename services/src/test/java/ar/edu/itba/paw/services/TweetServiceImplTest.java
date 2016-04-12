package ar.edu.itba.paw.services;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

import ar.edu.itba.paw.models.User;
import ar.edu.itba.paw.persistence.TweetDAO;

public class TweetServiceImplTest {

	private static final String MESSAGE = "hola soy un tweet";
	
	private static final String USERNAME = "@testUser", EMAIL = "testUser@gmail.com",
			FIRSTNAME = "test", LASTNAME = "user", UID = "12345abcd";
	
	private static final String HASHTAG = "#test";
	
	private static final String SEARCH = "search";
	
	private static final int RESULTSPERPAGE = 1, PAGE = 1;
	   
	private static User owner;
	private TweetServiceImpl ts;
	
	@Mock
	private TweetDAO tweetDao;
	
	@Mock
	private HashtagService hashtagService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		owner = new User(USERNAME,EMAIL,FIRSTNAME,LASTNAME,UID);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
        ts = new TweetServiceImpl();
        ts.setTweetDAO(tweetDao);
        
        ts.setHashtagService(hashtagService);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void registerTest() {
		
		ts.register(MESSAGE,owner);
		verify(tweetDao).create(eq(MESSAGE), eq(owner));
		verify(hashtagService, never()).register(null);
		
		
	}

	
	@Test
	public void getHashtagsTest() {
		
		ts.getHashtag(HASHTAG, RESULTSPERPAGE, PAGE);
		verify(tweetDao).getTweetsByHashtag(eq(HASHTAG), eq(RESULTSPERPAGE), eq(PAGE));
		
	}
	
	@Test
	public void searchTweetsTest() {
		
		ts.searchTweets(SEARCH, RESULTSPERPAGE, PAGE);
		verify(tweetDao).searchTweets(eq(SEARCH), eq(RESULTSPERPAGE), eq(PAGE));
	}
}
