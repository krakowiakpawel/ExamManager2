<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>comMembers</h1>
	<c:forEach items="${comMembers}" var="cm">
		<li>${cm.id} - ${cm.nameSurname} - <a class="confirm"
			href="${pageContext.request.contextPath}/comMember/delete/${cm.id}">Delete</a>
			<a href="${pageContext.request.contextPath}/comMember/edit/${cm.id}">edit</a>
		</li>
	</c:forEach>

	<script>
		$(document).ready(function() {
			$('.confirm').click(function(e) {
				e.preventDefault();
				if (window.confirm("Are you sure?")) {
					location.href = this.href;
				}
			});
		});
	</script>
</body>
</html>