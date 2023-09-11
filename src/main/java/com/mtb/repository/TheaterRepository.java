package com.mtb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mtb.entity.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Integer>{

//	 @Query("select toatalSeat t from Theater t where theaterId= :t")
//	 int getNumberOfSeatById(@Param("t") int tId);
	
	Optional<Theater> findById(int theaterId);
//	
}
