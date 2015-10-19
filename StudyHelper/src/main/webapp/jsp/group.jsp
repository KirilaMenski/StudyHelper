<%@ include file="include/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="res/js/select_lesson.js"></script>
<title>Study Helper</title>
<style type="text/css">
#table1 {
	float: left;
}

#table2 {
	float: left;
	margin-left: 5pt;
}

table {
	border-spacing: 0px 0px;
}

table th {
	height: 22px;
}

#x {
	border: 1pt solid black;
}
</style>
</head>
<body>

	${group}
	<br />

	<c:forEach items="${lessons}" var="lessons">
		<a href="view_group_${group}_lesson_${lessons.id}">
			${lessons.lesson}</a>
	</c:forEach>
	<br />
	<div id="table1">
		<table border="1">
			<c:forEach items="${studentsByGroup}" var="studentsByGroup">
				<tr>
					<th><a href="student_profile_${studentsByGroup.id}_lesson_1">${studentsByGroup.surname}
							${studentsByGroup.name}</a></th>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div id="table2">
		<form:form action="add_ratings" method="POST" commandName="ratings">
			<table border="1">
				<c:forEach items="${studentsByGroup}" var="studentsByGroup">
					<tr>
					</tr>
					<c:forEach items="${numb}" var="numb">
						<td><form:input type="text" value="  " path="rating" size="1" /></td>
					</c:forEach>
				</c:forEach>
			</table>
			<br />
			<input type="submit" value="<spring:message code="button.update"/>" />
			<input type="submit" value="<spring:message code="button.add"/>" />
		</form:form>
	</div>
	<br />
	<br />
	<br />
	<!--
	<div id="x">
	<table>
	<c:forEach items="${xi}" var="xi">
	<tr>
		<td></td>
	</tr>
		<c:forEach items="${xj}" var="xj">
				<td>${xj}</td>
		</c:forEach>
	</c:forEach>
	</table>
	</div>-->
</body>
</html>