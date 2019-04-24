package com.vishrut.microservice.ratingdataservice.service;

import com.vishrut.microservice.ratingdataservice.modals.Rating;
import com.vishrut.microservice.ratingdataservice.modals.UserRating;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserRatingService {

    public UserRating getUserRating(String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("1234",4),
                new Rating("5678", 3)
        );

        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);

        return userRating;
    }
}
