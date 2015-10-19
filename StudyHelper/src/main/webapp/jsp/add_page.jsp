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
	<table>
		<form:form action="add_student" method="POST" commandName="students">
			<tr>
				<td><spring:message code="label.name" /></td>
				<td><form:input type="text" path="name" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.surname" /></td>
				<td><form:input type="text" path="surname" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.password" /></td>
				<td><form:input type="text" path="password" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.email" /></td>
				<td><form:input type="text" path="email" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.phone" /></td>
				<td><form:input type="text" path="phone" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.group" /></td>
				<td><form:input type="text" path="group" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message code="button.add"/>" /></td>
			</tr>
		</form:form>
	</table>
	<form action="add_usersFromFile" enctype="multipart/form-data"
		method="POST">
		<input type="file" name="file" /> <input type="submit" value="Send" />
	</form>

</body>
</html>