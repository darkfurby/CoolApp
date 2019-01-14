package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ApplicationAccessDao;
import dao.UserDao;
import model.User;
import services.CheckCodeEmail;

@WebServlet("/ConfirmUserServlet")
public class ConfirmUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ConfirmUserServlet() {
        super();
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userDao = new UserDao();
		ApplicationAccessDao applicationAccessDao = new ApplicationAccessDao();
		CheckCodeEmail checkCodeEmail = new CheckCodeEmail();
		String userName = request.getParameter("user");
		String codeToInt = request.getParameter("code");
		int code = Integer.parseInt(codeToInt);
		try {
			User user = userDao.returnFullUser(userName);
				if(checkCodeEmail.checkIfCodeIsCorrect( user, code) ) {
					applicationAccessDao.giveUserAccess(user, code);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	

}
