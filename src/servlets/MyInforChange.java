package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.LibraryDAO;
import beans.UserBean;

public class MyInforChange extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("\n*******test start myinfo change servlet********");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String userID = req.getParameter("userID");
		String name = req.getParameter("name");
		PrintWriter writer = resp.getWriter();
		
		boolean result = LibraryDAO.getInstance().changeName(userID, name);
		
		System.out.println("userID:" + userID);
		System.out.println("username:" + name);
		System.out.println("result:" + result);
		if (result) {
			writer.println(1);
			UserBean bean = (UserBean)req.getSession().getAttribute("user");
			bean.setName(name);
			req.setAttribute("user", bean);
		} else {
			writer.println(0);
		}
		
		
		System.out.println("*******test end myinfo change servlet********\n");
	}
	
}
