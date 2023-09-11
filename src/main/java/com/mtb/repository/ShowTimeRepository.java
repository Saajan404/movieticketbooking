package com.mtb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtb.entity.Movie;
import com.mtb.entity.ShowTime;
import com.mtb.entity.Theater;

public interface ShowTimeRepository extends JpaRepository<ShowTime, Integer> {

	ShowTime findByMovieAndTheater(Movie movie, Theater theater);

	public Optional<ShowTime> findById(int showTimeId);
	
}
