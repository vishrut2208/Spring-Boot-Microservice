package com.vishrut.microservice.ratingdataservice.controller;


import com.vishrut.microservice.ratingdataservice.modals.Rating;
import com.vishrut.microservice.ratingdataservice.modals.UserRating;
import com.vishrut.microservice.ratingdataservice.service.UserRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ratingsdata")
public class RatingsController {

    @Autowired
    UserRatingService userRatingService;


    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return Rating.builder().movieId("sample").rating(4).build();
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId){
        return userRatingService.getUserRating(userId);
    }
}
