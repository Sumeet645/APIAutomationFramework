package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.api.reporting.ExtentReportManager;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter{
	
	private static final Logger logger=LogManager.getLogger(LoggingFilter.class);

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		
		logRequest(requestSpec);
		
		Response response=ctx.next(requestSpec, responseSpec);
		System.out.println(response.asPrettyString());
		System.out.println(response.statusCode());
		logResponse(response);
		
		return response;
	}
	
	private void logRequest(FilterableRequestSpecification requestSpec) 
	{
		logger.info("Request : {}, {}",requestSpec.getMethod(),requestSpec.getURI());
		logger.info("Headers: {}",requestSpec.getHeaders());
		ExtentReportManager.logRequest(requestSpec);
	}
	
	private void logResponse(Response response)
	{
		logger.info("Status code: {} ", response.statusCode());
		logger.info("Response Body: {} ", response.asPrettyString());
		ExtentReportManager.logResponse(response);
	}

}
