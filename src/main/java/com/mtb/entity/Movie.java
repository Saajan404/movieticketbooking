package com.mtb.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Movie_Details")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;
	
	@Column(length = 100, nullable = false, unique = true)
	private String movieTitle;
	
	@Column
	private LocalDate  releasedate;
	
	@Column(length = 30 ,nullable = false)
	private String director;
	
	@Column(length = 20, nullable = false)
	private String duration;
	
	@Column(length = 20, nullable = false)
	private String language;
	
	
	@OneToMany
	private List<ShowTime> showTime;

}
