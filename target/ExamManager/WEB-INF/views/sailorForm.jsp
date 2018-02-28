<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Sailor</h1>
	<form:form modelAttribute="sailor" method="post">
		<form:hidden path="id" />
		<br />
		<label>nameSurname</label>
		<form:input path="nameSurname" />
		<br />
		<label>email</label>
		<form:input path="email" />
		<br />
		<label>dateOfBirth</label>
		<form:input path="dateOfBirth" id="datepicker" readonly="true" />
		<br />
		<label>placeOfBirth</label>
		<form:input path="placeOfBirth" />
		<br />
		<label>adress</label>
		<form:input path="adress" />
		<br />
		<label>Student?</label>
		<form:checkbox path="student" />
		<br />
		<label>studentCardNumber</label>
		<form:input path="studentCardNumber" />
		<br />
		<label>Exam?</label>
		<form:select itemValue="id" itemLabel="number" path="exam"
			items="${exams}" />
		<br />
		<form:button type="submit">Save</form:button>
	</form:form>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"
		integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU="
		crossorigin="anonymous"></script>
	<script>
		$(function() {
			$("#datepicker").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
	</script>
</body>
</html>