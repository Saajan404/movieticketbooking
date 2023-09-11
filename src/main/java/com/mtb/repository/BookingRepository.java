package com.mtb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mtb.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	@Query("from Booking where bookingId = :bb")
	int getBookedSeatById(@Param("bb") int bookingId);

}
