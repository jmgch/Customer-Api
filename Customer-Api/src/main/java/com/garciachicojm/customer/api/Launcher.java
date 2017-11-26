package com.garciachicojm.customer.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.garciachicojm.customer.api.controller.SpringBootController;


@SpringBootApplication
@ComponentScan(basePackageClasses = { SpringBootController.class })
public class Launcher
{
	public static void main(String[] args)
	{
		SpringApplication.run(Launcher.class, args) ;
	}
}