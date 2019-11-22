package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BookBean;
import beans.LibraryDAO;

public class NewBooks extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("\n***********test start NewBooks servlet*************");
		resp.setCharacterEncoding("UTF-8");
		LibraryDAO dao = LibraryDAO.getInstance();
		ArrayList<BookBean> books = dao.getNewBooks();
		req.getServletContext().setAttribute("bookList", books);
		System.out.println("test");
		req.getRequestDispatcher("/WEB-INF/jsp/right.jsp").forward(req, resp);
		
		System.out.println("***********test end NewBooks servlet*************\n");
//		PrintWriter out = resp.getWriter();
//		StringBuilder builder = new StringBuilder();
//		builder.append("[");
//		for (BookBean bean : books) {
//			builder.append("{\"name\":\""+bean.getName()+"\",");
//			builder.append("\"url\":\""+bean.getUrl()+"\"},");
//		}
//		if (builder.length() != 1) {
//			builder.deleteCharAt(builder.length()-1);
//		}
//		builder.append("]");
//		out.println(builder.toString());
		
	}
	
}
