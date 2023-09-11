package com.mtb.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mtb.entity.Address;
import com.mtb.entity.Theater;
import com.mtb.repository.TheaterRepository;
import com.mtb.service.TheaterService;

@SpringBootTest
class TheaterserviceTest {

	@Autowired
	TheaterService theaterService;

	@MockBean
	TheaterRepository theaterRepository;

	//positive test case
	@Test
	void testSaveStudent() {

		Address add = Address.builder().city("faridabad").locality("basantpur").state("haryana").pincode(121003)
				.build();

		Theater theater = Theater.builder().theaterName("inox").totalSeat(200).address(add).build();

		Mockito.when(theaterRepository.save(theater)).thenReturn(theater);

		assertEquals("inox", theaterService.saveTheater(theater).getTheaterName());

	}

	//negative test case
	@Test
	void testGetTheaterById() {
		Address add = Address.builder().city("faridabad").locality("basantpur").state("haryana").pincode(121003)
				.build();
		Theater theater = Theater.builder().theaterName("inox").totalSeat(200).address(add).build();

		
		Mockito.when(theaterRepository.findById(theater.getTheaterId())).thenReturn(Optional.of(theater));

		assertEquals("PVR Superplex", theaterService.saveTheater(theater).getTheaterName());


	}

}
