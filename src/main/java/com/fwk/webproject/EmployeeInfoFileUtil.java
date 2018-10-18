package com.fwk.webproject;

import org.springframework.stereotype.Component;

/**
 * Utiltity class for file handling .
 * @author shyam
 *
 */
@Component
public interface EmployeeInfoFileUtil {

	/*
	 * Create the Employee information management .json file directory and file if
	 * not exists
	 * Used for file creation during application boot up.
	 */
	public  void createFileIfNotExist();
	
	/**
	 * Get the absolute path of the existing file for Employee information mangement .
	 * @return
	 */
	public String getFilePath();

}