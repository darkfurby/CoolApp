package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import databaseConnection.ConnectionProvider;
import model.User;

public class ApplicationAccessDao {

	private final static String CREATE = "insert into application_access (user_name, role_id, email_confirmed) values (?,?,?)";
	//robi wpis na bazie w tabeli application_access i to jednoczesnie daje dostep do aplikacji uzytkownikowi
	 public void giveUserAccess(User user, int generatedCode) throws SQLException {
		 try (Connection conn = ConnectionProvider.getConnection();
				 PreparedStatement prepStmt = conn.prepareStatement(CREATE)){
			 	prepStmt.setString(1, user.getUserName());
			 	prepStmt.setInt(2, user.getUserRole());
			 	prepStmt.setInt(3, generatedCode);
			 	prepStmt.executeUpdate();
			 	
		 }
	}
}
