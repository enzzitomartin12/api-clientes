/**
 * 
 */
package com.example.api.connectapps.apiconnectApps.dto;

/**
 * @author enzzitomartin12
 *
 */
public class ResponseApiDTO {
	
	private String response;
	private Integer value;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	public ResponseApiDTO() {
		
	}

	public ResponseApiDTO(String response, Integer value) {
		super();
		this.response = response;
		this.value = value;
	}
	
	

}
