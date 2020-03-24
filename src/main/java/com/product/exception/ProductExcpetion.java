package com.product.exception;

public class ProductExcpetion extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductExcpetion(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductExcpetion(String message) {
		super(message);
	}

}
