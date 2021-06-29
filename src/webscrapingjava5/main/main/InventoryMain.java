package webscrapingjava5.main.main;

import java.util.List;

import webscrapingjava5.main.dao.InventoryDAO;
import webscrapingjava5.main.dao.ProductDAO;
import webscrapingjava5.main.dao.ProductSizeDAO;
import webscrapingjava5.main.model.Inventory;

public class InventoryMain {
	public static void main(String[] args) {
		ProductDAO pdao = new ProductDAO();
		ProductSizeDAO sdao = new ProductSizeDAO();
		insert(pdao.selectProductId(), sdao.selectProductId());
	}
	
	public static void insert(List<Integer> productIds,List<Integer> sizeIds) {
		InventoryDAO dao = new InventoryDAO();
		double i = 1;
		for(Integer p:productIds) {
			for(Integer s:sizeIds) {
				if(isInventory()) {
					Inventory inventory = new Inventory(randomInventory(), p, s);
					dao.insert(inventory);
					System.out.println(i);
					i++;
				}
			}
		}
	}
	
	public static boolean isInventory() {
		if(Math.random()>=0.85) {
			return false;
		}
		return true;
	}
	
	public static int randomInventory() {
		return (int)((Math.random()+0.000001) * 33);
	}
}
