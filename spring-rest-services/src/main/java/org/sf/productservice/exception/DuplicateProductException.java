package org.sf.productservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class DuplicateProductException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String id;
	
	public DuplicateProductException() {
		// TODO Auto-generated constructor stub
	}
	
	public DuplicateProductException(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
