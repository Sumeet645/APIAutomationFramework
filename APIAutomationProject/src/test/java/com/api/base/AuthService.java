package com.api.base;

import com.api.models.request.GenerateTokenRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService {

	private static final String BASE_PATH="/auth";
	
	public Response GenerateToken(GenerateTokenRequest payload)
	{
		return PostRequest(payload,BASE_PATH);
	}
			
	
}
