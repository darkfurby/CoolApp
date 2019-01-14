package services;
import java.sql.SQLException;

import dao.EmailDao;
import model.User;
public class CheckCodeEmail {

	//metoda ktora potwierdza czy kod jest prawidlowy
	public boolean checkIfCodeIsCorrect( User user, int code ) throws SQLException {
		EmailDao emailDao = new EmailDao();
		
		int codeFromDatabase = emailDao.checkCodeForUser(user);
		
		if(codeFromDatabase == code) {
			return true;
		}
		
		return false;
	}
}
