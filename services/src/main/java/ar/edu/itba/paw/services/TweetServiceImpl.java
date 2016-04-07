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
	
	//test
	void setTweetDAO(TweetDAO tweetDAO) {
		this.tweetDAO = tweetDAO;
	}

	@Override
	public Tweet register(final String msg, final User owner) {
		Tweet t = tweetDAO.create(msg, owner);
		if(t == null) {
			//TODO handle null (invalid message)
		} else {
			//TODO mentions handler
			HashtagServiceImpl asd = new HashtagServiceImpl();
			asd.register(t);
		}
		return t;
	}
	
	@Override
	public List<Tweet> getTimeline(final String id) {
		List<Tweet> ans = tweetDAO.getTweetsByUserID(id);
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
	public List<Tweet> getFeed(final String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tweet> getMentions(final String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tweet> getFavourites(final String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tweet> getHashtag(final String hashtag) {
		List<Tweet> ans = tweetDAO.getTweetsByHashtag(hashtag);
		if (ans == null) {
			//TODO handle null (db error)
		}
		return ans;
	}
	
	@Override
	public List<Tweet> searchTweets(String text) {
		List<Tweet> ans = tweetDAO.searchTweets(text);
		if (ans == null) {
			//TODO handle null
		}
		return ans;
	}
}
