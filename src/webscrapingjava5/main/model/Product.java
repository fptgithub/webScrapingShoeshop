package webscrapingjava5.main.model;

import java.time.LocalDate;
import java.util.List;

public class Product {
	private int category;
	private int brand;
	private int customType;
	private int id;
	private String name;
	private String description;
	private List<String> images;
	private double price;
	private double salePrice;
	private String color;
	private String createBy = "admin";
	private LocalDate createDate = LocalDate.now();
	private boolean active = true;
	private String slug;
	private String poster;
	
	
	public Product(int category, int brand, int customType, int id, String name, String description,
			List<String> images, double price, double salePrice, String color, String createBy, LocalDate createDate,
			boolean active, String slug, String poster) {
		super();
		this.category = category;
		this.brand = brand;
		this.customType = customType;
		this.id = id;
		this.name = name;
		this.description = description;
		this.images = images;
		this.price = price;
		this.salePrice = salePrice;
		this.color = color;
		this.createBy = createBy;
		this.createDate = createDate;
		this.active = active;
		this.slug = slug;
		this.poster = poster;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String imagesToString() {
		String imagesStr = "";
		for(String image:getImages()) {
			imagesStr+=image+";";
		}
		return imagesStr;
	}
	
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getBrand() {
		return brand;
	}
	public void setBrand(int brand) {
		this.brand = brand;
	}
	public int getCustomType() {
		return customType;
	}
	public void setCustomType(int customType) {
		this.customType = customType;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Product(int category, int brand, int customType, int id, String name, String description,
			List<String> images, double price, double salePrice, String color, String createBy, LocalDate createDate,
			boolean active,String slug) {
		super();
		this.category = category;
		this.brand = brand;
		this.customType = customType;
		this.id = id;
		this.name = name;
		this.description = description;
		this.images = images;
		this.price = price;
		this.salePrice = salePrice;
		this.color = color;
		this.createBy = createBy;
		this.createDate = createDate;
		this.active = active;
		this.slug = slug;
	}
	public Product() {
		super();
	}
	
	@Override
	public String toString() {
		return String.format("[category=%d,brand=%d,customtype=%d,name=%s,description=%s,price=%f,sale=%f,color=%s,slug=%s,images=%s,poster=%s",
				getCategory(),getBrand(),getCustomType(),getName(),getDescription(),getPrice(),getSalePrice(),getColor(),getSlug(),imagesToString(),getPoster()
				);
	}
	
	
}
