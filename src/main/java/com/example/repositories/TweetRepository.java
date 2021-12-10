package com.example.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.example.entities.Tweet;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableScan
public class TweetRepository {

    @Autowired private DynamoDBMapper dynamoDBMapper;
    
    public Tweet saveTweet(Tweet tweet) {
        dynamoDBMapper.save(tweet);
        return tweet;
    }

    public Tweet getTweetById(String tweetId) {
        return dynamoDBMapper.load(Tweet.class, tweetId);
    }

    public List<Tweet> getTweetsByUserId(String userId) {

        Tweet tweet = new Tweet();
        tweet.setUserId(userId);
        DynamoDBQueryExpression<Tweet> queryExpression =
                new DynamoDBQueryExpression<Tweet>()
                .withIndexName("userid-index")
                .withConsistentRead(false)
                .withHashKeyValues(tweet);

        List<Tweet> itemList = dynamoDBMapper.query(Tweet.class, queryExpression);

        return itemList;
    }

    public String deleteTweetById(String tweetId) {
        dynamoDBMapper.delete(dynamoDBMapper.load(Tweet.class, tweetId));
        return "Tweet Id : "+ tweetId +" Deleted!";
    }

    public String updateTweet(String tweetId, Tweet tweet) {

        dynamoDBMapper.save(tweet,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("tweetId",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(tweetId))));
        return tweetId;
    }
}
