package com.mtb.exceptions;

public class MoreSeatNotAvailavleException extends RuntimeException {

	
	
	int totalSeat;
	public MoreSeatNotAvailavleException( int totalSeat) {
		super(String.format("only %d seats available ",totalSeat));
		
		this.totalSeat = totalSeat;
	}

	

	

	
}
