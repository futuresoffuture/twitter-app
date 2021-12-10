package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TweetDTO {
    private String id;
    private String userId;
    private String message;
    private long createdTime;
}
