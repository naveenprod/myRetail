package module.product.rest;

import java.io.IOException;
import java.util.Properties;

import module.common.ErrorCodes;
import module.common.Util;
import module.product.rest.bo.ProductConsumerResponse;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class ProductConsume {
	private static Properties prop=null;
	private static String output="";
	
	public static ProductConsumerResponse consumeProductService(String id){
		ProductConsumerResponse prodResponse = new ProductConsumerResponse();
		try {
			prop = Util.getInstance().readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Client client = Client.create();
		WebResource webResource = client.resource(prop.getProperty("protocol")+prop.getProperty("domain")+prop.getProperty("type")+prop.getProperty("version")+id+prop.getProperty("postfix"));
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		if (response.getStatus() != 200) {
			prodResponse.setError(response.getStatus()+"");
		}
		output = (String) response.getEntity(String.class);	
		String prodName = Util.getInstance().jsonParsor(output);
		if(prodName==null) prodResponse.setError(ErrorCodes.NOTFOUND);
		prodResponse.setProductName(prodName);
		return prodResponse;
	}
}
