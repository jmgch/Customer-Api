Feature: the customer is created
	Scenario: include a valid customer calling /rest/api/customer
		Given id 5, name Jose, lastName Garcia, active true, age 22, birth 01/01/1900
		When the client calls /rest/api/customer
		Then the client receives status code of 201
	
	Scenario: include a valid customer without properties calling /rest/api/customer
		Given no properties, id 5, name Jose, lastName Garcia
		When the client calls /rest/api/customer
		Then the client receives status code of 201
	
	Scenario: include a customer with null id calling /rest/api/customer
		Given null id, name Jose, lastName Garcia, active true, age 22, birth 01/01/1900
		When the client calls /rest/api/customer
		Then the client receives status code of 401
		
	Scenario: include a customer with null name calling /rest/api/customer
		Given null name, id 5, lastName Garcia, active true, age 22, birth 01/01/1900
		When the client calls /rest/api/customer
		Then the client receives status code of 401
		
	Scenario: include a customer with blank name calling /rest/api/customer
		Given id 5, name , lastName Garcia, active true, age 22, birth 01/01/1900
		When the client calls /rest/api/customer
		Then the client receives status code of 401
		
	Scenario: include a customer with null lastName calling /rest/api/customer
		Given null lastName, id 5, name Jose, active true, age 22, birth 01/01/1900
		When the client calls /rest/api/customer
		Then the client receives status code of 401
		
	Scenario: include a customer with blank lastName calling /rest/api/customer
		Given id 5, name Jose, lastName , active true, age 22, birth 01/01/1900
		When the client calls /rest/api/customer
		Then the client receives status code of 401				