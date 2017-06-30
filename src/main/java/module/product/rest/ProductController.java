package module.product.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.sun.jersey.multipart.FormDataParam;

import module.common.CacheInit;
import module.product.domain.Product;
import module.product.domain.dto.ProductDto;
import module.product.services.ProductService;
import module.product.services.impl.ProductServiceImpl;


@Path("/products")
public class ProductController {
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/v1/{id}")
	public Response getProduct(@PathParam("id") String id){
		ProductService prodService = ProductServiceImpl.getInstance();
		String result = prodService.getProduct(id);
		ResponseBuilder builder = Response.ok(result);
		builder.cacheControl(CacheInit.cacheInit());
		return builder.build();
	}

	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/v1/{id}")
	public Response updateProduct(@PathParam("id") String id, @FormParam("price") Double price){
		ProductService prodService = ProductServiceImpl.getInstance();
		Product prod = new ProductDto();
		String result = prodService.updateProduct(prod);
		ResponseBuilder builder = Response.ok(result);
		builder.cacheControl(CacheInit.cacheInit());
		return builder.build();
	}
}
