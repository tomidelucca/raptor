package ar.edu.itba.paw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.itba.paw.models.Tweet;
import ar.edu.itba.paw.persistence.TweetDAO;

@Service
public class TweetServiceImpl implements TweetService {

	@Autowired
	private TweetDAO tweetDAO;

	@Override
	public Tweet register(final String msg, final int id, final int userID) {
		return tweetDAO.create(msg, id, userID);
	}

	@Override
	public Tweet retweet(final int tweetID, final int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tweet> getTimeline(final int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tweet> getFeed(final int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tweet> getMentions(final int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tweet> getFavourites(final int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tweet> getHashtag(final String hashtag) {
		// TODO Auto-generated method stub
		return null;
	}

}
