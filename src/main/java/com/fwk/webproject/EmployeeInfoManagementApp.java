package com.fwk.webproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Application start up class which will instantiate all framework beans .
 * @author shyam
 *
 */
@SpringBootApplication
public class EmployeeInfoManagementApp {
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(EmployeeInfoManagementApp.class, args);
		
		
	}
}
