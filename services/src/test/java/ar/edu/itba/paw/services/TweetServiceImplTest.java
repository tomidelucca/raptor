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
import static org.mockito.Mockito.verify;

import ar.edu.itba.paw.persistence.TweetDAO;

public class TweetServiceImplTest {

	private static final String MESSAGE = "soy un tweet", USERID = "22", ID = "1234";
	
	private TweetServiceImpl ts;
	
	@Mock
	private TweetDAO tweetDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
        ts = new TweetServiceImpl();
        ts.setTweetDAO(tweetDao);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void registerTest() {	
		ts.register(MESSAGE,USERID);
		verify(tweetDao).create(eq(MESSAGE), eq(USERID));
	}
	
	@Test
	public void getTimeLineTest() {
		ts.getTimeline(ID);
		verify(tweetDao).getTweetsByUserID(eq(ID));
	}

}
