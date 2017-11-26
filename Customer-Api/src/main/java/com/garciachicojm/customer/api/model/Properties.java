package com.garciachicojm.customer.api.model;

public class Properties
{
	private int age ;
	
	private boolean active ;
	
	private String date_of_birth ;

	public Properties()
	{
		super() ;
	}

	public int getAge()
	{
		return this.age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public boolean isActive()
	{
		return this.active;
	}

	public void setActive(boolean active)
	{
		this.active = active;
	}

	public String getDate_of_birth()
	{
		return this.date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth)
	{
		this.date_of_birth = date_of_birth;
	}
	
	
}
