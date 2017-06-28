package module.product.dao.helper;

import module.common.ErrorCodes;
import module.product.domain.Product;
import module.product.domain.dto.ProductDto;
import module.product.rest.ProductConsume;
import module.product.rest.bo.ProductConsumerResponse;

import com.mongodb.DBObject;


public class ProductDaoHelper {
	
	private String SUCCESS="200";
	
	private ProductDaoHelper(){
		
	}
	private static ProductDaoHelper productDaoHelper = new ProductDaoHelper();
	
	public static ProductDaoHelper getInstance(){
		return productDaoHelper;
	}
	
	public Product populateData(DBObject productData,String id){
		Product product = new ProductDto();
		if(productData==null){
			product.setError(ErrorCodes.NOTFOUND);
			return product;
		}
		product.setId(String.valueOf(productData.get("_id")));
		product.setPrice(Double.parseDouble(productData.get("price").toString()));
		product.setCurrencyCode(String.valueOf(productData.get("currcode")));
		return product;
	}
	

}
