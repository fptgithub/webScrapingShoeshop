package webscrapingjava5.main.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import webscrapingjava5.main.model.Customtype;
import webscrapingjava5.main.utils.AbstractDAO;

public class CustomtypeDAO extends AbstractDAO{
public static List<Customtype> customtype ;
	
	static{
		customtype = new ArrayList<Customtype>();
		try {
			Statement stm = getConnection().createStatement();
			ResultSet rs = stm.executeQuery("select * from customtypes");
			while(rs.next()) {
				Customtype ct = new Customtype(rs.getInt("id"),rs.getString("name"));
				customtype.add(ct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
