<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Com Member </h1>
	<form:form modelAttribute="comMember" method="post">
		<form:hidden path="id" />
		<br/>
		<label>Imię i Nazwisko</label>
		<form:input path="nameSurname" />
		<br/>
		<label>SailingLicence</label>
		<form:input path="sailingLicence" />
		<br/>
		<label>InstructorLicence</label>
		<form:input path="instructorLicence" />
		<br/>
		<form:button type="submit">Save</form:button>
	</form:form>

</body>
</html>