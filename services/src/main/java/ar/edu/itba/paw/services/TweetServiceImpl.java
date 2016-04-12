package ar.edu.itba.paw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.itba.paw.models.Tweet;
import ar.edu.itba.paw.models.User;
import ar.edu.itba.paw.persistence.TweetDAO;

@Service
public class TweetServiceImpl implements TweetService {

	@Autowired
	private TweetDAO tweetDAO;
	
	@Autowired
	private HashtagService hashtagService;
	
	//test
	void setTweetDAO(TweetDAO tweetDAO) {
		this.tweetDAO = tweetDAO;
	}
	//test
	void setHashtagService(HashtagService hs) {
		this.hashtagService = hs;
	}

	@Override
	public Tweet register(final String msg, final User owner) {
		Tweet t = tweetDAO.create(msg, owner);
		if(t == null) {
			//TODO handle null (invalid message)
		} else {
			//TODO mentions handler
			hashtagService.register(t);
		}
		return t;
	}
	
	@Override
	public List<Tweet> getTimeline(final String id, int resultsPerPage, int page) {
		List<Tweet> ans = tweetDAO.getTweetsByUserID(id, resultsPerPage, page);
		if (ans == null) {
			//TODO handle null (db error)
		}
		return ans;
	}

	@Override
	public Tweet retweet(final String tweetID, final User owner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tweet> getFeed(final String id, int resultsPerPage, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tweet> getMentions(final String id, int resultsPerPage, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tweet> getFavourites(final String id, int resultsPerPage, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tweet> getHashtag(final String hashtag, int resultsPerPage, int page) {
		List<Tweet> ans = tweetDAO.getTweetsByHashtag(hashtag, resultsPerPage, page);
		if (ans == null) {
			//TODO handle null (db error)
		}
		return ans;
	}
	
	@Override
	public List<Tweet> searchTweets(String text, int resultsPerPage, int page) {
		List<Tweet> ans = tweetDAO.searchTweets(text, resultsPerPage, page);
		if (ans == null) {
			//TODO handle null
		}
		return ans;
	}
}
