package beans;

import java.io.Serializable;

public class UserBean implements Serializable {
	private String userID = null;
	private String passWord = null;
	private String name = null;
	private String academy = null;
	private String className = null;
	private int num = 0;
	private float money = 0.0f;
	private String status = null;

	public UserBean(String userid, String password, String name, String academy, String classname, int num,
			float money,String status) {
		this.userID = userid;
		this.passWord = password;
		this.name = name;
		this.academy = academy;
		this.className = classname;
		this.num = num;
		this.money = money;
		this.status = status;
	}
	
	public UserBean() {
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userid) {
		userID = userid;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String password) {
		passWord = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAcademy() {
		return academy;
	}

	public void setAcademy(String academy) {
		this.academy = academy;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String classname) {
		className = classname;
	}
}
