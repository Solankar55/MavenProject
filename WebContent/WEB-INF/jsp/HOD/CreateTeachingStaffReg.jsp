<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Non Teaching Staff Registration Page</title>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#UserName").blur(function(){
		
		var userName=$("#UserName").val();
		
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
            document.getElementById('cpassword').value) {
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
			<center>
				<h1>Add Staff </h1>
			</center>
			<br>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<form action="SaveStaff.html" method="post" class="form-horizontal"
					role="form">
					<input type="hidden" name="StaffID" value="${ StaffID }">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> Staff Type:<span style="color:red;">*</span> </label>

						<div class="col-sm-9">
							<select class="col-xs-10 col-sm-5" name="StaffType" required>
								<option value="">------Select Staff Type-------</option>
								<option value="Non Teaching">Non Teaching</option>
								<option value="Teaching">Teaching</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> Name:<span style="color:red;">*</span> </label>

						<div class="col-sm-9">
							<input type="text" id="form-field-1" placeholder="Full name start with Surname"
								class="col-xs-10 col-sm-5" name="StaffName" required
								pattern="[a-z A-Z]+" title="Please Enter Correct Name" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> Qualification:<span style="color:red;">*</span> </label>

						<div class="col-sm-9">
							<input type="text" id="form-field-1" placeholder="Qualification"
								class="col-xs-10 col-sm-5" name="Qalification" required
								pattern="[a-z A-Z .]+" title="Please Enter Qualification" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> Years Of Experience:<span style="color:red;">*</span> </label>

						<div class="col-sm-9">
							<input name="YearOfExperience" type="text" id="form-field-1"
								placeholder="Number Of Experience" name="YearOfExperience"
								class="col-xs-10 col-sm-5" required
								pattern="[0-9]+" title="Please Enter Correct Experience" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> Address:<span style="color:red;">*</span> </label>

						<div class="col-sm-9">
							<input type="text" name="StaffAddress" id="form-field-1"
								placeholder="Address" name="StaffAddress"
								class="col-xs-10 col-sm-5" required
								pattern="[a-z A-Z 0-9._%+-]+"
								title="Please Enter Correct Address" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> Department: </label>

						<div class="col-sm-9">
							<input name="SatffDepartment" type="text" id="form-field-1"
								placeholder="Department" class="col-xs-10 col-sm-5" 
								pattern="[a-z A-Z]+" title="Please Enter Correct Department" />
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
							for="form-field-1"> Email:<span style="color:red;">*</span> </label>

						<div class="col-sm-9">
							<input type="email" name="StaffEmail" id="form-field-1"
								placeholder="Email" class="col-xs-10 col-sm-5" required
								pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">Registration Date: </label>

						<div class="col-sm-9">
							<input type="text" name="StaffRegDate" id="form-field-1"
								value="${CurrentDate }" class="col-xs-10 col-sm-5"
								readonly="true" required />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> User Name:<span style="color:red;">*</span> </label>

						<div class="col-sm-9">
							<input type="text" id="UserName" placeholder="UserName"
								name="UserName" class="col-xs-10 col-sm-5" required
								pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
								title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> Password:<span style="color:red;">*</span> </label>

						<div class="col-sm-9">
							<input type="password" id="password" placeholder="Password"
								name="Password" class="col-xs-10 col-sm-5" required
								pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
								title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">Confirm Password:<span style="color:red;">*</span></label>

						<div class="col-sm-9">
							<input type="password" id="cpassword"
								placeholder="Confirm Password" class="col-xs-10 col-sm-5"
								required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
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
	<br>
	<br>
	<br>
</body>
</html>