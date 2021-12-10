package com.example.controller;

import com.example.models.StatusDTO;
import com.example.models.TweetDTO;
import com.example.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TweetController {

    @Autowired TweetService tweetService;

    @GetMapping("/status")
    public StatusDTO getStatus() {
        return tweetService.getStatus();
    }

    @PostMapping("/tweet")
    public void postTweet(@RequestBody TweetDTO tweet, @RequestParam String userId) {
        tweetService.postTweet(tweet, userId);
    }

    @GetMapping("/timelines")
    public List<TweetDTO> getTweets(@RequestParam String userId) {
       return tweetService.getTweetsByUserId(userId);
    }


}
