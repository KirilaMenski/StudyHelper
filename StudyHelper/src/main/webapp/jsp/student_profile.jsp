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


	<form:form action="edit_student" commandName="student">
		<spring:message code="label.name" />
		<form:input type="text" id="name" path="name" value="${student.name}" />
		<br />
		<spring:message code="label.surname" />
		<form:input type="text" path="surname" value="${student.surname}" />
		<br />
		<spring:message code="label.password" />
		<form:input type="text" path="password" value="${student.password}" />
		<br />
		<spring:message code="label.email" />
		<form:input type="text" path="email" value="${student.email}" />
		<br />
		<spring:message code="label.phone" />
		<form:input type="text" path="phone" value="${student.phone}" />
		<br />
		<form:input type="text" path="group" value="${student.group}" />
		<br />
		<input type="submit" value="<spring:message code="button.add"/>" />
	</form:form>
	<br/>

	<c:forEach items="${stud_lessons}" var="stud_lessons">
		<a href="student_profile_${studentId}_lesson_${stud_lessons.id}">${stud_lessons.lesson}</a>
	</c:forEach>
	<br/>
	<c:forEach items="${stud_rating}" var="stud_rating">
		${stud_rating.rating} / ${stud_rating.date} 
	</c:forEach>

</body>
</html>