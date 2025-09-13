package com.api.base;

import com.api.models.request.CreateBookingRequest;

import io.restassured.response.Response;

public class BookingService extends BaseService {

	private String BASE_PATH="/booking";
	
	public Response CreateBooking(CreateBookingRequest payload)
	{
		return PostRequest(payload,BASE_PATH);
	}
	
	public Response GetBooking(int id)
	{
		return GetRequest(BASE_PATH,id);
	}
	
	
}
