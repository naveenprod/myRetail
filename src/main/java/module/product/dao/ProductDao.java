package module.product.dao;

import module.product.domain.Product;


public interface ProductDao {
	
	public Product findPrice(String id);

}
