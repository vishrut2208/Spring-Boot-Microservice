package com.vishrut.microservice.moviecatalogservice.controller;


import com.vishrut.microservice.moviecatalogservice.models.CatalogItem;
import com.vishrut.microservice.moviecatalogservice.models.Movie;
import com.vishrut.microservice.moviecatalogservice.models.UserRating;
import com.vishrut.microservice.moviecatalogservice.service.GetCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    GetCatalogService getCatalogService;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

     return getCatalogService.getCatalog(userId);

    }
}
