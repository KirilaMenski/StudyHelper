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
	<a href="?lang=en">EN</a>
	<a href="?lang=be">BE</a>
	<h1><spring:message code="label.hello"/></h1>
	
	<a href="show_all"><spring:message code="href.show_all" /></a>
	<a href="add_page"><spring:message code="href.add"/></a>
	
</body>
</html>