<%@ include file="include/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>StudyHelper</title>
<style type="text/css">
ul {
	list-style: none;
}

ul li {
	float: left;
}
</style>
</head>
<body>
	<a href="main">Main</a>
	<table border="1">
		<tr>
			<th><a href="show_all_page_1_sorting_by_id">№</a></th>
			<th><a href="show_all_page_1_sorting_by_name"><spring:message
						code="table.name" /></a></th>
			<th><a href="show_all_page_1_sorting_by_surname"><spring:message
						code="table.surname" /></a></th>
			<th><a href="show_all_page_1_sorting_by_password"><spring:message
						code="table.password" /></a></th>
			<th><a href="show_all_page_1_sorting_by_email"><spring:message
						code="table.email" /></a></th>
			<th><a href="show_all_page_1_sorting_by_phone"><spring:message
						code="table.phone" /></a></th>
			<th><a href="show_all_page_1_sorting_by_group"><spring:message
						code="table.group" /></a></th>
		</tr>
		<c:forEach items="${students}" var="students">

			<tr>

				<td>${students.id}</td>
				<td><a href="student_profile_${students.id}_lesson_1">${students.name}</a></td>
				<td>${students.surname}</td>
				<td>${students.password}</td>
				<td>${students.email}</td>
				<td>${students.phone}</td>
				<td><a href="view_group_${students.group}_lesson_1">${students.group}</a></td>
				<td><a href="delete_student_${students.id}"><spring:message code="label.delete" /></a></td>

			</tr>


		</c:forEach>

	</table>
	<br />
	<c:forEach items="${pages}" var="pages">
		<ul>
			<li>-</li>
			<li><a href="show_all_page_${pages}_sorting_by_${colName}">${pages}</a></li>
		</ul>
	</c:forEach>

</body>
</html>