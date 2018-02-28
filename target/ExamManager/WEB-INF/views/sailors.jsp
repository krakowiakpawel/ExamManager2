<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Sailors</h1>
<c:forEach items="${sailors}" var="sailor">
		<li>${sailor.id} - ${sailor.nameSurname} - <a class="confirm"
			href="${pageContext.request.contextPath}/sailor/delete/${sailor.id}">Delete</a>
			<a href="${pageContext.request.contextPath}/sailor/edit/${sailor.id}">edit</a>
			<a href="${pageContext.request.contextPath}/sailor/pdf/${sailor.id}">Generate PDF</a>
			<a href="${pageContext.request.contextPath}/sailor/print/${sailor.id}">Print him!</a>
		</li>
		</li>
	</c:forEach>
	<br/>
	MessageText: ${message}
</body>
<script src="/js/AreYouSure.js"></script>
	
</html>