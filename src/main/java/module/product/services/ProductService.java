package module.product.services;

import module.product.domain.Product;

public interface ProductService {
	
	public String getProduct(String id); 
	public String updateProduct(Product toBeUpdate);
	
}
