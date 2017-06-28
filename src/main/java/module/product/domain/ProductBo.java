package module.product.domain;

public class ProductBo {
	
	private String id;
	private String name;
	private String currencyCode;
	private Double price;
	
	public ProductBo(String id, String name,String currencyCode,Double price){
		this.id = id;
		this.name = name;
		this.currencyCode = currencyCode;
		this.price = price;
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
}
