package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ItemCartDao;
import model.User;

/**
 * Servlet implementation class ShowItemList
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddToCart() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemCartDao itemCartDao = new ItemCartDao();
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		
		
		String bloodyId = request.getParameter("addToCart");
		int intId = Integer.parseInt(bloodyId);
		try {
			itemCartDao.asignItemToUser(user.getUserID(), intId );
			request.getRequestDispatcher("main_page.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("UOOEOEOE NIE UDALO SIE USERID TAKI " + user.getUserID() + " INT ID " + intId);
			e.printStackTrace();
		}
	}

}
