package com.mtb.dto;

import java.time.LocalDate;
import java.util.List;


import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.mtb.entity.ShowTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovieDTO {

	
	private int movieId;
	
	

	@NotNull(message = "movie title is required")
	@Size(max= 100,message = "max 100 character required")
	@Size(min = 2, message = "min. 2 character required")
	@NotBlank(message = "Please enter correct movie name")
	private String movieTitle;
	
	@NotNull(message = " release date is required")
	private LocalDate  releasedate;
	
	@NotNull(message = "director name is required")
	@Size(max= 30,message = "max 30 character required")
	@Size(min = 2, message = "min. 2 character required")
	@NotBlank(message = "Please enter correct director name")
	private String director;
	
	@NotNull(message = "duration is required")
	@Size(max= 20,message = "max 20 character required")
	@Size(min = 2, message = "min. 2 character required")
	private String duration;
	
	@NotNull(message = " lanuage is required")
	@Size(max= 20,message = "max 20 character required")
	@Size(min = 2, message = "min. 2 character required")
	private String language;
	
	
	@OneToMany
	private List<ShowTime> showTime;

	
}
