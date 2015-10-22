<%@ include file="include/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="send_mail" method="POST">
		<table border="1">
			<tr>
				<td><spring:message code="table.mail" /></td>
				<td><input type="text" placeholder="mail@gmail.com" name="mail" /></td>
			</tr>
			<tr>
				<td><spring:message code="table.password" /></td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><spring:message code="table.title" /></td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td colspan="2"><spring:message code="table.text" /></td>
			</tr>
			<tr>
				<td colspan="2"><textarea name="text"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"
					value="<spring:message code="button.send" />" /></td>
			</tr>
		</table>

	</form>

</body>
</html>