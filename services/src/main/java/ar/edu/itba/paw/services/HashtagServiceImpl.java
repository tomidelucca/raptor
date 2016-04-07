package ar.edu.itba.paw.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.itba.paw.models.Tweet;
import ar.edu.itba.paw.persistence.HashtagDAO;

public class HashtagServiceImpl implements HashtagService {

	@Autowired
	private HashtagDAO hashtagDAO;
	
	@Override
	public void register(final Tweet tweet) {
		Set<String> hashtags = Tweet.getHashtag(tweet.getMsg());
		String id = tweet.getId();
		for (String hs : hashtags) {
			hashtagDAO.create(hs, id);
		}
 	}

	@Override
	public List<String> getTrendingTopics() {
		List<String> ans = hashtagDAO.getTrendingTopics();
		if (ans == null) {
			//TODO handle null (db error)
		}
		return ans;
	}
}
