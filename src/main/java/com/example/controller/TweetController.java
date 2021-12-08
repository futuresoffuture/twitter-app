package com.example.controller;

import com.example.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/twitter-app/greeting")
public class TweetController {

    @Autowired TweetService tweetService;

    @GetMapping()
    public String sayHello() {
        return tweetService.sayHello();
    }

}
