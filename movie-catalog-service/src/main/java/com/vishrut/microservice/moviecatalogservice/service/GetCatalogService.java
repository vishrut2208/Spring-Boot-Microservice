package com.vishrut.microservice.moviecatalogservice.service;

import com.vishrut.microservice.moviecatalogservice.models.CatalogItem;
import com.vishrut.microservice.moviecatalogservice.models.Movie;
import com.vishrut.microservice.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetCatalogService {

    @Autowired
    private RestTemplate restTemplate;

    public List<CatalogItem> getCatalog(String userId){

        UserRating ratings = restTemplate.getForObject("http://rating-data-service/ratingsdata/users/" + userId, UserRating.class);

        return ratings.getUserRating().stream().map(rating -> {
            // for each movie ID. call movie info service and get details
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class );
            // put them all together
            return new CatalogItem(movie.getName(), "Desc", rating.getRating());
        })
                .collect(Collectors.toList());
    }
}
