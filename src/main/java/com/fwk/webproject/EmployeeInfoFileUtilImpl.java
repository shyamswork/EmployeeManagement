package com.fwk.webproject;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The is an Employee information utility class
 * 
 * @author shyam
 *
 */

@Component
public class EmployeeInfoFileUtilImpl implements EmployeeInfoFileUtil {

	@Autowired
	private AppProperties appProperties;

	/*
	 * Create the Employee information management .json file directory and file if
	 * not exists
	 * This method will be executed after the bean initialization every time the application boots up .
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fwk.webproject.EmployeeInfoFileUtil#createFileIfNotExist()
	 */
	@Override
	@PostConstruct
	public void createFileIfNotExist() {

		try {
			// System.out.println("path: " + appProperties.toString());
			File file = new File(appProperties.toString());
			boolean isSuccess = file.createNewFile();
			if (!isSuccess)
				System.out.println("Failed to create the json file , perhaps file already exist ");
			else
				System.out
						.println(appProperties.toString() + " json file create successfully ");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get the absolution file path for the .json file
	 */
	@Override
	public String getFilePath() {
		return appProperties.toString();
	}

}
