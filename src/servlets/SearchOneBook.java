package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BookBean;
import beans.LibraryDAO;

/**
 * to find the detail information of one book
 * 
 * @author 19216
 *
 */
public class SearchOneBook extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("\n***********test start SearchOneBook servlet*************");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String bookID = req.getParameter("bookid");
		PrintWriter out = resp.getWriter();
		StringBuilder result = new StringBuilder();
		
		ArrayList<BookBean> book = LibraryDAO.getInstance().searchBookbyID(bookID);

		result.append("[");
		if(!book.isEmpty()) {
			BookBean bean = book.get(0);
			result.append("{\"bookid\":"+bean.getBookid()+",");
			result.append("\"name\":\""+bean.getName()+"\",");
			result.append("\"author\":\""+bean.getAuthor()+"\",");
			result.append("\"publisher\":\""+bean.getPublisher()+"\",");
			result.append("\"describe\":\""+bean.getDescribe()+"\",");
			result.append("\"isbn\":\""+bean.getISBN()+"\",");
			result.append("\"url\":\""+bean.getUrl()+"\"}");
		}
		result.append("]");
		out.println(result.toString());
		System.out.println(result.toString());
		
		System.out.println("***********test end SearchOneBook servlet*************\n");
		
//		req.setAttribute("book", book.get(0));
//		req.getRequestDispatcher("/oneBook.jsp").forward(req, resp);

	}

}
