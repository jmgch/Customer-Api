package com.garciachicojm.customer.api.controller;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.garciachicojm.customer.api.controller.SpringBootController;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberControllerTest
{
	@Autowired
	private TestRestTemplate restTemplate;
	
	private ResponseEntity<?> response;
	
	@When("^the client calls /rest/api/customer/(\\d+)$")
	public void the_client_issues_GET_version(int id) throws Throwable
	{
		SpringBootController sb = new SpringBootController();
		this.response = sb.get_customer(id);
	}
	 
	@Then("^the client receives status code of (\\d+)$")
	public void the_client_receives_status_code_of(int statusCode) throws Throwable
	{
		Assert.assertEquals(statusCode, this.response.getStatusCode().value());
	}
}
