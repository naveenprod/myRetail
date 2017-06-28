package module.product.rest;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import module.product.services.ProductService;
import module.product.services.impl.ProductServiceImpl;


@Path("/products")
public class ProductController {
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/v1/{id}")
	public String getProduct(@PathParam("id") String id){
	ProductService prodService = ProductServiceImpl.getInstance();
	String result = prodService.getProduct(id);
	return result;
	}
	
	


}
