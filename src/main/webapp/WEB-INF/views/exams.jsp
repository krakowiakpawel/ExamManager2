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
<h1>Exams</h1>
<c:forEach items="${exams}" var="exam">
		<li>${exam.id} - ${exam.number} - <a class="confirm"
			href="${pageContext.request.contextPath}/exam/delete/${exam.id}">Delete</a>
			<a href="${pageContext.request.contextPath}/exam/edit/${exam.id}">edit</a>
		</li>
	</c:forEach>
</body>
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

</html>