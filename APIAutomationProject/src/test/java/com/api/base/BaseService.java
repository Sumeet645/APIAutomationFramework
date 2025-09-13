package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.models.request.GenerateTokenRequest;
import com.api.filters.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	
	private static final String BASE_URL="https://restful-booker.herokuapp.com";
	private RequestSpecification requestSpecification;
	
	static {
        RestAssured.filters(new LoggingFilter());
    }
	
	public BaseService()
	{
		requestSpecification=given().baseUri(BASE_URL);
	}
	
	public Response PostRequest(Object payload,String endpoint)
	{
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
	public Response GetRequest(String endpoint, Object id)
	{
		return requestSpecification.contentType(ContentType.JSON).get(endpoint + "/" + id );
	}
	
	
}
