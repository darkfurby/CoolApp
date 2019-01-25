package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import databaseConnection.ConnectionProvider;
import model.ItemCart;

public class ItemCartDao {

	private final static String CREATE = "insert into item_cart (user_id, item_id) values (?,?);";
	private final static String READ = "select * from item_cart where user_id = ?;";

	
	public void asignItemToUser(int userId, int itemId) throws SQLException {
		 try (Connection conn = ConnectionProvider.getConnection();
				 PreparedStatement prepStmt = conn.prepareStatement(CREATE)){
			 prepStmt.setInt(1, userId);
			 prepStmt.setInt(2, itemId);
			 prepStmt.executeUpdate();
		 }
	}
	
	public List<ItemCart> showItemsOfUser(int userId) throws SQLException {
		ItemCart itemCart = null;
		List<ItemCart> list = new ArrayList<ItemCart>();
		 try (Connection conn = ConnectionProvider.getConnection();
				 PreparedStatement prepStmt = conn.prepareStatement(READ)){
			 prepStmt.setInt(1, userId);
			 ResultSet resultSet = prepStmt.executeQuery();
			 
			 while( resultSet.next() ) {
				 
				 itemCart = new ItemCart();
				 itemCart.setUserId(resultSet.getInt("user_id"));
				 itemCart.setItemId( resultSet.getInt("item_id") );
				 itemCart.setTranId( resultSet.getInt("tran_id"));
				 
				 list.add(itemCart);
			 }
			 
		 }
		return list;
	}
	
}
