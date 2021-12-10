package com.example.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.example.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired private DynamoDBMapper dynamoDBMapper;

    public User saveUser(User user) {
        dynamoDBMapper.save(user);
        return user;
    }

    public User getUserById(String userId) {
        return dynamoDBMapper.load(User.class, userId);
    }

    public String deleteUserById(String userId) {
        dynamoDBMapper.delete(dynamoDBMapper.load(User.class, userId));
        return "User Id : "+ userId +" Deleted!";
    }

    public String updateUser(String userId, User user) {

        dynamoDBMapper.save(user,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("userId",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(userId))));
        return userId;
    }

}
