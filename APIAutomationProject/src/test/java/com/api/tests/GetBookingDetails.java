package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.BookingService;

import io.restassured.response.Response;

public class GetBookingDetails {

	@Test
	public void getBookingDetails()
	{
		CreateBooking createBooking=new CreateBooking();
		int bookingId=createBooking.returnBookingId();
		
		BookingService bookingService=new BookingService();
		
		Response response= bookingService.GetBooking(bookingId);
		System.out.println(response.asPrettyString());
	}
}
