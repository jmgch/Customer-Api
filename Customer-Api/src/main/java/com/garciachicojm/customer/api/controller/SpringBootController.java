package com.garciachicojm.customer.api.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
public class SpringBootController {
	
	private int MAX_AGE = 115;
	
	@RequestMapping(value = "/rest/api/customer", method = { RequestMethod.POST }, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> create_customer(@RequestBody Customer customer) {
		ResponseEntity<?> responseEntity = null;

		if (this.validCustomer(customer)) {
			Response response = new Response();
			response.setId(customer.getId());
			response.setStatus("successfully created");

			responseEntity = ResponseEntity.status(201).body(response);
		} else {
			responseEntity = ResponseEntity.status(401).body(
					"{\"error\": \"Invalid customer\"}");
		}

		return responseEntity;
	}

	private boolean validCustomer(Customer customer) {
		boolean validId = customer.getId() != null && customer.getId() >= 1;
		boolean validFirstName = customer.getFirst_name() != null
				&& !customer.getFirst_name().isEmpty();
		if(validFirstName) validFirstName = customer.getFirst_name().matches("[A-Za-z ]+");
		
		boolean validLastName = customer.getLast_name() != null
				&& !customer.getLast_name().isEmpty()
				&& customer.getLast_name().matches("[A-Za-z ]+");
		if(validLastName) validLastName = customer.getLast_name().matches("[A-Za-z ]+");
		
		boolean validProperties = customer.getProperties()!=null;
		boolean validAge = true;
		if(validProperties && customer.getProperties().getAge() != null){
			if(customer.getProperties().getAge()<0 || customer.getProperties().getAge()>MAX_AGE){
				validAge = false;
			}
		}
		
		boolean validBirth = true;
		if(validProperties && customer.getProperties().getDate_of_birth() != null && !customer.getProperties().getDate_of_birth().isEmpty()){
			if(customer.getProperties().getDate_of_birth().matches("([0-2][0-9]|3[0-1])/(0[0-9]|1[0-2])/([0-9][0-9][0-9][0-9])")){
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate currentDate = LocalDate.now();
				LocalDate customerDate = LocalDate.parse(customer.getProperties().getDate_of_birth(),dtf);
				validBirth = currentDate.isAfter(customerDate);
			}else{
				validBirth = false;
			}
		}
		
		return validId && validFirstName && validLastName && validAge && validBirth;
	}

	@RequestMapping(value = "/rest/api/customer/{id}", method = { RequestMethod.GET })
	public ResponseEntity<?> get_customer(@PathVariable(value = "id") int id) {
		ResponseEntity<?> responseEntity = null;

		// As I do not have a DDBB, I have created an example of customer to
		// test if Id is already saved or not
		if (this.validCustomerId(id)) {
			Customer customer = new Customer();
			customer.setId(1);
			customer.setFirst_name("Jose");
			customer.setLast_name("Garcia");

			Properties properties = new Properties();
			properties.setActive(true);
			properties.setAge(32);
			properties.setDate_of_birth("01/01/1984");

			customer.setProperties(properties);

			responseEntity = ResponseEntity.status(200).body(customer);
		} else {
			responseEntity = ResponseEntity.status(404).body(
					"{\"error\": \"There is no customer with given id\"}");
		}

		return responseEntity;
	}

	private boolean validCustomerId(int id) {
		return id == 1;
	}
}