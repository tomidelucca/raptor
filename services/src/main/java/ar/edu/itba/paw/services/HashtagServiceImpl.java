package ar.edu.itba.paw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.itba.paw.persistence.HashtagDAO;

public class HashtagServiceImpl implements HashtagService {

	@Autowired
	private HashtagDAO hashtagDAO;
	
	@Override
	public void register(final String hashtag, final String tweetID) {
		hashtagDAO.create(hashtag, tweetID);
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
