package webscrapingjava5.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import webscrapingjava5.main.model.Inventory;
import webscrapingjava5.main.utils.AbstractDAO;

public class InventoryDAO extends AbstractDAO{
	String insert = "INSERT INTO productinventorys(inventory,product_id,productsize_id) VALUES (?,?,?)";
	
	public void insert(Inventory inventory) {
		Connection con = getConnection();
		if(con!=null) {
			try {
				PreparedStatement stm = con.prepareStatement(insert);
				setStatement(stm, inventory.getInventory(),inventory.getProductid(),inventory.getSizeid());
				stm.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}
}
