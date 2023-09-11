package com.mtb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtb.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

	Optional<Movie> findById(int movieId);
}
