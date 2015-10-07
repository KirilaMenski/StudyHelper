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
	<a href="main">Main</a>
	<table border="1">
		<tr>
			<th>№</th>
			<th><spring:message code="label.name" /></th>
			<th><spring:message code="label.surname" /></th>
			<th><spring:message code="label.password" /></th>
			<th><spring:message code="label.email" /></th>
			<th><spring:message code="label.phone" /></th>
		</tr>
		<c:forEach items="${students}" var="students">
			<tr>
				<td>${students.id}</td>
				<td>${students.name}</td>
				<td>${students.surname}</td>
				<td>${students.password}</td>
				<td>${students.email}</td>
				<td>${students.phone}</td>
				<td><a href="delete_student_${students.id}">Delete</a></td>
			</tr>

		</c:forEach>

	</table>

</body>
</html>