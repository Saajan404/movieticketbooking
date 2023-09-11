package com.mtb.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mtb.dto.ShowTimeDTO;
import com.mtb.entity.ShowTime;


@Component
public class ShowTImeConverter {

	// method to convert dto to Showtime entity
		public ShowTime convertDtoToShowTimeEntity(ShowTimeDTO STDto) {
			ShowTime showTime = new ShowTime();

			if (STDto != null) {

				// for all or use BeanUtils
				BeanUtils.copyProperties(STDto, showTime);

			}

			return showTime;

		}

		// method to convert ShowTime entity to dto

		public ShowTimeDTO convertShowTimeEntityToDto(ShowTime showTime) {
			ShowTimeDTO STDto = new ShowTimeDTO();

			if (showTime != null) {
				BeanUtils.copyProperties(showTime, STDto);

			}
			return STDto;

		}
	
}
