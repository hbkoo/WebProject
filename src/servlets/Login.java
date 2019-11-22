package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LibraryDAO;
import beans.UserBean;
/**
 * the process of user login 
 * @author 19216
 *
 */
public class Login extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");
		String psw = request.getParameter("password");
	
		System.out.println("\n**********test start login servlet***********");
		System.out.println("input username:" + username);
		
		LibraryDAO dao = LibraryDAO.getInstance();
		UserBean user = dao.searchUser(username, psw);
				
		if (user != null) {
			System.out.println("username:" + user.getName());
			System.out.println("user login success");
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			//session.
			//response.sendRedirect("/WEB-INF/html/center.html");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/html/main.html");
			dispatcher.forward(request, response);
		} else {
//			request.getRequestDispatcher("/login.html").forward(request, response);
			System.out.println("user login fail");
			response.sendRedirect(request.getContextPath() + "/login.html");
		}
		
		System.out.println("***********test end login servlet*************\n");
	}
	
}
