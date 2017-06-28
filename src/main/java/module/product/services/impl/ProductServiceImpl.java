package module.product.services.impl;

import module.common.ErrorCodeDescription;
import module.common.ErrorCodes;
import module.product.dao.ProductDao;
import module.product.dao.impl.ProductDaoImpl;
import module.product.domain.Product;
import module.product.rest.ProductConsume;
import module.product.rest.bo.ProductConsumerResponse;
import module.product.services.ProductService;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


public class ProductServiceImpl implements ProductService{

	private static ProductServiceImpl m_instance = new ProductServiceImpl();
	private static JSONObject response;
	private ProductServiceImpl(){
	}
	public static ProductServiceImpl getInstance(){
		return m_instance;
	}

	public String getProduct(String id) {
		boolean flag=false;
		JSONObject prodString=null;
		ProductConsumerResponse productResponse = ProductConsume.consumeProductService(id);
		Product prod = findProductPrice(id);
		if(productResponse!=null && prod!=null){
			if(productResponse.getError()==null && prod.getError()==null){
				prodString = makeResponse(productResponse,prod);
				if(!prodString.equals("")){
					flag = true;					
				}
			}
		}
		response = finalResponse(flag, prodString,productResponse.getError()!=null?productResponse.getError():prod.getError());
		return response.toString();
	}

	private JSONObject makeResponse(ProductConsumerResponse productResponse, Product priceResponse){
		JSONObject response = new JSONObject();
		
		JSONObject json = new JSONObject();
		json.put("id", priceResponse.getId());
		json.put("name", productResponse.getProductName());
		
		JSONObject price = new JSONObject();
		price.put("value", priceResponse.getPrice());
		price.put("currency_code", priceResponse.getCurrencyCode());
		
		json.put("current_price", price);
		response.put("response",json);
		return response;
	}
	/*private String makePriceResponse(Product prod){
		String priceResponse="";
		ObjectMapper mapper = new ObjectMapper();
		try {
			priceResponse = mapper.writeValueAsString(prod);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return priceResponse;
		}
		return priceResponse;
	}*/

	private Product findProductPrice(String id){
		ProductDao prodDao = new ProductDaoImpl();
		Product prod = prodDao.findPrice(id);
		return prod;
	}

	public static void main(String[] args) {

		new ProductServiceImpl().getProduct("16696651");
	}

	private JSONObject finalResponse(boolean flag, JSONObject prodString,String error){
		if(flag){
			response = new JSONObject("{Data:"+prodString.toString()+", Response :"+ErrorCodeDescription.SUCCESS+ "}");
		}else if(error.equals(ErrorCodes.INTERNALSERVERERROR)){
			response = new JSONObject("{Data:'No Data', Response:"+ErrorCodeDescription.INTERNALSERVERERROR+"}");
		}else {
			response = new JSONObject("{Data:'No Data', Response:"+ErrorCodeDescription.NOTFOUND+"}");
		}
		return response;
	}

}
