<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
$(document).ready(function(){
	
	$("#userName").blur(function(){
		
		var userName=$("#userName").val();
		
		$.getJSON('checkUserData.html',{userName:userName}).done(function(data){
			
			//alert("Data Recived");
			if(data.length!=0)
				{
					alert("User Name Already Used.");
					$("#OK").hide();
				}
			else
				{
					$("#OK").show();
				}
		});
		
	});
	
});

</script>
<script type="text/javascript">
function check_pass() {
    if (document.getElementById('password').value ==
            document.getElementById('confirm_password').value) {
        document.getElementById('submit').disabled = false;
    } else {
    	alert("Password not matched.");
        document.getElementById('submit').disabled = true;
    }
}
</script>

</head>
<body>
	<div class="page-content">
		<div class="page-header">
			<center><h1>Create New User</h1></center>
			<br>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<form action="RegisterUser.html" onsubmit="return checkForm(this);"
					method="post" class="form-horizontal" role="form">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> Name: <span style="color:red;">*</span></label>

						<div class="col-sm-9">
							<input name="Name" type="text" id="form-field-1"
								placeholder="Name" class="col-xs-10 col-sm-5" required pattern="[a-z A-Z]+" title="Please Enter Correct Name">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> Address:<span style="color:red;">*</span> </label>

						<div class="col-sm-9">
							<input type="text" name="Address" id="form-field-1"
								placeholder="Address" class="col-xs-10 col-sm-5" required pattern="[a-z A-Z 0-9._%+-]+" title="Please Enter Correct Address">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> Mobile Number:<span style="color:red;">*</span> </label>

						<div class="col-sm-9">
							<input type="text"  name="MobileNumber" id="form-field-1" maxlength="10"
								placeholder="Mobile Number" class="col-xs-10 col-sm-5" required pattern="[789][0-9]{9}" title="Please Enter Correct Mobile Number" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> Email:<span style="color:red;">*</span> </label>

						<div class="col-sm-9">
							<input type="email" name="Email" id="form-field-1"
								placeholder="Email" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" class="col-xs-10 col-sm-5" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> Date: </label>

						<div class="col-sm-9">
							<input type="text" name="Date" value="${CurrentDate }" id="form-field-1"
								readonly="true" class="col-xs-10 col-sm-5" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">User Type:<span style="color:red;">*</span></label>
						<div class="col-sm-9">
							<select class="col-xs-10 col-sm-5" name="Type"
								id="form-field-1" placeholder="Choose a State..." required>
								<option value="">Choose a User Type...</option>
								<option value="Administrator">Administrator/Principal</option>
								<option value="Accountant">Accountant</option>
								<!-- <option value="Librarian">Librarian</option>
										<option value="Employee">Employee</option>
										<option value="Lecturer">Lecturer</option>
										<option value="HOD">HOD</option>
										<option value="Principal">Principal</option> -->
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> User Name:<span style="color:red;">*</span> </label>

						<div class="col-sm-9">
							<input type="text" name="Username" id="userName"
								placeholder="UserName" class="col-xs-10 col-sm-5"
								required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"  title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> Password:<span style="color:red;">*</span> </label>

						<div class="col-sm-9">
							<input type="password" name="Password" id="password"
								placeholder="Password" class="col-xs-10 col-sm-5" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"  title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" 
								/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">Confirm Password: <span style="color:red;">*</span></label>

						<div class="col-sm-9">
							<input type="password" id="confirm_password" name=""
								placeholder="Confirm Password" class="col-xs-10 col-sm-5" required  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
								title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
								onchange='check_pass();'/>
						</div>
					</div>


					<div class="clearfix form-actions" id="OK">
						<div class="col-md-offset-3 col-md-9">
							<button class="btn btn-info"  type="submit" id="submit" disabled="true">
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
	<br><br><br>
</body>
</html>