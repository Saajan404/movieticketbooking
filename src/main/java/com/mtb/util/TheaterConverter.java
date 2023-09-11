package com.mtb.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mtb.dto.TheaterDTO;

import com.mtb.entity.Theater;

@Component
public class TheaterConverter {

	// method to convert dto to Theater entity
	public Theater convertDtoToTheaterEntity(TheaterDTO thDto) {
		Theater theater = new Theater();

		if (thDto != null) {

			// for all or use BeanUtils
			BeanUtils.copyProperties(thDto, theater);

		}

		return theater;

	}

	// method to convert Theater entity to dto

	public TheaterDTO convertTheaterEntityToDto(Theater theater) {
		TheaterDTO thDto = new TheaterDTO();

		if (theater != null) {
			BeanUtils.copyProperties(theater, thDto);

		}
		return thDto;

	}
}
