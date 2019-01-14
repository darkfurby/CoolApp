package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import databaseConnection.ConnectionProvider;
import model.EmailConfirm;
import model.User;

public class EmailDao {

	 private final static String CREATE = "insert into user_email_confirm (user_id, confirm_code) values (?,?);";
	 private final static String READ = "select * from user_email_confirm where user_id = ?;";
	 //tworzy kod weryfikujacy dla uzytkownika
	 public void createCodeForUser(User user, int generatedCode) throws SQLException {
		 try (Connection conn = ConnectionProvider.getConnection();
				 PreparedStatement prepStmt = conn.prepareStatement(CREATE)){
			 	prepStmt.setInt(1, user.getUserID());
			 	prepStmt.setInt(2, generatedCode);
			 	prepStmt.executeUpdate();
			 	
		 }
	}
	 //zwraca kod uzytkownika do ktorego zostal przypisany, do pozniejszego sprawdzenia czy sie kod zgadza, na podstawie uzytkownika
	 public int checkCodeForUser(User user) throws SQLException {
		 	int code = 0;
		 try (Connection conn = ConnectionProvider.getConnection();
				 PreparedStatement prepStmt = conn.prepareStatement(READ)){
			 	prepStmt.setInt(1, user.getUserID());
			 	ResultSet resultSet = prepStmt.executeQuery();
			 	
			 	if(resultSet.next() ) {
			 		code = resultSet.getInt("confirm_code");
			 	} 
			 	
			 	return code;
		 }
	}
	 
}
