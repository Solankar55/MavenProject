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
			<h1>Send Alumini Link To Student</h1>
			<h3 style="color: red;">${StudentMsg}</h3>
		</div>
		
		<form action="SendSMSAlumini.html" method="post" class="form-horizontal">
		<div class="row">
			<div class="col-xs-12">
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right">
						Student Mobile Number: <span style="color:red;">*</span></label>
					<div class="col-sm-9">
						<input type="text" name="StudentContactNumber" class="col-xs-3" id=""
							placeholder="Student Contact Number "
							maxlength="10" required pattern="[789][0-9]{9}" title="Please Enter Correct Mobile Number"  />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right">
						Message: <span style="color:red;">*</span></label>
					<div class="col-sm-9">
					<textarea class="col-xs-3" name="MessageForStudent" placeholder="Student Message " rows="5" required></textarea>
					</div>
				</div>
				<div class="form-group ">
					<div class="col-sm-3 control-label no-padding-right">
						<button type="submit" id="" value="Send Link" name="SendSMS"
							class="btn btn-big btn-success">Send</button>
					</div>

				</div>

			</div>
		</div>
		</form>
	</div>
	
</body>
</html>