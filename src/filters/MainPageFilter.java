package filters;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet Filter implementation class SessionRepair
 */
@WebFilter("/SessionRepair")
public class MainPageFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MainPageFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		User user = new User();
		UserDao userDao = new UserDao();
		HttpServletRequest httpReq = (HttpServletRequest) request;
		
		if(httpReq.getUserPrincipal() != null) {
		String username = httpReq.getUserPrincipal().getName();
		HttpSession session = httpReq.getSession(false);
		
		try {
			user = userDao.returnFullUser(username);
			session.setAttribute("user", user);
			System.out.println("user: " + user.getUserName() + " user Id :" + user.getUserID());
			chain.doFilter(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
