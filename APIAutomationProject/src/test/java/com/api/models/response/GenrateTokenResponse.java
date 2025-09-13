package com.api.models.response;

public class GenrateTokenResponse {
	
	public GenrateTokenResponse()
	{
		
	}
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "GenrateTokenResponse [token=" + token + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public GenrateTokenResponse(String token) {
		super();
		this.token = token;
	}

}
