package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import databaseConnection.ConnectionProvider;
import model.Item;

public class ItemDao {

	private final static String READ = "select * from item_list where item_id = ?;";
	private final static String READALL = "select * from item_list;";
	private final static String READITEMNAME = "select item_name from item_list where item_id = ?;";
	
	public Item readItem(String itemId) throws SQLException {
		Item item = null;
		 try (Connection conn = ConnectionProvider.getConnection();
				 PreparedStatement prepStmt = conn.prepareStatement(READ)){
			 prepStmt.setString(1,itemId);
			 ResultSet resultSet = prepStmt.executeQuery();
			 
			 if( resultSet.next() ) {
				 item = new Item();
				 item.setItemId(resultSet.getInt("item_id"));
				 item.setItemName(resultSet.getString("item_name"));
				 item.setItemPrice(resultSet.getInt("item_price"));
				 item.setItemType(resultSet.getInt("item_type"));
			 }
		 }
		return item;
	}
	
	
	public List<Item> ReadAll() throws SQLException {
		List<Item> itemList = new ArrayList<Item>();
		 try (Connection conn = ConnectionProvider.getConnection();
				 PreparedStatement prepStmt = conn.prepareStatement(READALL)){
			 ResultSet resultSet = prepStmt.executeQuery();
			 while( resultSet.next() ) {
				 Item item = new Item();
				 item.setItemId(resultSet.getInt("item_id"));
				 item.setItemName(resultSet.getString("item_name"));
				 item.setItemPrice(resultSet.getInt("item_price"));
				 item.setItemType(resultSet.getInt("item_type"));
				 
				 itemList.add(item);
				 
			 }
		 }
		
		return itemList;
		
	}
	
	public String itemName (int itemId) {
		
		
		return null;
	}
}
