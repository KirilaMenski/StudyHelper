<%@ include file="include/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Study Helper</title>
</head>
<body>

	${group}
	<br/>
	<select>
		<c:forEach items="${lessons}" var="lessons">
		<option>${lessons.lesson}</option>
		</c:forEach>
	</select>

	<table border="1">
		<c:forEach items="${studentsByGroup}" var="studentsByGroup">
			<tr>
				<th><a href="student_profile_${studentsByGroup.id}">${studentsByGroup.name}
						${studentsByGroup.surname}</a></th>
			</tr>
		</c:forEach>
	</table>

</body>
</html>