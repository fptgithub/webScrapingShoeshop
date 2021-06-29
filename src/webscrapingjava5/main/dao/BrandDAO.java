package webscrapingjava5.main.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import webscrapingjava5.main.model.Brand;
import webscrapingjava5.main.utils.AbstractDAO;

public class BrandDAO extends AbstractDAO{

	public static List<Brand> brand ;
	
	static{
		brand = new ArrayList<Brand>();
		try {
			Statement stm = getConnection().createStatement();
			ResultSet rs = stm.executeQuery("select * from brands");
			while(rs.next()) {
				Brand br = new Brand(rs.getString("name"),rs.getInt("id"));
				brand.add(br);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		for(Brand br:brand) {
//			System.out.println(br.getName());
//		}
//	}
	String sql = "INSERT INTO brands(name) VALUES (?)";
	
	public void insert(Brand brand) {
		Connection con = null;
		con = getConnection();
		try {
			if(con!=null) {
				PreparedStatement stm = con.prepareStatement(sql);
				setStatement(stm, brand.getName());
				stm.executeUpdate();
				System.out.println("done");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
