<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" />

<title>Insert title here</title>
</head>
<body>
	<h1>Add Exam</h1>
	<form:form modelAttribute="exam" method="post">
		<form:hidden path="id" />
		<br/>
		<label>Miejsce</label>
		<form:input path="place" value='defaultValue' />
		<br/>
		<label>Data</label>
		<form:input path="date" id="datepicker" readonly="true"/>
		<br/>
		<label>Numer</label>
		<form:input path="number" placeholder="aaaa" />
		<br/>
		<label>Typ</label>
		<form:select path="type">
			<form:option value="-" label="--Please	Select--" />
			<form:option value="SM" label="SM" />
			<form:option value="ZJ" label="ZJ" />
		</form:select>
		<br/>
		<label>Chairman</label>
		<form:select itemValue="id" itemLabel="nameSurname" path="chairman"
			items="${comMembers}" />
		<br/>
		<label>Secretary</label>
		<form:select itemValue="id" itemLabel="nameSurname" path="secretary"
			items="${comMembers}" />
		
		<br/>
		<form:button type="submit">Save</form:button>
	</form:form>
	<script
			  src="https://code.jquery.com/jquery-3.3.1.min.js"
			  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
			  crossorigin="anonymous"></script>
	<script
			  src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"
			  integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU="
			  crossorigin="anonymous"></script>
	<script>
		$(function() {
			$("#datepicker").datepicker({ dateFormat: 'dd-mm-yy' });
		});
	</script>
</body>
</html>