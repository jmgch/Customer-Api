package com.garciachicojm.customer.api.model;


public class Customer
{
	private Integer id ;
	
	private String first_name ;
	
	private String last_name ;
	
	private Properties properties ;

	public Customer()
	{
		super() ;
	}

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getFirst_name()
	{
		return this.first_name;
	}

	public void setFirst_name(String first_name)
	{
		this.first_name = first_name;
	}

	public String getLast_name()
	{
		return this.last_name;
	}

	public void setLast_name(String last_name)
	{
		this.last_name = last_name;
	}

	public Properties getProperties()
	{
		return this.properties ;
	}

	public void setProperties(Properties properties)
	{
		this.properties = properties;
	}
}
