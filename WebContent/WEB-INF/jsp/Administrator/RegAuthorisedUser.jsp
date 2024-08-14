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
		<div class="page-header">
			<center>
				<h1>Create New User</h1>
			</center>
			<br>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<form action="RegisterAuthUser.html" method="get"
					class="form-horizontal" role="form">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> Name:<span style="color:red;">*</span> </label>

						<div class="col-sm-9">
							<input name="Name" type="text" id="form-field-1"
								placeholder="Full Name" class="col-xs-10 col-sm-5" required
								pattern="[a-z A-Z]+" title="Please Enter Correct Name" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> Address: <span style="color:red;">*</span></label>

						<div class="col-sm-9">
							<input type="text" name="Address" id="form-field-1"
								placeholder="Address" class="col-xs-10 col-sm-5" required
								pattern="[a-z A-Z 0-9._%+-]+"
								title="Please Enter Correct Address" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> Mobile Number:<span style="color:red;">*</span> </label>

						<div class="col-sm-9">
							<input type="text" name="MobileNumber" id="form-field-1"
								placeholder="Mobile Number" class="col-xs-10 col-sm-5"
								maxlength="10" required pattern="[789][0-9]{9}"
								title="Please Enter Correct Mobile Number" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> Email: <span style="color:red;">*</span></label>

						<div class="col-sm-9">
							<input type="email" name="Email" id="form-field-1"
								placeholder="Email" class="col-xs-10 col-sm-5" type="email"
								required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> Date: </label>

						<div class="col-sm-9">
							<input type="text" name="Date" id="form-field-1"
								value="${CurrentDate }" class="col-xs-10 col-sm-5"
								readonly="true" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">User Type:<span style="color:red;">*</span></label>
						<div class="col-sm-9">
							<select class="col-xs-10 col-sm-5" name="Type" id="form-field-1"
								placeholder="Choose a User Type..." required>
								<option value="">Choose a User Type...</option>
								<%-- <s:option value="Administrator">Administrator</s:option> --%>
								<option value="Accountant">Accountant</option>
								<option value="Librarian">Librarian</option>
								<!-- <option value="Employee">Employee</option> -->
								<!-- <option value="Lecturer">Lecturer</option> -->
								<option value="HOD">HOD</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> User Name: <span style="color:red;">*</span></label>

						<div class="col-sm-9">
							<input type="text" name="Username" id="form-field-1"
								placeholder="UserName" class="col-xs-10 col-sm-5" required
								pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
								title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> Password:<span style="color:red;">*</span> </label>

						<div class="col-sm-9">
							<input type="password" name="Password" id="form-field-1"
								placeholder="Password" class="col-xs-10 col-sm-5" required
								pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
								title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">Confirm Password:<span style="color:red;">*</span> </label>

						<div class="col-sm-9">
							<input type="password" id="form-field-1"
								placeholder="Confirm Password" class="col-xs-10 col-sm-5"
								required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
								title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" />
						</div>
					</div>


					<div class="clearfix form-actions">
						<div class="col-md-offset-3 col-md-9">
							<button class="btn btn-info" id="OK" type="submit">
								<i class="ace-icon fa fa-check bigger-110"></i> Create User
							</button>

							&nbsp; &nbsp;
							<button class="btn" type="reset">
								<i class="ace-icon fa fa-undo bigger-110"></i> Reset
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
</body>
</html>