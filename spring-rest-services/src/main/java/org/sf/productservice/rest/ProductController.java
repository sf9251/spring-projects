package org.sf.productservice.rest;

import java.util.List;

import org.sf.productservice.domain.Product;
import org.sf.productservice.domain.ProductError;
import org.sf.productservice.exception.DuplicateProductException;
import org.sf.productservice.exception.NoProductAvailableException;
import org.sf.productservice.exception.ProductNotFoundException;
import org.sf.productservice.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value="/products/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Product getProduct(@PathVariable String id) {
		return this.productRepository.getProductById(id);
	}
	
	@RequestMapping(value="/products", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getAllProducts() {
		return this.productRepository.getAllProducts();
	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Product addProducts(@RequestBody Product product) {
		return this.productRepository.addNewProduct(product);
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value=DuplicateProductException.class)
	public ProductError handleDuplicateProductException(DuplicateProductException ex) {
		return new ProductError(ex.getId(), "Product with product id [ " + ex.getId() + " ] already exists.");
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value=NoProductAvailableException.class)
	public ProductError noProductAvailabeException(NoProductAvailableException ex) {
		return new ProductError("N/A", "Product list is empty.");
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value=ProductNotFoundException.class)
	public ProductError productNotFoundException(ProductNotFoundException ex) {
		return new ProductError(ex.getId(), "Product with product id [ " + ex.getId() + " ] not found.");
	}
}