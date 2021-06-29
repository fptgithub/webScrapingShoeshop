package webscrapingjava5.main.main;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import webscrapingjava5.main.dao.BrandDAO;
import webscrapingjava5.main.model.Brand;
import webscrapingjava5.main.node.BrandNode;
import webscrapingjava5.main.utils.WebClienUtil;

public class BrandMain {
	
	static String query = ".uk-container.BC-container > div > ul > li";
	
	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF); 
		Document doc = Jsoup.parse(WebClienUtil.getPage("https://shoewarehouse.com.au/our-brands/"));
		List<Brand> list = new ArrayList<Brand>();
		loadListBrand(list, doc.select(query));
		insertListBrand(list);
	}
	
	public static void loadListBrand(List<Brand> list,Elements elms) {
		for(Element e:elms) {
			list.add(BrandNode.getBrand(e));
		}
	}
	
	public static void insertListBrand(List<Brand> list) {
		BrandDAO bdao = new BrandDAO();
		for(Brand brand:list) {
			bdao.insert(brand);
		}
	}
}
