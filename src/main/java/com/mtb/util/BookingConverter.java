package com.mtb.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mtb.dto.BookingDTO;

import com.mtb.entity.Booking;

@Component
public class BookingConverter {

	// method to convert dto to booking entity
	public Booking convertDtoToBookingEntity(BookingDTO bDto) {
		Booking booking = new Booking();

		if (bDto != null) {

			// for all or use BeanUtils
			BeanUtils.copyProperties(bDto, booking);

		}

		return booking;

	}

	// method to convert booking entity to dto

	public BookingDTO convertBookingEntityToDto(Booking booking) {
		BookingDTO bDto = new BookingDTO();

		if (booking != null) {
			BeanUtils.copyProperties(booking, bDto);

		}
		return bDto;

	}
}
