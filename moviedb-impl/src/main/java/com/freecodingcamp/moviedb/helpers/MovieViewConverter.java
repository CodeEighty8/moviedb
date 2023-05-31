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
    public List<MovieView> convert(List<Movie> movies){
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return mapper.convertValue(movies, new TypeReference<List<MovieView>>() {});
    }
}
