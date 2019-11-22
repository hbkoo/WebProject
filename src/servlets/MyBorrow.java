package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BookBean;
import beans.LibraryDAO;
import beans.BorrowBean;
import beans.UserBean;

public class MyBorrow extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("\n**********test start myborrrow servlet***********");
		
		resp.setCharacterEncoding("UTF-8");
		UserBean userBean = (UserBean) req.getSession().getAttribute("user");
		//.getParameter("userID"
		PrintWriter out = resp.getWriter();
		LibraryDAO bookDAO = LibraryDAO.getInstance();
		System.out.println("userID:" + userBean.getUserID());
		List<BorrowBean>borrowBeans = bookDAO.getBorrowList(userBean.getUserID());
		
		System.out.println("My borrow books:" + borrowBeans.size());
		
		HttpSession session = req.getSession();
		session.setAttribute("borrowList", borrowBeans);
		req.getRequestDispatcher("/WEB-INF/jsp/myBorrow.jsp").forward(req, resp);
//		
	
//		StringBuilder result = new StringBuilder();
//		result.append("[");
//		for(BorrowBean bean : borrowBeans) {
//			result.append("{\"bookid\":" + bean.getBookID());
//			result.append(",\"bookname\":\"" + bean.getBookName());
//			result.append(",\"btime\":\"" + bean.getBorrowTime());
//			result.append(",\"rtime\":\"" + bean.getReturnTime());
//			result.append(",\"overtime\":\"" + bean.getOverTime());
//			result.append(",\"money\":\"" + bean.getMoney() + "\"},");
//		}
//		if (result.length() != 1) {
//			result.deleteCharAt(result.length()-1);
//		}
//		result.append("]");
//		System.out.println(result.toString());
		
//		out.println(result.toString());
		
		System.out.println("\n**********test end myborrow servlet***********");
		
	}
}
