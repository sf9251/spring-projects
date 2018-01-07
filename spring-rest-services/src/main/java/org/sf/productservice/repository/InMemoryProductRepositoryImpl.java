package org.sf.productservice.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sf.productservice.domain.Product;
import org.sf.productservice.exception.DuplicateProductException;
import org.sf.productservice.exception.NoProductAvailableException;
import org.sf.productservice.exception.ProductNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryProductRepositoryImpl implements ProductRepository {

	private Map<String, Product> products = new HashMap<String, Product>(); 
	
	@Override
	public Product getProductById(String id) {
		if (this.products.containsKey(id))
			return this.products.get(id);
		else
			throw new ProductNotFoundException(id);
	}

	@Override
	public List<Product> getAllProducts() {
		if (this.products.size() > 0)
			return new ArrayList<Product>(this.products.values());
		else
			throw new NoProductAvailableException();
	}

	@Override
	public Product addNewProduct(Product product) {
		if (!this.products.containsKey(product.getId())) {
			this.products.put(product.getId(), product);
			return product;
		} else
			throw new DuplicateProductException(product.getId());
	}

}
