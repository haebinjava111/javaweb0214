package domain;

public class Item {
	private int num;
	private String name;
	private int price;
	private String description;
	private String manufacture;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(int num, String name, int price, String description, String manufacture) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.description = description;
		this.manufacture = manufacture;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	@Override
	public String toString() {
		return "Item [num=" + num + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", manufacture=" + manufacture + "]";
	}
	
	
}
