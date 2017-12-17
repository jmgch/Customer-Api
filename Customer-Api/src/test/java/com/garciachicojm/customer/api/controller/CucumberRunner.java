package com.garciachicojm.customer.api.controller;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/Destination"},monochrome = true)
public class CucumberRunner
{
	// Empty class
}