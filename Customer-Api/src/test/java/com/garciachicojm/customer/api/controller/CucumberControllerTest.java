package com.garciachicojm.customer.api.controller;

import org.junit.Assert;
import org.springframework.http.ResponseEntity;

import com.garciachicojm.customer.api.model.Customer;
import com.garciachicojm.customer.api.model.Properties;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberControllerTest
{	
	Customer customer = null;
	
	ResponseEntity<?> response = null;
	
	@Before
	public void Before(Scenario scenario){
		System.out.println("--------------------");
		System.out.println("Starting - " + scenario.getName());
		System.out.println("--------------------");

		customer = new Customer();
	}
	
	@Given("^id (-?\\d+), name (.*), lastName (.*), active (.*), age (-?\\d+), birth (.*)$")
	public void customer_to_be_included(int id, String name, String lastName, String active, int age, String birth) throws Throwable
	{	
		this.customer.setId(id);
		this.customer.setFirst_name(name);
		this.customer.setLast_name(lastName);
		
		Properties properties = new Properties();
		properties.setActive(Boolean.parseBoolean(active));
		properties.setAge(age);
		properties.setDate_of_birth(birth);
		
		this.customer.setProperties(properties);
	}
	
	@Given("^no properties, id (-?\\d+), name (.*), lastName (.*)$")
	public void customer_to_be_included_without_properties(int id, String name, String lastName) throws Throwable
	{	
		this.customer.setId(id);
		this.customer.setFirst_name(name);
		this.customer.setLast_name(lastName);
	}
	
	@Given("^null id, name (.*), lastName (.*), active (.*), age (\\d+), birth (.*)$")
	public void customer_to_be_included_with_null_id(String name, String lastName, String active, int age, String birth) throws Throwable
	{	
		this.customer.setFirst_name(name);
		this.customer.setLast_name(lastName);
		
		Properties properties = new Properties();
		properties.setActive(Boolean.parseBoolean(active));
		properties.setAge(age);
		properties.setDate_of_birth(birth);
		
		this.customer.setProperties(properties);
	}
	
	@Given("^null name, id (-?\\d+), lastName (.*), active (.*), age (\\d+), birth (.*)$")
	public void customer_to_be_included_with_invalid_name(int id, String lastName, String active, int age, String birth) throws Throwable
	{	
		this.customer.setId(id);
		this.customer.setLast_name(lastName);
		
		Properties properties = new Properties();
		properties.setActive(Boolean.parseBoolean(active));
		properties.setAge(age);
		properties.setDate_of_birth(birth);
		
		this.customer.setProperties(properties);
	}

	@Given("^null lastName, id (-?\\d+), name (.*), active (.*), age (\\d+), birth (.*)$")
	public void customer_to_be_included_with_invalid_lastName(int id, String name, String active, int age, String birth) throws Throwable
	{	
		this.customer.setId(id);
		this.customer.setFirst_name(name);
		
		Properties properties = new Properties();
		properties.setActive(Boolean.parseBoolean(active));
		properties.setAge(age);
		properties.setDate_of_birth(birth);
		
		this.customer.setProperties(properties);
	}
		
	@When("^the user calls /rest/api/customer$")
	public void the_client_issues_POST() throws Throwable
	{
		SpringBootController sb = new SpringBootController();
		this.response = sb.create_customer(customer);
	}
	
	@When("^the user calls /rest/api/customer/(-?\\d+)$")
	public void the_client_issues_GET(int id) throws Throwable
	{
		SpringBootController sb = new SpringBootController();
		this.response = sb.get_customer(id);
	}
	 
	@Then("^the user receives status code of (\\d+)$")
	public void the_client_receives_status_code(int statusCode) throws Throwable
	{
		Assert.assertEquals(statusCode, this.response.getStatusCode().value());
	}
	
	@After
	public void after(Scenario scenario){
		System.out.println("--------------------");
		System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
		System.out.println("--------------------");
	}
}
