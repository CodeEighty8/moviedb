package com.freecodingcamp.moviedb.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freecodingcamp.movie.views.MovieView;
import com.freecodingcamp.moviedb.dao.Movie;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieViewConverter {
    private ObjectMapper objectMapper = new ObjectMapper()
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    public List<MovieView> convert(List<Movie> movies){
        return objectMapper.convertValue(movies, new TypeReference<List<MovieView>>() {});
    }

    public MovieView convert(Movie movie){
        return objectMapper.convertValue(movie, new TypeReference<MovieView>() {});
    }
}
