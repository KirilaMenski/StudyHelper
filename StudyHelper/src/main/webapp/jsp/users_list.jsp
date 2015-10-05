<%@ include file="include/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>StudyHelper</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>№</th>
			<th><spring:message code="label.name" /></th>
			<th><spring:message code="label.surname" /></th>
			<th><spring:message code="label.password" /></th>
			<th><spring:message code="label.email" /></th>
			<th><spring:message code="label.phone" /></th>
		</tr>
		<c:forEach items="${users}" var="users">
			<tr>
				<td>${users.id}</td>
				<td>${users.name}</td>
				<td>${users.surname}</td>
				<td>${users.password}</td>
				<td>${users.email}</td>
				<td>${users.phone}</td>
			</tr>

		</c:forEach>

	</table>

</body>
</html>