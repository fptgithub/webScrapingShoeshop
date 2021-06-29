package webscrapingjava5.main.model;

public class Inventory {
	private int inventory;
	private int productid;
	private int sizeid;
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getSizeid() {
		return sizeid;
	}
	public void setSizeid(int sizeid) {
		this.sizeid = sizeid;
	}
	public Inventory(int inventory, int productid, int sizeid) {
		super();
		this.inventory = inventory;
		this.productid = productid;
		this.sizeid = sizeid;
	}
	public Inventory() {
		super();
	}
	
}
