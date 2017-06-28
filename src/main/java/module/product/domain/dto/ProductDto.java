package module.product.domain.dto;

import module.product.domain.Product;

public class ProductDto implements Product{
	
	private String id;
	private String name;
	private String currencyCode;
	private Double price;
	private String error;
	
	public ProductDto(){
		
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public Double getPrice() {
		return price;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String getError() {
		return error;
	}

	@Override
	public void setError(String error) {
		this.error = error;
	}
}
