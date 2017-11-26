package com.garciachicojm.customer.api.model;

public class Response
{
	private int id ;
	
	private String status ;

	public Response()
	{
		super() ;
	}

	public int getId()
	{
		return this.id ; 
	}

	public void setId(int id)
	{
		this.id = id ;
	}

	public String getStatus()
	{
		return this.status ;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}
}
