package module.product.domain;

public interface Product {
	public String getId();	
	public String getName();
	public String getCurrencyCode();
	public Double getPrice();
	public void setName(String name);
	public void setCurrencyCode(String currencyCode);
	public void setPrice(Double price);
	public void setId(String id);
	public String getError();
	public void setError(String error);
	
	
}
