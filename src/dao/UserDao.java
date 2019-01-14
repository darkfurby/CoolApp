package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import databaseConnection.ConnectionProvider;
import model.User;

public class UserDao {

	 private final static String CREATE = "insert into user_definition (user_name,user_email, user_password,user_role_id) values (?,?,?,?);";
	 private final static String UPDATESTATUS = "UPDATE `foodtruck_finder`.`user_definition` SET `user_is_available` = '1' WHERE (`user_name` = ?)";
	 private final static String READ = "select * from user_definition where user_name = ? and user_email = ? ";
	 private final static String READALL = "select * from user_definition where user_name = ?; ";
	 private final static String READUSER = "select user_name, user_password from foodtruck_finder.user_definition where user_name = ? ";
	 //Utworzenie uzytkownika
	 public void createUser(User user) throws SQLException {
		 try (Connection conn = ConnectionProvider.getConnection();
				 PreparedStatement prepStmt = conn.prepareStatement(CREATE)){
			 		prepStmt.setString(1,user.getUserName());
			 		prepStmt.setString(2,user.getUserEmail());
			 		prepStmt.setString(3,user.getUserPassword());
			 		prepStmt.setInt(4,user.getUserRole());
			 		prepStmt.executeUpdate();
		 }
	 }
	 //aktualizowanie statusu usera
	 public void updateStatus(User user) throws SQLException{
		 try (Connection conn = ConnectionProvider.getConnection();
				 PreparedStatement prepStmt = conn.prepareStatement(UPDATESTATUS)){
			 		prepStmt.setString(1, user.getUserName());
			 		prepStmt.executeUpdate();
		 }
	 }
	 //sprawdzenie czy uzytkownik istnieje
	 public boolean checkIfUserExist (User user) throws SQLException {
		 try (Connection conn = ConnectionProvider.getConnection();
				 PreparedStatement prepStmt = conn.prepareStatement(READ)){
			 		prepStmt.setString(1, user.getUserName());
			 		prepStmt.setString(2, user.getUserEmail());
			 		ResultSet resultSet = prepStmt.executeQuery();
			 		
			 		if(resultSet.next() ) {
			 			
			 			if(resultSet.getString("user_name").equals(user.getUserName() )
			 				&& resultSet.getString("user_email").equals( user.getUserEmail()) )  {
			 					return true;
			 			}
			 		}
		 }
		 
		 
		 return false;
	 }
	 //zwrocenie user_name i password usera na podstawie username'a
	 public User returnUser(String username) throws SQLException {
		 User user = null;
		 try (Connection conn = ConnectionProvider.getConnection();
				 PreparedStatement prepStmt = conn.prepareStatement(READUSER)){
			 prepStmt.setString(1, username);
			 ResultSet resultSet = prepStmt.executeQuery();
			 
			 if(resultSet.next()) {
				 user = new User();
				 user.setUserName(resultSet.getString("user_name"));
				 user.setUserPassword(resultSet.getString("user_password"));
			 }
			 
		 }
		 
		 return user;
	 }
	 //zwrocenie wszystkich informacji usera na podstawie jego username
	 public User returnFullUser(String username) throws SQLException {
		 User user = null;
		 try (Connection conn = ConnectionProvider.getConnection();
				 PreparedStatement prepStmt = conn.prepareStatement(READALL)){
			 prepStmt.setString(1, username);
			 ResultSet resultSet = prepStmt.executeQuery();
			 
			 if(resultSet.next()) {
				 user = new User();
				 user.setUserName(resultSet.getString("user_name"));
				 user.setUserPassword(resultSet.getString("user_password"));
				 user.setUserEmail(resultSet.getString("user_email"));
				 user.setUserRole(resultSet.getInt("user_role_id"));
				 user.setUserStatus(resultSet.getInt("user_is_available"));
				 user.setUserID(resultSet.getInt("user_id"));
			 }
			 
		 }
		 
		 return user;
	 }
	 //zwrocenie id usera na podstawie username
	 public int returnUserId(String userName) throws SQLException {
		 try (Connection conn = ConnectionProvider.getConnection();
				 PreparedStatement prepStmt = conn.prepareStatement(READALL)){
			 int userId = 0;
			 prepStmt.setString(1, userName);
			 ResultSet resultSet = prepStmt.executeQuery();
			 
			 if(resultSet.next()) {
				 userId = resultSet.getInt("user_id");
			 }
			 return userId;
		 }
	 }
}
