package com.example.service;

import com.amazonaws.util.CollectionUtils;
import com.example.models.StatusDTO;
import com.example.entities.Tweet;
import com.example.models.TweetDTO;
import com.example.repositories.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TweetService {

    @Autowired TweetRepository tweetRepository;

    public StatusDTO getStatus() {
        return new StatusDTO("running");
    }

    public void postTweet(TweetDTO tweetDTO, String userId) {

        Tweet tweet = new Tweet(null,
                    userId, tweetDTO.getMessage(), System.currentTimeMillis());
        tweetRepository.saveTweet(tweet);
    }

    public List<TweetDTO> getTweetsByUserId(String userId) {

        List<Tweet> tweets = tweetRepository.getTweetsByUserId(userId);
        List<TweetDTO> tweetDTOS = new ArrayList<>();
        if(!CollectionUtils.isNullOrEmpty(tweets)) {
            for(Tweet tweet : tweets) {
                TweetDTO tweetDTO =
                        new TweetDTO(tweet.getId(),
                                tweet.getUserId(),
                                tweet.getMessage(),
                                tweet.getCreatedTime());
                tweetDTOS.add(tweetDTO);
            }
        }
        return tweetDTOS;
    }
}
