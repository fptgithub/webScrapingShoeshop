package webscrapingjava5.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import webscrapingjava5.main.model.Product;
import webscrapingjava5.main.utils.AbstractDAO;

public class ProductDAO extends AbstractDAO{

	String insert = "INSERT INTO products(active, color, create_date, description, images, name, price, sale_price, brand_id, category_id, customtype_id, create_by, slug, poster) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public void insert(Product p) {
		Connection con = getConnection();
		if(con!=null) {
			try {
				PreparedStatement stm = con.prepareStatement(insert);
				setStatement(stm, p.isActive(),
						p.getColor(),
						p.getCreateDate(),
						p.getDescription(),
						p.imagesToString(),
						p.getName(),
						p.getPrice(),
						p.getSalePrice(),
						p.getBrand(),
						p.getCategory(),
						p.getCustomType(),
						p.getCreateBy(),
						p.getSlug(),
						p.getPoster());
				stm.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	String select = "select * from products";
	
	public List<Integer> selectProductId(){
		List<Integer> list = new ArrayList<Integer>();
		Connection con = getConnection();
		if(con!=null) {
			try {
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(select);
				getListIdProduct(list, rs);
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	
	public void getListIdProduct(List<Integer> list,ResultSet rs) throws SQLException{
		while(rs.next()) {
			list.add(rs.getInt("id"));
		}
	}
}
