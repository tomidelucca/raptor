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
	public Tweet register(final String msg, final String userID) {
		Tweet t = tweetDAO.create(msg, userID);
		if(t == null) {
			//TODO handle null (invalid message)
		}
		return t;
	}

	@Override
	public List<Tweet> getTimeline(final String id) {
		List<Tweet> ans = tweetDAO.getTweetsByUserID(id);
		if (ans == null) {
		}
		return ans;
	}
	
	@Override
	public Tweet retweet(final String tweetID, final String userID) {
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
		// TODO Auto-generated method stub
		return null;
	}

}
