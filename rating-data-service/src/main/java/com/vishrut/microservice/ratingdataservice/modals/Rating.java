package com.vishrut.microservice.ratingdataservice.modals;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Rating {

   private String movieId;
   private int rating;
}
