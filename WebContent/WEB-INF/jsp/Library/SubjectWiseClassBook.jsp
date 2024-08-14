<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
button {
	color: blue;
	width: 150px;
	height: 40px;
	
}
</style>
</head>
<body>
	<div class="page-content">
		<div class="page-header">
			<center>
				<h1>Book Subject Wise Classification</h1>
			</center>
		</div>

		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<form action="subjectClassificationBookReport.html" method="get" id=""
					class="form-horizontal" target="_blank">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Book For :</label>
						<div class="col-sm-9">
							<select  id="bookfor" name="BookFor"
								class="col-sm-3">
								<option value="">Select Book For</option>
								<option value="PostGraduation">PostGraduation</option>
								<option value="Degree">Degree</option>
								<option value="Diploma">Diploma</option>
								<option value="Other">Other</option>
							</select>

						</div>
					</div>

					<div class="form-group ">
						<div class="col-sm-3 control-label no-padding-right">
							<button type="submit" class="btn btn-big btn-success">
								Print</button>
						</div>
					</div>
				</form>
			</div>
		</div></div>
</body>
</html>