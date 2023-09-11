package com.mtb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mtb.entity.Movie;
import com.mtb.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;
	
	@PostMapping("/saveMovie")
	Movie saveMovies( @Valid @RequestBody Movie movie) {
		
		
		
		return movieService.saveMovie(movie);
		
		
	}
	
	
	
}
