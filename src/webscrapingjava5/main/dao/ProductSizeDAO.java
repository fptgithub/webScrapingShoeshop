package webscrapingjava5.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import webscrapingjava5.main.utils.AbstractDAO;

public class ProductSizeDAO extends AbstractDAO{
	
	String insert = "INSERT INTO productsizes( size) VALUES (?)";
	
	public void insert(double size) {
		Connection con = getConnection();
		if(con!=null) {
			try {
			PreparedStatement stm = con.prepareStatement(insert);
			setStatement(stm, size);
			stm.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	String select = "select * from productsizes";
	
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
