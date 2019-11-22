<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>head</title>
<style type="text/css">
.title {
	text-align:center;
	font-family: fusanghu;
	font-size: 30pt;
	font-weight: 900;
	color: brown;
}
/*使用前必须先定义*/
@font-face {
	/* 字体名称随意起 */
	font-family: jinpingmei;
	/*你下载字体所在的位置*/
	src: url("font/font_1.ttf");
}
.user{
	font-size: 12pt;
	margin-bottom: 6px;
}
body{
	margin:0;
	padding:0;
	z-index: 9;
	background-color:#EEC591;
}
</style>
</head>
<body>
	<div class="title">图书借阅信息</div>
	<div class="user">欢迎您：
		<c:if test="${not empty user}" var="bool">
			${user.name}
		</c:if>
		<c:if test="${bool==false}" var="bool">
			同学，登录查看借阅信息
		</c:if>
	</div>
</body>
</html>