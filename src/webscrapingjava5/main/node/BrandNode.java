package webscrapingjava5.main.node;

import org.jsoup.nodes.Element;

import webscrapingjava5.main.model.Brand;

public class BrandNode {
	
	static String name = "a";
	
	public static String getName(Element e) {
		return e.text();
	}
	
	public static Brand getBrand(Element e) {
		Brand brand = new Brand();
		brand.setName(getName(e));
		return brand;
	}
}
