package com.mtb.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mtb.dto.MovieDTO;
import com.mtb.entity.Movie;

@Component
public class MovieConverter {

	
	// method to convert dto to Movie entity
			public Movie convertDtoToMovieEntity(MovieDTO mDto) {
				Movie movie = new Movie();

				if (mDto != null) {

					// for all or use BeanUtils
					BeanUtils.copyProperties(mDto, movie);

				}

				return movie;

			}

			// method to convert Movie entity to dto

			public MovieDTO convertMovieEntityToDto(Movie movie) {
				MovieDTO mDto = new MovieDTO();

				if (mDto != null) {
					BeanUtils.copyProperties(movie, mDto);

				}
				return mDto;

			}
}
