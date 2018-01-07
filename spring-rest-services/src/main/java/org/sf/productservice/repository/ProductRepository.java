package org.sf.productservice.repository;

import java.util.List;

import org.sf.productservice.domain.Product;

public interface ProductRepository {

	Product getProductById(String id);
	List<Product> getAllProducts();
	Product addNewProduct(Product product);
	
}
