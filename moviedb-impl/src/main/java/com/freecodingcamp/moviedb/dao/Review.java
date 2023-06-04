package com.freecodingcamp.moviedb.dao;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
public class Review {
    
    @Id
    private ObjectId id;
    private String reviewBody;

    public Review(String reviewBody){
        this.reviewBody = reviewBody;
    }

    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public String getReviewBody() {
        return reviewBody;
    }
    public void setReviewBody(String reviewBody) {
        this.reviewBody = reviewBody;
    }
}
