/**
 * 
 */
package com.example.api.connectapps.apiconnectApps.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author enzzitomartin12
 *
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String resourceField;
	private long value;
	
	public ResourceNotFoundException(String resourceName, String resourceField, long value) {
		super(String.format("%s NOT FOUND : %s : % %s", resourceName, resourceField, value));
		this.resourceName = resourceName;
		this.resourceField = resourceField;
		this.value = value;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourceField() {
		return resourceField;
	}
	public void setResourceField(String resourceField) {
		this.resourceField = resourceField;
	}
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
