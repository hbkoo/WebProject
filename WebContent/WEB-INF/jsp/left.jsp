<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<link href="${path}/css/leftstyle.css" rel="stylesheet" type="text/css" >
<title>left</title>
<style>
</style>
</head>
<body>
	<ul>
		<c:if test="${not empty user}" var="result" scope="session">
			<li><A class="hover" href="center" target="center">首页</A></li>
			<li><A href="bookSearch" target="center">图书查询</A></li>
			<li><A href="myBorrow" target="center">我的借阅</A></li>
			<li><A href="myInfo" target="center">个人信息</A></li>
			<li><A href="logout" target="_parent">注销</A></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</c:if>
		<c:if test="${result==false}">
			<li><A class="hover">未登录</A></li>
		</c:if>
	</ul>
</body>
</html>