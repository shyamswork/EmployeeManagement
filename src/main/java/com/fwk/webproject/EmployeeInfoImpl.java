package com.fwk.webproject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Implementation for the create , update , delete logic for the Employee records 
 * @author shyam
 *
 */
@Component
public class EmployeeInfoImpl implements EmployeeInfoFAO {

	@Autowired
	private EmployeeInfoFileUtil fileUtil;

	
	/**
	 * If employee Management information .json file exists 
	 * 		Create single Employee record or number of employee records as JSON array input to the json file 
	 * 		The new entries will be appended to the existing records at the last
	 * If the File not exist or file is empty 
	 *      File will be created and new records will be inserted .
	 */
	@Override
	public void createEmeployeeJSONObject(List<Employee> employees) {

		ObjectMapper mapper = new ObjectMapper();

		try {
			File employeeJsonFile = new File(this.fileUtil.getFilePath());
			boolean isEmpty = !employeeJsonFile.exists() || employeeJsonFile.length() == 0;
			if (!isEmpty) {
				List<Employee> employeesExistInFile = mapper.readValue(employeeJsonFile,
						new TypeReference<List<Employee>>() {
						});
				employeesExistInFile.addAll(employees);
				mapper.enable(SerializationFeature.INDENT_OUTPUT);
				mapper.writeValue(employeeJsonFile, employeesExistInFile);
			} else {
				fileUtil.createFileIfNotExist();
				mapper.enable(SerializationFeature.INDENT_OUTPUT);
				mapper.writeValue(employeeJsonFile, employees);
			}
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	/**
	 * Input is the JSON Array which will have the Employees need to update
	 * First step will be delete all records which are already exising in .json file based on the Employee.id
	 * The the List of Employees records will be inserted in to the file using this.createEmeployeeJSONObject() method
	 * which hence uses the same logic as create records 
	 * 
	 */
	@Override
	public void updateEmployeeJSONObject(List<Employee> employees) {

		for (Employee employee : employees) {
			deleteEmeployeeJSONObject(employee.getId());
		}
		createEmeployeeJSONObject(employees);
	}

	
	/**
	 * Deleting the records based on the Employee.id and write back only records which are needed . 
	 */
	@Override
	public void deleteEmeployeeJSONObject(final String id) {
		// TODO Auto-generated method stub

		ObjectMapper mapper = new ObjectMapper();

		try {
			File employeeJsonFile = new File(this.fileUtil.getFilePath());
			boolean isEmpty = !employeeJsonFile.exists() || employeeJsonFile.length() == 0;
			if (!isEmpty) {
				List<Employee> employeesExistInFile = mapper.readValue(employeeJsonFile,
						new TypeReference<List<Employee>>() {
						});
				List<Employee> modifieEmployeesList = new ArrayList<Employee>();
				for (Employee employee : employeesExistInFile) {
					if (!employee.getId().equals(id)) {
						modifieEmployeesList.add(employee);
					}
				}
				mapper.enable(SerializationFeature.INDENT_OUTPUT);
				mapper.writeValue(employeeJsonFile, modifieEmployeesList);
			} else {
				System.out.println("the file is empty to delete ");
			}
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * Method will retrieve back all the available employee records at a given point of time .
	 */
	@Override
	public List<Employee> getAllemployees() {
		
		
		ObjectMapper mapper = new ObjectMapper();
		List<Employee> employeesExistInFile = null;

		try {
			File employeeJsonFile = new File(this.fileUtil.getFilePath());
			boolean isEmpty = !employeeJsonFile.exists() || employeeJsonFile.length() == 0;
			if (!isEmpty) {
				employeesExistInFile = mapper.readValue(employeeJsonFile,
						new TypeReference<List<Employee>>() {});
			}else
			{
				employeesExistInFile = new ArrayList<Employee>();
			}
		}
			catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return employeesExistInFile;
	

}
	
}
