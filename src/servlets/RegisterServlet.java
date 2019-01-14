package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmailDao;
import dao.UserDao;
import model.User;
import services.ReqisterMethods;
import services.SendAuthMail;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userDao = new UserDao();
		ReqisterMethods registerMethods = new ReqisterMethods();
		String username = request.getParameter("user_name");
		String email = request.getParameter("user_email");
		String password = request.getParameter("user_password");
		String chooseUserType = request.getParameter("chooseUserType");
		int userType = registerMethods.returnIdRole(chooseUserType);
		
		User user = new User(username,email,password,userType);
		
		try {
			if( !userDao.checkIfUserExist(user) ) {
				SendAuthMail sendMail = new SendAuthMail();
				userDao.createUser(user);
				try {
					user.setUserID( userDao.returnUserId(user.getUserName() ) );
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				System.out.println(user.getUserID());
					int emailCode = sendMail.sendAuthenticatorMail(user);
					EmailDao emailDao = new EmailDao();
					emailDao.createCodeForUser(user, emailCode);
				 request.getRequestDispatcher("confirm_user_page.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("error_page.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			
			System.out.println("ladnie sie zjebalo");
			e.printStackTrace();
			
		}
	}

}
