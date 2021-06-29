package webscrapingjava5.main.model;

import java.time.LocalDate;

public class Category {
	private int id;
	private String name;
	private String createBy = "admin";
	private LocalDate createDate = LocalDate.now();
	private boolean active = true;
	private String slug;
	
	public Category(int id, String name, String createBy, LocalDate createDate, boolean active, String slug) {
		super();
		this.id = id;
		this.name = name;
		this.createBy = createBy;
		this.createDate = createDate;
		this.active = active;
		this.slug = slug;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public Category() {
		// TODO Auto-generated constructor stub
	}
	public Category(int id, String name, String createBy, LocalDate createDate, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.createBy = createBy;
		this.createDate = createDate;
		this.active = active;
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
	
	
}
