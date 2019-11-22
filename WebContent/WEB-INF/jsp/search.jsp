<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta name="referrer" content="no-referrer"> -->
<script type="text/javascript" src="js/ajax.js"></script>
<title>主界面</title>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<link href="${path}/css/centerstyle.css" rel="stylesheet" type="text/css"/>
</head>
<script type="text/javascript">
	function onItemClick(item) {//点击查询结果
	//	alert("3-book-information");
		var bookid=item.getAttribute("id");
		getBookInformation(bookid);
	}	
</script>
<script type="text/javascript">
	function getBookInformation(bookid) {//查询book的详细信息
		var params = "bookid=" + bookid;
		var url = "searchOneBook";
		sendRequest(url, params, 'POST', handleInformation);
	}
	function handleInformation() {//接收book详细信息
	//	alert("4-receive bookinformation");
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				var result = httpRequest.responseText;
				var bookinformation = eval('(' + result + ')');
				showBookInformation(bookinformation[0]);
			}
		}
	}
	function showBookInformation(bookinformation) { //创建书籍详细div
		var third = document.getElementById("third");//右容器
		if (third == null) {
	//		alert("create third");
			third = document.createElement("div");
			third.setAttribute("class", "third");
			third.setAttribute("id", "third");
			var body = document.getElementById("body");
			body.appendChild(third);
		} else if (third.hasChildNodes()) {
			var brefDiv = document.getElementById("brefDiv");
			third.removeChild(brefDiv);
		}
		var picture = document.createElement("img");
		picture.setAttribute("src", "bookpic/"+bookinformation.url);
		picture.setAttribute("width", "100%");
		picture.setAttribute("height", "100%");
		var title = document.createElement("div");//书名
		title.setAttribute("class", "title");
		var author = document.createElement("div");//作者
		author.setAttribute("class", "author");
		var publisher = document.createElement("div");//出版社
		publisher.setAttribute("class", "publisher");
		var isbn = document.createElement("div");//isbn
		isbn.setAttribute("class", "isbn");
		title.innerHTML = "<div>《" + bookinformation.name + "》</div>";
		author.innerHTML = "<div>作者:" + bookinformation.author + "</div>";
		publisher.innerHTML = "<div>出版社:" + bookinformation.publisher
				+ "</div>";
		isbn.innerHTML = "<div>ISBN:" + bookinformation.isbn + "</div>";
		var infoDiv = document.createElement("div");//书名-作者-出版社容器
		var picDiv = document.createElement("div");//封面容器
		var brefDiv = document.createElement("div");//infoDiv-picDiv容器
		brefDiv.setAttribute("id", "brefDiv");
		//图片区域
		picDiv.setAttribute("class", "picture");
		picDiv.appendChild(picture);
		//书名-作者-出版社区域
		infoDiv.setAttribute("class", "info");
		infoDiv.setAttribute("id", "infoDiv");
		infoDiv.appendChild(title);
		infoDiv.appendChild(author);
		infoDiv.appendChild(publisher);
		infoDiv.appendChild(isbn);
		//内容介绍
		var content = document.createElement("div");
		content.innerHTML = "<div class='content'>简介:"
				+ bookinformation.describe + "</div>"
		brefDiv.appendChild(picDiv);
		brefDiv.appendChild(infoDiv);
		brefDiv.appendChild(content);
		third.appendChild(brefDiv);
	}
</script>
<script type="text/javascript">
 function getSearchData(){//查询处理
	 var radio=document.getElementsByName("condition");
     var value=null;   //  selectvalue为radio中选中的值
   	 for(var i=0;i<radio.length;i++){
           if(radio[i].checked) {
                    value=radio[i].value;
                    break;
          }
   	 }
    var keyword=document.getElementById("keyword");
    if(keyword.value==""||keyword.value==null){
    	alert("请输入查询关键字！");
    	return;
    }
    var params="keyword="+keyword.value+"&condition="+value;
    var url="searchBooks";
//    alert(params);
   	sendRequest(url,params,'POST',handleList);
}
function handleList(){//接收ajax查询结果
//	 alert("2-receive booklist");
	 if (httpRequest.readyState == 4) {  
			if (httpRequest.status == 200) {
				var result=httpRequest.responseText;
				var booklist = eval('('+result+')');
				createBookList(booklist);
			}
		}
 }

	function createBookList(booklist) {//创建查询列表
		var second = document.getElementById("second");//第二块容器
		var body = document.getElementById("body");
		if (second == null) {
			second = document.createElement("div");
			second.setAttribute("class", "second");
			second.setAttribute("id", "second");
			body.appendChild(second);
		} else {//移除上一次查询的结果
//			alert("移除上一次结果");
			var third = document.getElementById("third");//右容器
			var listtitle=document.getElementById("listtitle");//第二块标题
			var resultList=document.getElementById("resultList");//第二块列表
			if (third != null) {
				body.removeChild(third);
			}
			second.removeChild(listtitle);
			second.removeChild(resultList);
		}
		var listtitle = document.createElement("div");//创建结果标题
		listtitle.setAttribute("class", "listtitle");
		listtitle.setAttribute("id", "listtitle");
		second.appendChild(listtitle);//添加结果标题
		if (booklist.length > 0) {
			listtitle.innerHTML = "检索结果";
			var resultList = document.createElement("div");//创建列表div
			resultList.setAttribute("class", "resultList");
			resultList.setAttribute("id", "resultList");
			for (var i = 0; i < booklist.length; i++) {
				var bookid = booklist[i].bookid;//书号
				var name = booklist[i].name;//书名
				var listitem = document.createElement("div");//创建列表的item
				listitem.setAttribute("class", "listitem");//组装信息
				listitem.setAttribute("onclick", "onItemClick(this)");//组装信息
				listitem.innerHTML = "<span>"
						+ bookid
						+ " "
						+ name
						+ "</span>";
						//+ "<input type='text' name='bookid' value='"+bookid+"' hidden='true'>";
				listitem.setAttribute("id", bookid);
				resultList.appendChild(listitem);

			}
			second.appendChild(resultList);
		} else {
			listtitle.innerHTML = "没有记录";
		}
	}
	function createList(){
		
		
	}
</script>
<body id="body">
	<div class="first">
			图书检索: <input name="keyword" id="keyword" placeholder="查询信息" />&nbsp; 
					<input id="submit" type="button" value="查询" onclick="getSearchData()"/><br> 
				检索条件: 
				<label>
					<input type="radio" class="a-radio" id="rtitle" 
							name="condition" value="name" checked /> 
					<span class="b-radio"></span><font>书名</font>
				</label> 
				<label> 
					<input type="radio" class="a-radio" id="rauthor"
							name="condition" value="author" />
					<span class="b-radio"></span><font>作者</font>
				</label> 
				<label> 
					<input type="radio" class="a-radio" id="rpublisher"
							name="condition" value="publisher" /> 
					<span class="b-radio"></span><font>出版社</font>
				</label> 
				<label> 
					<input type="radio" class="a-radio" id="risbn"
							name="condition" value="isbn" /> 
					<span class="b-radio"></span><font>ISBN</font>
				</label>

	</div>
	<hr />
	
</html>