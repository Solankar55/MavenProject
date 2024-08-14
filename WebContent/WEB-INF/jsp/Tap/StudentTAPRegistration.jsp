<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="page-content">
		<div class="page-header center">
			<h1><b>Application Form For Training And Placement</b></h1>
		</div>
		<form action="SaveApplicationFormTAP.html" action="post"
			class="form-horizontal">
			<div class="row">
				<div class="col-xs-12">
					<div class="form-group" style="display: none;">
						<label class="col-sm-3 control-label no-padding-right">
							Student Traning And Placement ID: </label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="TAPId"
								value="${TAPID }" id="ID" readonly="true" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Student Full Name:<span style="color:red;">*</span> </label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="StudentFullName"
								id="StudName" placeholder="Student Full Name" required
								pattern="[a-z A-Z]+" title="Please Enter Correct Name" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Student Address: <span style="color:red;">*</span></label>
						<div class="col-sm-9">
							<textarea type="text" class="col-xs-3" name="StudentAddress"
								id="StudAddress" placeholder="Student Address" required></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Contact No:<span style="color:red;">*</span> </label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="StudentContactNumber"
								id="PhoneNumber" placeholder="Contact Number" maxlength="10"
								required pattern="[789][0-9]{9}"
								title="Please Enter Correct Mobile Number" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Gender:<span style="color:red;">*</span> </label>
						<div class="col-sm-9">
							<select class="col-xs-3" id="form-field-select-1"
								name="StudentGender" required>
								<option value="">Select Gender...</option>
								<option value="Male">Male</option>
								<option value="Female">Female</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Date Of Birth:<span style="color:red;">*</span> </label>
						<div class="col-sm-9">
							<input type="date" class="col-xs-3" name="StudentDOB"
								id="DateOFBirth" placeholder="Date Of Birth" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Email:<span style="color:red;">*</span> </label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="StudentEmail"
								id="StudMail" placeholder="Email" type="email" required
								pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Student Category:<span style="color:red;">*</span> </label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="StudentCategory"
								id="StudCategory" placeholder="Category" required
								pattern="[a-z A-Z]+"
								title="Please Enter Correct Student Category" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Cast: </label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="StudentCast"
								id="StudCast" placeholder="Cast" pattern="[a-z A-Z]+"
								title="Please Enter Correct Student Cast" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Qualification:<span style="color:red;">*</span> </label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="StudentQualification"
								id="StudQualification" placeholder="Qualification" required
								pattern="[a-z A-Z]+" title="Please Enter Correct Qualification" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Area of Job Intrested:<span style="color:red;">*</span> </label>
						<div class="col-sm-9">
							<textarea type="text" class="col-xs-3" name="StudentAreaOfJob"
								id="AreaOfJob" placeholder="Area Of Job Intrested" required></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Date: </label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" value="${curentdate }"
								id="ApplicaionDate" name="StudentApplicationDate"
								readonly="true" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Place:<span style="color:red;">*</span> </label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3"
								name="StudentApplicationPlace" id="StudPlace"
								placeholder="Place" required pattern="[a-z A-Z]+"
								title="Please Enter Correct Place" />
						</div>
					</div>
				</div>
				<div class="col-sm-3 control-label no-padding-right">
					<button name="RegisterTAP" id="" value="Submit"
						class="btn btn-big btn-success">Submit</button>
				</div>
				<!-- <div class="col-sm-3 control-label no-padding-right">
					<button name="PrintTAP" id="PrintTAP" value="Submit"
						class="btn btn-big btn-success">Print</button>
				</div> -->
			</div>
		</form>
	</div>
	<br>
	<br>
	<br>
</body>
</html>