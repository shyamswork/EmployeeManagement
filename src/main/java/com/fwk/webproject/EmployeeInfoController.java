/**
 * 
 */
package com.fwk.webproject;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * End point or the controller class which has the REST API definition
 * 
 * @author shyam
 *
 */
@RestController
public class EmployeeInfoController {

	@Autowired
	private EmployeeInfoFAO infoService;

	/*
	 * URL sample : POST : http://localhost:8080/create-employee 
	 * ******body****** 
	 * [
	 * { "id" : "500", 
	 * "fullName" : "abru",
	 *  "age" : "25",
	 *   "salary" : "30000" },
	 * {
	 * "id" : "400", 
	 * "fullName" : "don", 
	 * "age" : "30", 
	 * "salary" : "100000" } 
	 * ]
	 * 
	 * Create new Employee record(s) Return back the modified content of the .json
	 * file for debug or test
	 */
	@PostMapping(path = "/create-employee")
	public List<Employee> createEmeployee(@RequestBody List<Employee> employees) {
		System.out.println(employees.toString());
		infoService.createEmeployeeJSONObject(employees);
		return infoService.getAllemployees();
	}

	/*
	 * URL sample : POST : http://localhost:8080/update-employee 
	 * 
	 * 	 * ******body****** 
	 * [
	 * { "id" : "500", 
	 * "fullName" : "updated",
	 *  "age" : "25",
	 *   "salary" : "30000" },
	 * {
	 * "id" : "400", 
	 * "fullName" : "updated", 
	 * "age" : "30", 
	 * "salary" : "100000" } 
	 * ]
	 * Update existing Employee record(s) Return back the modified content of the
	 * .json file for debug or test
	 */
	@PostMapping(path = "/update-employee")
	public List<Employee> updateEmployee(@RequestBody List<Employee> employee) {
		infoService.updateEmployeeJSONObject(employee);
		return infoService.getAllemployees();
	}

	/*
	 * URL sample : DELETE : http://localhost:8080/delete-employee/300 
	 * 
	 * Delete an existing Employee record Return back the modified content of the .json file
	 * for debug or test
	 */
	@DeleteMapping(path = "/delete-employee/{id}")
	public List<Employee> deleteEmeployee(@PathVariable String id) {
		infoService.deleteEmeployeeJSONObject(id);
		return infoService.getAllemployees();
	}

}
