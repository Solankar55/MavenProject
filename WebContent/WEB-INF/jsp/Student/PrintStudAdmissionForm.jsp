<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="page-content">
		<div class="page-header center">
			<h1><b>Student Admission From Print Page</b></h1>
			<h4 style="color: red;">${StudentMessageRegardsAdmission}</h4>
		</div>
		<form action="DownLoadAdmissionAplicationForm.html" method="post" target="_blank">

			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table">
								<tr>
									<th>Student Roll Number/Admission ID</th>
									<th>Student Full Name</th>
								</tr>
								<tbody>
									<tr>
										<td><input type="text" name="StudentID" id="StudentID"
											value="${StudentID}" readonly="true"></td>
										<td><input type="text" name="StudentFullName" id=""
											value="${StudentFullName}" readonly="true"></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /.span -->
			</div>
			<hr>
			<div class="center">
				<input name="ApplicationForm" type="submit" class="btn btn-sm btn-purple" value="Download Application Form">
			</div>
		</form>
	</div>
	<br><br><br>
</body>
</html>