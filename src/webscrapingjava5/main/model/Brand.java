package webscrapingjava5.main.model;

public class Brand {
	private String name;
	private int id;
	public  Brand() {
		// TODO Auto-generated method stub

	}
	public Brand(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
