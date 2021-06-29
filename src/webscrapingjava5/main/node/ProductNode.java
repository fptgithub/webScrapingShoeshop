package webscrapingjava5.main.node;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import webscrapingjava5.main.dao.BrandDAO;
import webscrapingjava5.main.dao.CategoryDAO;
import webscrapingjava5.main.dao.CustomtypeDAO;
import webscrapingjava5.main.main.ProductMain;
import webscrapingjava5.main.model.Brand;
import webscrapingjava5.main.model.Category;
import webscrapingjava5.main.model.Customtype;
import webscrapingjava5.main.model.Product;

public class ProductNode {
	
	public static Integer getCustomtype(String url) {
		for(Customtype c:CustomtypeDAO.customtype) {
			if(url.contains(c.getName().toLowerCase())) return c.getId();
		}
		return 1;
	}
	
	public static Integer getCategory(String url) {
		for(Category c:CategoryDAO.category) {
			if(url.replaceAll("-", " ").contains(c.getName().toLowerCase())) return c.getId();
		}
		return 2;
	}
	
	public static Integer getBrand(Document doc) {
		String brand = doc.selectFirst("h3[itemprop=name]").text().trim();
		for(Brand b:BrandDAO.brand) {
			if(brand.contains(b.getName())||brand.equalsIgnoreCase(b.getName().trim())) return b.getId();
		}
		return 2;
	}
	
	public static List<String> getImage(Document doc) {
		List<String> images = new ArrayList<String>();
		for(Element e:doc.select(".bc-product-zoom > img")) {
			String src = e.attr("src");
//			ProductMain.images.add(src);
//			images.add(src.substring(src.lastIndexOf("/")+1,src.lastIndexOf(".")+4));
			images.add(src);
		}
		return images;
	}
	
	public static String getColor(Document doc) {
		try {
			String text = doc.selectFirst(".swatches-color").text();
			return text.substring(text.lastIndexOf(":")+1);
		} catch (Exception e) {
			return "";
		}
	}
	
	public static String getSlug(String url) {
		return url.split("/")[url.split("/").length-1];
	}
	
	public static String getName(Document doc) {
		return doc.selectFirst("h1[itemprop=name]").text();
	}
		
	public static double getPrice(Document doc) {
		return Double.parseDouble(doc.selectFirst("span[itemprop=price]").text().substring(1));
	}
	
	public static double getSalePrice(Document doc) {
		return Double.parseDouble(doc.selectFirst(".price--rrp.price.strike-through").text().substring(1));
	}
	
	public static String getDescription(Document doc) {
		return doc.getElementById("bc-description").text();
	}
	public static Product getProduct(Document doc,String url,String categoryUrl,String poster) {
		Product p = new Product();
		p.setBrand(getBrand(doc));
		p.setCustomType(getCustomtype(url));
		p.setCategory(getCategory(categoryUrl));
		p.setDescription(getDescription(doc));
		p.setPrice(getPrice(doc));
		p.setSalePrice(getSalePrice(doc));
		p.setName(getName(doc));
		p.setImages(getImage(doc));
		p.setSlug(getSlug(url));
		p.setColor(getColor(doc));
		p.setPoster(poster);
		return p;
	}
}
