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
	<form:form action="add_users" method="POST" commandName="users">
		<spring:message code="label.name" />
		<form:input type="text" path="name" />
		<br />
		<spring:message code="label.surname" />
		<form:input type="text" path="surname" />
		<br />
		<spring:message code="label.password" />
		<form:input type="text" path="password" />
		<br />
		<spring:message code="label.email" />
		<form:input type="text" path="email" />
		<br />
		<spring:message code="label.phone" />
		<form:input type="text" path="phone" />
		<br />
		<input type="submit" value="<spring:message code="button.add"/>" />
	</form:form>
</body>
</html>