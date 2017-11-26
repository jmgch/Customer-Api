package com.garciachicojm.customer.api.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.garciachicojm.customer.api.model.Customer;
import com.garciachicojm.customer.api.model.Properties;
import com.garciachicojm.customer.api.model.Response;

@RestController
public class SpringBootController
{
	@RequestMapping(value = "/rest/api/customer",
					method = { RequestMethod.POST },
					consumes = { MediaType.APPLICATION_JSON_VALUE },
					produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> create_customer(@RequestBody Customer customer)
	{
		ResponseEntity<?> responseEntity = null ;
		
		if (this.validCustomer(customer))
		{
			Response response = new Response() ;
			response.setId(customer.getId()) ;
			response.setStatus("successfully created") ;
			
			responseEntity = ResponseEntity.status(201).body(response) ;
		}
		else
		{
			responseEntity = ResponseEntity.status(401).body("{\"error\": \"Invalid customer\"}") ;
		}

		return responseEntity ;
	}
	
	private boolean validCustomer(Customer customer)
	{
		boolean validId = customer.getId() != null ;
		boolean validFirstName = customer.getFirst_name() != null && !customer.getFirst_name().isEmpty() ;
		boolean validLastName = customer.getLast_name() != null && !customer.getLast_name().isEmpty() ; 
		
		return validId && validFirstName && validLastName ;
	}

	@RequestMapping(value = "/rest/api/customer/{id}", method = { RequestMethod.GET })
	public ResponseEntity<?> get_customer(@PathVariable(value="id") int id)
	{
		ResponseEntity<?> responseEntity = null ;
		
		if (this.validCustomerId(id))
		{
			Customer customer = new Customer() ;
			customer.setId(1) ;
			customer.setFirst_name("Jose") ;
			customer.setLast_name("Garcia") ;
			
			Properties properties = new Properties() ;
			properties.setActive(true) ;
			properties.setAge(32) ;
			properties.setDate_of_birth("01/01/1984") ;
			
			customer.setProperties(properties);
			
			responseEntity = ResponseEntity.ok().body(customer) ;
		}
		else
		{
			responseEntity = ResponseEntity.status(404).body("{\"error\": \"There is no customer with given id\"}") ;
		}
		
		return responseEntity ;
	}	
	
	private boolean validCustomerId(int id)
	{
		return id == 1 ;
	}
}