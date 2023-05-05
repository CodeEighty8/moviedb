package com.freecodingcamp.moviedb.dao;

import java.sql.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "movies")
public class Movie {

    @Id
    private ObjectId id;
    
    private String imdbId;
    
    private String title;
    
    private Date releaseDate;
    
    private String trailerLink;
    
    private List<String> genres;
    
    private String poster;
    
    private List<String> backdrops;
    
    @DocumentReference
    private List<Reviews> reviewids;

    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public String getImdbId() {
        return imdbId;
    }
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    public String getTrailerLink() {
        return trailerLink;
    }
    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }
    public List<String> getGenres() {
        return genres;
    }
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
    public String getPoster() {
        return poster;
    }
    public void setPoster(String poster) {
        this.poster = poster;
    }
    public List<String> getBackdrops() {
        return backdrops;
    }
    public void setBackdrops(List<String> backdrops) {
        this.backdrops = backdrops;
    }
    public List<Reviews> getReviewids() {
        return reviewids;
    }
    public void setReviewids(List<Reviews> reviewids) {
        this.reviewids = reviewids;
    }
}
