package beans;

public class BorrowBean {
	private String userID = null;   // 用户ID
	private int bookID = 0;         //图书ID
	private String bookName = null; //图书名
	private String borrowTime = null;    //借书时间
	private String returnTime = null;    //还书时间
	private int overTime = 0;       //逾期时长
	private float money = 0.0f;     //逾期金额

	public BorrowBean(String userid, int bookid, String bookname, String btime, String rtime, int overtime,
			float money) {
		this.userID = userid;
		this.bookID =bookid;
		this.bookName =bookname;
		this.borrowTime = btime;
		this.returnTime = rtime;
		this.overTime = overtime;
		this.money = money;
		
	}

	public BorrowBean() {

	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userid) {
		userID = userid;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookid) {
		bookID = bookid;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookname) {
		bookName = bookname;
	}

	public String getBorrowTime() {
		return borrowTime;
	}

	public void setBorrowTime(String btime) {
		borrowTime = btime;
	}

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String rtime) {
		returnTime = rtime;
	}

	public int getOverTime() {
		return overTime;
	}

	public void setOverTime(int overtime) {
		overTime = overtime;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}
}
