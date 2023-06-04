package com.freecodingcamp.moviedb.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    public List<Movie> findByImdbId(String imdbId);
}
