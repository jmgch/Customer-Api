Feature: the customer is returned
	Scenario: client makes call to GET /rest/api/customer/1
		When the client calls /rest/api/customer/1
		Then the client receives status code of 200
		