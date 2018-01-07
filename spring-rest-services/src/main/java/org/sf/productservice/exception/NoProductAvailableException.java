package org.sf.productservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class NoProductAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NoProductAvailableException() {
		// TODO Auto-generated constructor stub
	}
}
