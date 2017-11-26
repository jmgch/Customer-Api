package com.garciachicojm.customer.api.controller;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.garciachicojm.customer.api.Launcher;
import com.garciachicojm.customer.api.controller.SpringBootController;
import com.garciachicojm.customer.api.model.Customer;
import com.garciachicojm.customer.api.model.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest(
		classes = Launcher.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootControllerTest
{
	
	@Test
	public void include_new_valid_customer()
	{
		Customer customer = new Customer();
		customer.setId(5);
		customer.setFirst_name("Jose");
		customer.setLast_name("Garcia");
		
		Properties properties = new Properties();
		properties.setActive(true);
		properties.setAge(22);
		properties.setDate_of_birth("01/01/1900");
		
		customer.setProperties(properties);
		
		SpringBootController sb = new SpringBootController();
		ResponseEntity<?> entity = sb.create_customer(customer);
		
		Assert.assertEquals(201, entity.getStatusCode().value());
	}
	
	@Test
	public void include_new_customer_wrong_id()
	{
		Customer customer = new Customer();
		customer.setFirst_name("Jose");
		customer.setLast_name("Garcia");
		
		Properties properties = new Properties();
		properties.setActive(true);
		properties.setAge(22);
		properties.setDate_of_birth("01/01/1900");
		
		customer.setProperties(properties);
		
		SpringBootController sb = new SpringBootController();
		ResponseEntity<?> entity = sb.create_customer(customer);

		Assert.assertEquals("{\"error\": \"Invalid customer\"}", entity.getBody().toString());
		Assert.assertEquals(401, entity.getStatusCode().value());
	}
	
	@Test
	public void include_new_customer_wrong_first_name()
	{
		Customer customer = new Customer();
		customer.setId(1);
		customer.setFirst_name("");
		customer.setLast_name("Garcia");
		
		Properties properties = new Properties();
		properties.setActive(true);
		properties.setAge(22);
		properties.setDate_of_birth("01/01/1900");
		
		customer.setProperties(properties);
		
		SpringBootController sb = new SpringBootController();
		ResponseEntity<?> entity = sb.create_customer(customer);
		
		Assert.assertEquals("{\"error\": \"Invalid customer\"}", entity.getBody().toString());
		Assert.assertEquals(401, entity.getStatusCode().value());
	}
	
	@Test
	public void include_new_customer_wrong_last_name()
	{
		Customer customer = new Customer();
		customer.setId(1);
		customer.setFirst_name("Jose");
		customer.setLast_name("");
		
		Properties properties = new Properties();
		properties.setActive(true);
		properties.setAge(22);
		properties.setDate_of_birth("01/01/1900");
		
		customer.setProperties(properties);
		
		SpringBootController sb = new SpringBootController();
		ResponseEntity<?> entity = sb.create_customer(customer);
		
		Assert.assertEquals("{\"error\": \"Invalid customer\"}", entity.getBody().toString());
		Assert.assertEquals(401, entity.getStatusCode().value());
	}
}
