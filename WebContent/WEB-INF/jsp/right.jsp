<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="referrer" content="no-referrer">
<title>新书上架</title>
<style type="text/css">
.item{
	height: 180px;
	width:40%;
	float:left;
	margin-top: 6px;
	margin-left:3px;
	margin-left:20px;
	font-weight: bold; /*文字粗体*/
	font-family: 宋体;
	font-size:10pt;
	letter-spacing: 2pt;
	text-align: center;
	z-index: 9;
	border-radius:1px;
	-webkit-box-shadow: #999 0px 0px 8px;
    -moz-box-shadow: #999 0px 0px 8px;
    box-shadow: #999 0px 0px 8px;
}
.picture{
	width: 98%;
	height:80%;
	padding:1px;
	align-self: center;
}
.title{
	padding-top:2px;
	background: #EEC591;
	height:20%;
}
.booklist{
	overflow-y: auto;
	height: 480px;
}
.shlef{
	margin:0px;
	height:50px;
	background-color:#EEC591;
	padding-top:20px;
	text-align: center;
	-webkit-box-shadow: #999 0px 0px 8px;
    -moz-box-shadow: #999 0px 0px 8px;
    box-shadow: #999 0px 0px 8px;
}

body{
	 margin:0px; padding:0px; 
	 background:#fff;
}
</style>

</head>
<body>
	<div class="shlef">新书上架</div>
	<div class="booklist">
		<c:if test="${not empty bookList}" var="books" scope="application">
				<c:forEach var="book" items="${bookList}" varStatus="status" step="1">
					<div class="item" onclick="onItemClick(this)">
						<img class="picture" src="bookpic/${book.url}"/>
						<div class="title">${book.name}</div>
					</div>
				</c:forEach>
		</c:if>
	</div>
</body>
</html>