package com.api.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateBookingResponse {
	
	private int bookingid;
	private BookingResponse booking;
	
	
	
	public CreateBookingResponse()
	{
		
	}
	
	@Override
	public String toString() {
		return "CreateBookingResponse [bookingid=" + bookingid + ", booking=" + booking + "]";
	}
	public CreateBookingResponse(int bookingid, BookingResponse booking, String additionalneeds) {
		super();
		this.bookingid = bookingid;
		this.booking = booking;
		
	}
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public BookingResponse getBooking() {
		return booking;
	}
	public void setBooking(BookingResponse booking) {
		this.booking = booking;
	}
	
	
	
	

}
