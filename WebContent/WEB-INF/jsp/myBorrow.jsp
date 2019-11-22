<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的借阅</title>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<link href="${path}/css/myBorrow.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="title"><span class="span">借阅列表</span></div>
<table class="imagetable">
	<tbody class="tbody">
		<tr class="tr">
			<td class="td"><font>书号</font></td>
			<td><font>书名</font></td>
			<td><font>借阅时间</font></td>
			<td><font>借阅期限</font></td>
			<!-- <td><font>是否逾期</font></td> -->
			<td><font>逾期时长</font></td>
			<td><font>逾期罚金</font></td>
		</tr>
			<c:if test="${not empty borrowList}" var="borrowed" scope="session">
				<c:forEach var="book" items="${borrowList}" varStatus="status"
					step="1">
					<tr class="detail">
						<td class="td"><font>${book.bookID}</font></td>
						<td class="td"><font>${book.bookName}</font></td>
						<td class="td"><font>${book.borrowTime}</font></td>
						<td class="td"><font>${book.returnTime}</font></td>
						<td class="td"><font> 
							<c:if test="${book.overTime>0}"
									var="bool">
									${book.overTime}(天)
							</c:if> <c:if test="${bool==false}">
									未逾期
							</c:if>
						</font>
						</td>
						<td class="td"><font>${book.money}(元)</font></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
</table>
<c:if test="${borrowed==false}">
	<div class="info">没有借阅&gt; &lt;,快去借书吧~~ </div>
</c:if>
</body>
</html>