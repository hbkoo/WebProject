package beans;

import java.io.Serializable;

public class BookBean implements Serializable {
	private int Bookid = 0;
	private String Name = null;
	private String Author = null;
	private String Publisher = null;
	private String Describe = null;
	private String Time = null;
	private int Total = 0;
	private int Num = 0;
	private String ISBN = null;
	private String Url = null;

	public BookBean(int bookid, String name, String author, String publisher, String describe, String time, int total,
			int num, String isbn, String url) {
		Bookid = bookid;
		Name = name;
		Author = author;
		Publisher = publisher;
		Describe = describe;
		Time = time;
		Total = total;
		Num = num;
		ISBN = isbn;
		Url = url;
	}

	public BookBean() {

	}

	public int getBookid() {
		return Bookid;
	}

	public void setBookid(int bookid) {
		Bookid = bookid;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	public String getDescribe() {
		return Describe;
	}

	public void setDescribe(String describe) {
		Describe = describe;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public int getTotal() {
		return Total;
	}

	public void setTotal(int total) {
		Total = total;
	}

	public int getNum() {
		return Num;
	}

	public void setNum(int num) {
		Num = num;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}
}
