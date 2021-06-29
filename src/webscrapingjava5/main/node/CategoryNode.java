package webscrapingjava5.main.node;

import webscrapingjava5.main.model.Category;

public class CategoryNode {
	public static Category getCategory(String name) {
		Category category = new Category();
		category.setName(name);
		return category;
	}
}
