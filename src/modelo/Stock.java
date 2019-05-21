package modelo;

public class Stock {
	private final Integer id;
	private String name;
	private Integer quantity;
	private float price;
	
	
	
	public Stock() {
		this.id=null;
		this.name=null;		
		this.quantity=null;
		this.price=(Float) null;
	}
	
	
	public Stock(Integer id, String name, int quantity, float price) {
		this.id = id;
		this.name = name;
		
		this.quantity = quantity;
		this.price = price;
	}
	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	

	

	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public Integer getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Stock [id=" + id + ", name=" + name + ", description="  + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
	
	
	

}
