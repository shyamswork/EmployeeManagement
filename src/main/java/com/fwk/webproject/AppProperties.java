package com.fwk.webproject;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * The bean class for app properties which can be injected run time and can be
 * used different places of the application
 * 
 * @author shyam
 *
 */

@Component
@ConfigurationProperties("app")
public class AppProperties {
	
	private String filedir;
	
	private String fileName;

	public String getFiledir() {
		return filedir;
	}

	public void setFiledir(String filedir) {
		this.filedir = filedir;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ""+this.filedir+""+ this.fileName;
	}

}
