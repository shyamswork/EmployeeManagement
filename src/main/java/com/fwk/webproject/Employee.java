package com.fwk.webproject;

/**
 * Employee Information which are the .json file objects used for Employee data management.
 * The datatype is marked as String for simplicity and for easiness to work with JSON 
 * @author shyam
 *
 */


public class Employee {
	
	private String id ;
	
	private String fullName ;
	
	private String age;
	
	private String salary ;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullName=" + fullName + ", age=" + age + ", salary=" + salary + "]";
	}

	
	
	

}
