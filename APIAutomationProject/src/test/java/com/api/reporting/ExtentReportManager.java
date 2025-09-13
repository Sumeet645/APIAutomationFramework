package com.api.reporting;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test=new ThreadLocal<>();;

    // Create instance only once
    public static ExtentReports createInstance() {
        if (extent == null) {
            String filename=generateReportFileName();
            ExtentSparkReporter sparkReporter=new ExtentSparkReporter("test-output/reports/" + filename);
            
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setDocumentTitle("API Test Report");
            sparkReporter.config().setReportName("Rest API Test Results");
            
            extent=new ExtentReports();
            extent.attachReporter(sparkReporter);
        }  
            
        return extent;
    }
    
    private static String generateReportFileName()
    {
    	DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
    	return "APITestReport_" + dtf.format(LocalDateTime.now()) + ".html";
    }

    public static void startTest(String testName) {
       ExtentTest extentTest = createInstance().createTest(testName);
        test.set(extentTest);
    }


    public static void endTest() {
        if (extent != null) {
            extent.flush();
        }
    }
    
    public static void logRequest(FilterableRequestSpecification requestSpec) {
        StringBuilder requestDetails = new StringBuilder();

        requestDetails.append("<pre>");
        requestDetails.append("Request Method: ").append(requestSpec.getMethod()).append("\n");
        requestDetails.append("Request URI: ").append(requestSpec.getURI()).append("\n");
        requestDetails.append("Request Headers: ").append("\n");

        for (Header header : requestSpec.getHeaders()) {
            requestDetails.append(header.getName()).append(": ").append(header.getValue()).append("\n");
        }

        if (requestSpec.getBody() != null) {
            requestDetails.append("Request Body: \n").append(requestSpec.getBody().toString());
        }

        requestDetails.append("</pre>");

        test.get().log(Status.INFO, "Request Details: " + requestDetails.toString());
    }

    public static void logResponse(Response response) {
        StringBuilder responseDetails = new StringBuilder();

        responseDetails.append("<pre>");
        responseDetails.append("Status Code: ").append(response.statusCode()).append("\n");
        responseDetails.append("Response Body: \n").append(response.asPrettyString());
        responseDetails.append("</pre>");

        test.get().log(Status.INFO, "Response Details: " + responseDetails.toString());
    }

}

