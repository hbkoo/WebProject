package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BookBean;
import beans.LibraryDAO;

/**
 * according one kind of information to find books
 * such as name,author,publish,class
 * @author 19216
 *
 */
public class SearchBooks extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("\n***********test start SearchBooks servlet*************");
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String keyword = req.getParameter("keyword");
		String condition = req.getParameter("condition");
		
		System.out.println("info:" + keyword);
		System.out.println("condition:"+condition);
		
		LibraryDAO bookDAO = LibraryDAO.getInstance();
		List<BookBean> books = null;
		
		switch (condition.trim()) {
		case "name":
			books = bookDAO.searchBookbyName(keyword);
			break;
		case "author":
			books = bookDAO.searchBookbyAuthor(keyword);
			break;
		case "publisher":
			books = bookDAO.searchBookbyPublisher(keyword);
			break;
		case "isbn":
			books = bookDAO.searchBookbyISBN(keyword);
			break;
		default:
			break;
		}
		System.out.println("size:"+ books.size());
		
		StringBuilder result = new StringBuilder();
		result.append("[");
		for(BookBean book : books) {
			result.append("{\"bookid\":" + book.getBookid());
			result.append(",\"name\":\"" + book.getName() + "\"},");
		}
		if (result.length() != 1) {
			result.deleteCharAt(result.length()-1);
		}
		result.append("]");
		
		PrintWriter out = resp.getWriter();
		out.println(result.toString());
		
		System.out.println(result.toString());
		
		System.out.println("***********test end SearchBooks servlet*************\n");
		
//		req.setAttribute("books", books);
//		req.getRequestDispatcher("/searchResult.jsp").forward(req, resp);
		
		
		
	}
	
}
