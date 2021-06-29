package webscrapingjava5.main.main;

import webscrapingjava5.main.dao.ProductSizeDAO;

public class SizeMain {
	public static void main(String[] args) {
		ProductSizeDAO dao = new ProductSizeDAO();
		for(double i=34.5;i<=48;i+=0.5) {
			dao.insert(i);
		}
	}
}
