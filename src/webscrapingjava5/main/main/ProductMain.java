package webscrapingjava5.main.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import webscrapingjava5.main.dao.ProductDAO;
import webscrapingjava5.main.model.Product;
import webscrapingjava5.main.node.ProductNode;
import webscrapingjava5.main.utils.WebClienUtil;


public class ProductMain {
	//take all image inside list and download
//	public static List<String> images = new ArrayList<String>();
	static int totalProduct=0;
	static ProductDAO dao = new ProductDAO();
	static Set<String[]> productLink = new HashSet<String[]>();
	static List<Product> listProducts = new ArrayList<Product>();
	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF); 
		List<String> list = getAllCategory("https://shoewarehouse.com.au/");
		int idx = 1;
		for(String s:list) {
			insertListProduct(getAllProductByCategory(s));
			System.out.println("conplate "+idx+"/"+list.size());
			productLink.removeAll(productLink);
			listProducts.removeAll(listProducts);
			System.gc();
			idx++;
		}
	}
	
	
	public static List<String> getAllCategory(String url){
		List<String> categorys = new ArrayList<String>(); 
		Document doc = Jsoup.parse(WebClienUtil.getPage(url));
		for(Element e:doc.select("#menu ul li ul li")) {
			if(!e.html().contains("class=")) {
				// select href of a tag (current is li tag not a tag)
				categorys.add(e.selectFirst("a").attr("href"));
			}
		}
		return categorys;
	}
	
	public static List<Product> getAllProductByCategory(String url) {
		System.out.println(url);
		Document doc = Jsoup.parse(WebClienUtil.getPage(url));
		getAllProductByCategoryByPage(productLink,doc);
		int page = 2;
		while(doc.select(".uk-transition-toggle > a")!=null&&doc.select(".uk-transition-toggle > a").size()!=0) {
			doc = Jsoup.parse(WebClienUtil.getPage(url+"?sort=newest&page="+page));
			getAllProductByCategoryByPage(productLink, doc);
			System.out.println("page="+page+";size="+productLink.size());
			page++;
		}
		return getListProducDetail(productLink,url);
	}
	
	public static void getAllProductByCategoryByPage(Set<String[]> productLink,Document doc) {
		for(Element e:doc.select(".uk-transition-toggle > a")) {
			String[] str = {e.attr("href"),e.selectFirst("img").attr("src")};
			productLink.add(str);
		}
	}
	
	public static List<Product> getListProducDetail(Set<String[]> productLink,String categoryUrl) {
		int idx = 1;
		for(String[] s:productLink) {
			try {
				Product p = getProductDetail(s[0],categoryUrl,s[1]);
				listProducts.add(p);
				System.out.println("Product Detail : "+idx+" ==>"+p);
				idx++;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("product:"+idx);
			}
		}
		return listProducts;
	}
	
	public static Product getProductDetail(String url,String categoryUrl,String poster) {
		try {
			Document doc = Jsoup.connect(url).get();
			return ProductNode.getProduct(doc,url,categoryUrl,poster);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void insertListProduct(List<Product> list) {
		int idx = 1;
		for(Product p:list) {
			try {
				dao.insert(p);
				idx++;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("product"+idx);
			}
		}
		totalProduct+=list.size();
		System.out.println(String.format("done : %d product", list.size()));
		System.out.println(String.format("total Product : %d", totalProduct));
	}
	
}
