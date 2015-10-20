<%@ include file="include/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="res/js/select_lesson.js"></script>
<title>Study Helper</title>
</head>
<body>

	${group}
	<br />

	<c:forEach items="${lessons}" var="lessons">
		<a href="view_group_${group}_lesson_${lessons.id}">
			${lessons.lesson}</a>
	</c:forEach>
	<br />
	<br />
	<br />

	<table border="1">

		<c:forEach items="${studentsByGroup}" var="studentsByGroup">
			<tr>
				<th><a href="student_profile_${studentsByGroup.id}_lesson_1">${studentsByGroup.name} ${studentsByGroup.surname}</a></th>

				<c:forEach items="${studRatings}" var="studRatings">
					<td><input type="text" value="${studRatings.rating}" size="1" /></td>
				</c:forEach>
				<td><input type="text" size="1" /></td>
			</tr>

		</c:forEach>

	</table>

</body>
</html>