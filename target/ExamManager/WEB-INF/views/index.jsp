<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>HELLO WORLD!</h1>
	<a href="${pageContext.request.contextPath}/exam/add">Add Exam</a> <br/>
	<a href="${pageContext.request.contextPath}/comMember/add">comMember Add</a> <br/>
	<a href="${pageContext.request.contextPath}/sailor/add">Sailor Add</a> <br/>
	<br/>
	<a href="${pageContext.request.contextPath}/sailor/">View Sailors</a> <br/>
	<a href="${pageContext.request.contextPath}/comMember/">View comMember</a> <br/>
	<a href="${pageContext.request.contextPath}/exam/">View exam</a> <br/>
	<br/>
		<a href="${pageContext.request.contextPath}/pdf2">PDF Action2</a> <br/>
		<a href="${pageContext.request.contextPath}/dumpSQL">Dump SQL</a> <br/>
		<p>
<img src="images/pirate.jpg">
</p>
</body>
</html>