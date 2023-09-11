package com.mtb.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtb.entity.Movie;
import com.mtb.repository.MovieRepository;
import com.mtb.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieRepository movieRepository;
	
	
	@Override
	public Movie saveMovie(Movie movie) {
		
		movieRepository.save(movie);
		
		return movie;
	}

}
