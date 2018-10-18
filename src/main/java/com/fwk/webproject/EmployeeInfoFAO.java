package com.fwk.webproject;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

/**
 * This is the File Access Object (FAO) which is used for .json file managment having following functions 
 * 1. Create a new Employee records
 * 2. Update an existing Employee records
 * 3. Delete an existing Employee record 
 * 4. Get all records from json file 
 * 
 * @author shyam
 *
 */
@Component
public interface EmployeeInfoFAO {

	/*
	 *  Create  new Employee record(s)
	 */
	public void createEmeployeeJSONObject(final List<Employee> employees);
	
	/*
	 * Update  existing Employee record(s)
	 */
	public void updateEmployeeJSONObject(final List<Employee> employees );

	/*
	 * Delete an existing Employee record
	 */
	public void deleteEmeployeeJSONObject(final String id);

	/**
	 * Get all employees present in emeployee info json file at a given point .
	 * @return
	 */
	public List<Employee> getAllemployees();
	
	
}
