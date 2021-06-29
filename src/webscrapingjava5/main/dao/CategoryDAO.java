package webscrapingjava5.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import webscrapingjava5.main.model.Category;
import webscrapingjava5.main.utils.AbstractDAO;

public class CategoryDAO extends AbstractDAO{
	
	public static List<Category> category;
	
	static{
		category = new ArrayList<Category>();
		try {
			Statement stm = getConnection().createStatement();
			ResultSet rs = stm.executeQuery("select * from categorys");
			while(rs.next()) {
				Category c = new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				category.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(category.size());
	}
	
	String insert = "INSERT INTO categorys(active, create_date, name, create_by) VALUES (?,?,?,?)";
	
	public void insert(Category category) {
		Connection con = null;
		con = getConnection();
		try {
			if(con!=null) {
				PreparedStatement stm = con.prepareStatement(insert);
				setStatement(stm, category.isActive(),category.getCreateDate(),category.getName(),category.getCreateBy());
				stm.executeUpdate();
				System.out.println("done");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String update = "update categorys set slug=? where id = ?";
	
	public void updateSlug(Category cate) {
		Connection con = null;
		con = getConnection();
		try {
			if(con!=null) {
				PreparedStatement stm = con.prepareStatement(update);
				setStatement(stm, cate.getSlug(),cate.getId());
				stm.executeUpdate();
				System.out.println("done");
			}
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
