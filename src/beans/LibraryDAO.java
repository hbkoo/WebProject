package beans;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LibraryDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rst;
	private boolean connectToDB = false;
	private static LibraryDAO bookdao = null;

	private LibraryDAO() {

	}

	public static LibraryDAO getInstance() {
		if (bookdao == null) {
			bookdao = new LibraryDAO();
		}
		if (!bookdao.connectToDB) {
			bookdao.connecttoDB();
		}
		return bookdao;
	}

	public ArrayList<BookBean> getNewBooks() {
		ArrayList<BookBean> bookList = new ArrayList<>();
		Date time = new Date();
		time.setMonth(time.getMonth() - 1);
		String btime = new SimpleDateFormat("yyyy-MM-dd").format(time);
		try {
			pstmt = conn.prepareStatement("SELECT * FROM dbo.book WHERE BTime>=?");
			pstmt.setString(1, btime);
			rst = pstmt.executeQuery();
			while (rst.next()) {
				BookBean book = new BookBean();
				book.setBookid(rst.getInt("BID"));
				book.setName(rst.getString("BName").trim());
				book.setAuthor(rst.getString("BAuthor").trim());
				book.setPublisher(rst.getString("BPublisher").trim());
				book.setDescribe(rst.getString("BDescribe").trim());
				book.setTime(rst.getString("BTime").trim());
				book.setTotal(rst.getInt("BTotal"));
				book.setNum(rst.getInt("BNum"));
				book.setISBN(rst.getString("BISBN").trim());
				book.setUrl(rst.getString("BUrl").trim());
				bookList.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bookList;
	}

	public boolean changeName(String userID, String userName) {

		try {
			pstmt = conn.prepareStatement("update dbo.userInfo set UName=? WHERE UID=?");
			pstmt.setString(1, userName);
			pstmt.setString(2, userID);
			int result = pstmt.executeUpdate();
			return result != 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<BookBean> searchBookbyName(String BName) {
		ArrayList<BookBean> booklist = new ArrayList<BookBean>();
		try {
			pstmt = conn.prepareStatement("SELECT * FROM dbo.book WHERE BName LIKE ?");
			pstmt.setString(1, "%" + BName + "%");
			rst = pstmt.executeQuery();
			while (rst.next()) {
				BookBean book = new BookBean();
				book.setBookid(rst.getInt("BID"));
				book.setName(rst.getString("BName").trim());
				book.setAuthor(rst.getString("BAuthor").trim());
				book.setPublisher(rst.getString("BPublisher").trim());
				book.setDescribe(rst.getString("BDescribe").trim());
				book.setTime(rst.getString("BTime").trim());
				book.setTotal(rst.getInt("BTotal"));
				book.setNum(rst.getInt("BNum"));
				book.setISBN(rst.getString("BISBN").trim());
				book.setUrl(rst.getString("BUrl").trim());
				booklist.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booklist;
	}

	public ArrayList<BookBean> searchBookbyAuthor(String BAuthor) {
		ArrayList<BookBean> booklist = new ArrayList<BookBean>();
		try {
			pstmt = conn.prepareStatement("SELECT * FROM dbo.book WHERE BAuthor LIKE ?");
			pstmt.setString(1, "%" + BAuthor + "%");
			rst = pstmt.executeQuery();
			while (rst.next()) {
				BookBean book = new BookBean();
				book.setBookid(rst.getInt("BID"));
				book.setName(rst.getString("BName").trim());
				book.setAuthor(rst.getString("BAuthor").trim());
				book.setPublisher(rst.getString("BPublisher").trim());
				book.setDescribe(rst.getString("BDescribe").trim());
				book.setTime(rst.getString("BTime").trim());
				book.setTotal(rst.getInt("BTotal"));
				book.setNum(rst.getInt("BNum"));
				book.setISBN(rst.getString("BISBN").trim());
				book.setUrl(rst.getString("BUrl").trim());
				booklist.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booklist;
	}
	
	public ArrayList<BookBean> searchBookbyID(String BID) {
		ArrayList<BookBean> booklist = new ArrayList<BookBean>();
		try {
			pstmt = conn.prepareStatement("SELECT * FROM dbo.book WHERE BID = ?");
			pstmt.setString(1, BID);
			rst = pstmt.executeQuery();
			while (rst.next()) {
				BookBean book = new BookBean();
				book.setBookid(rst.getInt("BID"));
				book.setName(rst.getString("BName").trim());
				book.setAuthor(rst.getString("BAuthor").trim());
				book.setPublisher(rst.getString("BPublisher").trim());
				book.setDescribe(rst.getString("BDescribe").trim());
				book.setTime(rst.getString("BTime").trim());
				book.setTotal(rst.getInt("BTotal"));
				book.setNum(rst.getInt("BNum"));
				book.setISBN(rst.getString("BISBN").trim());
				book.setUrl(rst.getString("BUrl").trim());
				booklist.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booklist;
	}

	public ArrayList<BookBean> searchBookbyPublisher(String BPublisher) {
		ArrayList<BookBean> booklist = new ArrayList<BookBean>();
		try {
			pstmt = conn.prepareStatement("SELECT * FROM dbo.book WHERE BPublisher LIKE ?");
			pstmt.setString(1, "%" + BPublisher + "%");
			rst = pstmt.executeQuery();
			while (rst.next()) {
				BookBean book = new BookBean();
				book.setBookid(rst.getInt("BID"));
				book.setName(rst.getString("BName").trim());
				book.setAuthor(rst.getString("BAuthor").trim());
				book.setPublisher(rst.getString("BPublisher").trim());
				book.setDescribe(rst.getString("BDescribe").trim());
				book.setTime(rst.getString("BTime").trim());
				book.setTotal(rst.getInt("BTotal"));
				book.setNum(rst.getInt("BNum"));
				book.setISBN(rst.getString("BISBN").trim());
				book.setUrl(rst.getString("BUrl").trim());
				booklist.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booklist;
	}

	public ArrayList<BookBean> searchBookbyISBN(String BISBN) {
		ArrayList<BookBean> booklist = new ArrayList<BookBean>();
		try {
			pstmt = conn.prepareStatement("SELECT * FROM dbo.book WHERE BISBN = ?");
			pstmt.setString(1, BISBN);
			rst = pstmt.executeQuery();
			while (rst.next()) {
				BookBean book = new BookBean();
				book.setBookid(rst.getInt("BID"));
				book.setName(rst.getString("BName").trim());
				book.setAuthor(rst.getString("BAuthor").trim());
				book.setPublisher(rst.getString("BPublisher").trim());
				book.setDescribe(rst.getString("BDescribe").trim());
				book.setTime(rst.getString("BTime").trim());
				book.setTotal(rst.getInt("BTotal"));
				book.setNum(rst.getInt("BNum"));
				book.setISBN(rst.getString("BISBN").trim());
				book.setUrl(rst.getString("BUrl").trim());
				booklist.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booklist;
	}

	public ArrayList<BorrowBean> getBorrowList(String UID) {
		ArrayList<BorrowBean> borrowlist = new ArrayList<BorrowBean>();
		try {
			pstmt = conn.prepareStatement("SELECT * FROM dbo.Borrow WHERE UID = ?");
			pstmt.setString(1, UID);
			rst = pstmt.executeQuery();
			while (rst.next()) {
				BorrowBean borrow = new BorrowBean();
				borrow.setUserID(UID);
				borrow.setBookID(rst.getInt("BID"));
				borrow.setBookName(rst.getString("BName").trim());
				borrow.setBorrowTime(rst.getDate("BTime").toString());
				Date rtime = rst.getDate("RTime");
				borrow.setReturnTime(rtime.toString());
				borrow.setOverTime(judgeOvertime(rtime));
				borrow.setMoney(calOvertime(rtime));
				borrowlist.add(borrow);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return borrowlist;
	}

	private int judgeOvertime(Date time) {
		double days = ((double) new Date().getTime() - (double) time.getTime()) / (24 * 60 * 60 * 1000);
		days = Math.ceil(days); // 对日期向上取整
		if (days <= 0)
			return 0;
		else
			return (int) days;
	}

	private float calOvertime(Date time) {
		// int days = (int) ((new Date().getTime() - time.getTime()) / (1000 * 60 * 60 *
		// 24));
		int days = judgeOvertime(time);
		return new BigDecimal(days * 0.1).floatValue();
	}

	public UserBean searchUser(String uid, String password) {
		UserBean user = new UserBean();
		try {
			pstmt = conn.prepareStatement("SELECT * FROM dbo.userInfo WHERE UID=? AND UPwd=?");
			pstmt.setString(1, uid);
			pstmt.setString(2, password);
			System.out.println("UID:" + uid);
			System.out.println("psw:" + password);
			rst = pstmt.executeQuery();
			if (rst.next()) {
				user.setUserID(rst.getString("UID").trim());
				user.setPassWord(rst.getString("UPwd").trim());
				user.setName(rst.getString("UName").trim());
				user.setAcademy(rst.getString("UAcademy").trim());
				user.setClassName(rst.getString("UClass").trim());
				user.setNum(rst.getInt("UNum"));
				user.setMoney(rst.getFloat("UMoney"));
				user.setStatus(rst.getString("UStatus").trim());
				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public UserBean searchUserInfo(String uid) {
		UserBean user = new UserBean();
		try {
			pstmt = conn.prepareStatement("SELECT * FROM dbo.User WHERE UID=?");
			pstmt.setString(1, uid);
			rst = pstmt.executeQuery();
			if (rst.next()) {
				user.setUserID(rst.getString("UID").trim());
				user.setPassWord(rst.getString("UPwd").trim());
				user.setName(rst.getString("UName").trim());
				user.setAcademy(rst.getString("UAcademy").trim());
				user.setClassName(rst.getString("UClass").trim());
				user.setNum(rst.getInt("UNum"));
				user.setMoney(rst.getFloat("UMoney"));
				user.setStatus(rst.getString("UStatus").trim());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	private void connecttoDB() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String dburl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=library;"; // 100.64.64.162:1433
			conn = DriverManager.getConnection(dburl, "sa", "123456");
			System.out.println("connect in DAO");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connectToDB = true;
	}

	public void disconnecttoDB() {
		if (connectToDB) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connectToDB = false;
		}
	}
	public static void main(String[] args) {
		System.out.println("start connect ...");
		LibraryDAO dao = LibraryDAO.getInstance();
		System.out.println("connect ...");
	}
}
