package webscrapingjava5.main.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import webscrapingjava5.main.dao.CategoryDAO;
import webscrapingjava5.main.model.Brand;
import webscrapingjava5.main.model.Category;
import webscrapingjava5.main.node.CategoryNode;
import webscrapingjava5.main.utils.WebClienUtil;

public class CategoryMain {
	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF); 
		Document doc = Jsoup.parse(WebClienUtil.getPage("https://shoewarehouse.com.au/"));
		Set<String> category = new HashSet<String>();
		for(Element e:doc.select("#menu ul li ul li")) {
			if(!e.html().contains("class=")) {
				category.add(e.text());
				System.out.println(e.text());
			}
		}
		insertListCategory(createListCategory(category));
	}
	
	public static List<Category> createListCategory(Set<String> set){
		List<Category> list = new ArrayList<Category>();
		for(String s:set) {
			list.add(CategoryNode.getCategory(s));
		}
		return list;
	}
	
	public static void insertListCategory(List<Category> list) {
		CategoryDAO dao = new CategoryDAO();
		for(Category c:list) {
			dao.insert(c);
		}
	}
}
