<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<div class="page-content">
		<div class="page-header">
			<h1><b>Student Admission Page</b></h1>
		</div>
		<h3>Congratulations.<b> ${StudentFullName} </b>.Your Admission process has been successfully completed. &nbsp;</h3>
		<form action="StudentNextYearAdmissionProc.html" method="post">
			<input type="hidden" name="studentFullName" value="${StudentFullName }">
			<input type="hidden" name="studentId" value="${StudentID}">
			<input type="submit" name="takeNextYearAdmission" value="Take Next Year Admission">
		</form>
		<!-- <h4><a href="">Take Next Year Admission</a></h4> -->
</div>
</body>
</html>