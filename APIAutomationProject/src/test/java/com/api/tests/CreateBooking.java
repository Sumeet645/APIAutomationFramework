package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.base.BookingService;
import com.api.models.request.BookingRequest;
import com.api.models.request.CreateBookingRequest;
import com.api.models.response.CreateBookingResponse;
import com.api.reporting.ExtentReportManager;

import io.restassured.http.Method;
import io.restassured.response.Response;

public class CreateBooking {
	
	private CreateBookingResponse response;
	
	

	@Test
	public void createBookingTest()
	{
		BookingRequest bookingdates=new BookingRequest.Builder()
				.checkin("2018-01-01").checkout("2019-01-01").build();
		
		CreateBookingRequest createBookingRequest=new CreateBookingRequest.Builder()
													.firstname("Tim").lastname("Brown").depositpaid(true).totalprice(121)
													.bookingdates(bookingdates).additionalneeds("Breakfast")
													.build();
													
		
		BookingService bookingService=new BookingService();
		response=bookingService.CreateBooking(createBookingRequest).as(CreateBookingResponse.class);
		
		
		  System.out.println(response.getBookingid());
		  System.out.println(response.getBooking().getFirstname());
		  System.out.println(response.getBooking().getLastname());
		  System.out.println(response.getBooking().getTotalprice());
		  System.out.println(response.getBooking().getBookingdates().getCheckin());
		  System.out.println(response.getBooking().getBookingdates().getCheckout());
		  Assert.assertEquals(response.getBooking().getFirstname(), "Tim");
		 
	}
	
	public int returnBookingId()
	{
		createBookingTest();
		return response.getBookingid();
	}
	
	

}
