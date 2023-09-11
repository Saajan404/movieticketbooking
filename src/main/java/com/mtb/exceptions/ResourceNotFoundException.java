package com.mtb.exceptions;

public class ResourceNotFoundException extends RuntimeException{

private String resourseName;//movie,theater
	private String fieldName;//id,name,
	private Object fieldValue;//Object use field value may be String(name) int(id)
	
	
	
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		
		super(String.format("%s not found  with %s :'%s'", resourceName,fieldName,fieldValue));
		 
		this.resourseName = resourseName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
	
}
	

	

