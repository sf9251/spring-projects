package org.sf.productservice.domain;

public class ProductError {

	private String productId;
	private String errorMessage;

	public ProductError(String productId, String errorMessage) {
		super();
		this.productId = productId;
		this.errorMessage = errorMessage;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
