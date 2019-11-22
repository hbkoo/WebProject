<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息</title>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<link type="text/css" rel="stylesheet" href="${path}/css/personal.css">
<script type="text/javascript" src="js/ajax.js"></script>
</head>
<body>
	<div class="title"><span class="span">我的信息</span></div>
	<table class="infotable">
		<tbody>
			<tr>
				<th>UID</th>
				<td id="uid" class="col2" width="200px">${sessionScope.user.userID}</td>
			</tr>
			<tr>
				<th>状态</th>
				<td class="col2" width="200px">${sessionScope.user.status}</td>
			</tr>
			<tr>
				<th>昵称</th>
				<td class="col2" width="200px">
					<input id="nickname" class="nickname" type="text" name="nickname" readonly="readonly" value="${sessionScope.user.name}" />
				</td>
			</tr>
			<tr>
				<th>专业</th>
				<td id="col2" width="200px">${sessionScope.user.academy}</td>
			</tr>
			<tr>
				<th>班级</th>
				<td id="col2" width="200px">${sessionScope.user.className}</td>
			</tr>
			<tr>
				<th>借阅次数</th>
				<td class="col2" width="200px">${sessionScope.user.num}</td>
			</tr>
			<tr>
				<th>逾期欠费</th>
				<td class="col2" width="200px">${sessionScope.user.money}</td>
			</tr>
			<tr>
				<th></th>
				<td class="col3" width="200px">
					<button class="edit" id="editName"  style="display:block;" onclick="editNickName()">编辑昵称</button>
					<button class="edit" id="cancel"  style="display:none;" onclick="resetDisplay()">取消</button>
					<button class="edit" id="confirm" style="display:none;" onclick="confirmEdit()">确认</button>
				</td>
			</tr>
		</tbody>
	</table>
</body>
<script type="text/javascript">

	var cancel = document.getElementById("cancel");
	var confirm = document.getElementById("confirm");
	var editName = document.getElementById("editName");
	var uid = document.getElementById("uid");
	function editNickName() {
		cancel.style.display = "block";
		confirm.style.display = "block";
		editName.style.display = "none";
		var name = document.getElementById("nickname");
		name.readOnly = false;
		alert(name.value);
	}
	function resetDisplay() {
		cancel.style.display = "none";
		confirm.style.display = "none";
		editName.style.display = "block";
		var name = document.getElementById("nickname");
		name.readOnly = true;
	}
	function confirmEdit() {
		var name = document.getElementById("nickname");
		var url = "infoChange";
		var params = "userID=" + uid.innerHTML + "&name=" + name.value;
		alert(params);
		sendRequest(url, params, "POST", function() {
			if (httpRequest.readyState == 4) {
				if (httpRequest.status == 200) {
					var result = httpRequest.responseText;
					var info=" ";
					if (1==result) {
						info ="昵称更改成功！";
					} else {
						info ="昵称更改失败！";
					}
					alert(info);
				}
			}

		});
	}
</script>
</html>