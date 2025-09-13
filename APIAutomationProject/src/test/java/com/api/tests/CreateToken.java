package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.GenerateTokenRequest;
import com.api.models.response.GenrateTokenResponse;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateToken {
	
	@Test
	public void createTokenTest()
	{
		GenerateTokenRequest generateTokenRequest=new GenerateTokenRequest("admin","password123");
		AuthService authService=new AuthService();
		
		Response response=authService.GenerateToken(generateTokenRequest);
		
		GenrateTokenResponse generateTokenResponse=response.as(GenrateTokenResponse.class);
		
		System.out.println("Token is " + generateTokenResponse.getToken());
	}

}
