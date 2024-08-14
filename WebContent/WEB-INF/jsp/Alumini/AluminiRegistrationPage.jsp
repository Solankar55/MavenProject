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
			<h1><b>SHIRUR STCOPIANS ALUMNI ASSOCIATION</b></h1>
			<h1><b>SITABAI THITE COLLEGE OF PHARMACY</b></h1>
		</div>
		<form action="SaveAluminiFormD.html" method="post"
			class="form-horizontal">
			<div class="row">
				<div class="col-xs-12">

					<div class="form-group">
						<h4>Personal Information</h4>
						<label class="col-sm-3 control-label no-padding-right">
							Dr./Mr./Ms./Mrs./Smt. <span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="RegisterUserName"
								placeholder="Full Name" required pattern="[a-z A-Z]+"
								title="Please Enter Correct Name" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Date of Birth:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="date" class="col-xs-3" name="RegisterUserBirthDate"
								placeholder="Date of Birth" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Blood Group:</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="UserBloodGroup"
								placeholder="Blood Group" pattern="[A-Z+-]+"
								title="Please Enter Blood Group " />
						</div>

					</div>
					<hr />

					<div class="form-group">
						<h4>Contact Details</h4>
						<label class="col-sm-3 control-label no-padding-right">
							Address (Residential): <span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<textarea class="col-xs-3" id="" name="UserResidentialAddress"
								placeholder="Residential Address"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Address (Office):
						</label>
						<div class="col-sm-9">
							<textarea class="col-xs-3" id="" name="UserOfficialAddress"
								placeholder="Official Address"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Mobile:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="MobileNumber"
								placeholder="Mobile Number" maxlength="10" required
								pattern="[789][0-9]{9}"
								title="Please Enter Correct Mobile Number" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Email:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="email" class="col-xs-3" name="UserEmail"
								placeholder="Email" required
								pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" />
						</div>
					</div>
					<hr />

					<div class="form-group">
						<h4>Educational Profile</h4>
						<label class="col-sm-3 control-label no-padding-right">
							D.pharm/B.Pharm: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="Education"
								placeholder="Education" required pattern="[a-z A-Z]+"
								title="Please Enter Correct Education" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Year Of Passing:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="YearOfPassing"
								placeholder="Year Of Passing: 2016" maxlength="4" required
								pattern="[0-9]{4}"
								title="Please Enter Correct Year Of Passing Like 2016" />
						</div>
					</div>


					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Pharmacist Registration No: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3"
								name="UserRegisterationNumber"
								placeholder="Pharmacist Registration No:" required
								pattern="[0-9]+" title="Please Enter Correct Registration No" />
						</div>
					</div>
					<hr />

					<div class="form-group">
						<h4>Career Information</h4>
						<label class="col-sm-3 control-label no-padding-right">
							Present Employment/Higher Studies:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="DetailsEmployment"
								placeholder="Present Employment/Higher Studies:" required
								pattern="[a-z A-Z]+"
								title="Please Enter Correct Employment/Higher Studies" />
						</div>
					</div>


					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Designation/Post:</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="Designation"
								placeholder="Designation/Post:" pattern="[a-z A-Z]+"
								title="Please Enter Correct Designation/Post" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Details of Employment/Achievements in Chronological Order from
							the pressent one:</label>

						<div class="col-sm-9">
							<textarea class="col-xs-3" rows="5" id="" name="PresentStudies"
								placeholder="Details of Employment/Achievements in Chronological Order from
							the pressent one"></textarea>
						</div>
					</div>


					<div align="center">
						<h4>I hereby pay an amount of Rs.500/-in cash/DD towards the
							membership of Shirur Stcopians Alumni Association.</h4>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Date: </label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" value="${CurrentDate }"
								name="DateRegistration" placeholder="" readonly="true" required />
						</div>
					</div>
					<hr />


					<div class="form-group">
						<h4>For Office Use Only</h4>
						<label class="col-sm-3 control-label no-padding-right">
							Receipt No:
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="ReceiptNumber"
								placeholder="Receipt No:"  pattern="[0-9]+"
								title="Please Enter Correct Receipt Number" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Membership No:
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="MemberID"
								placeholder="Membership No:"  pattern="[0-9]+"
								title="Please Enter Correct Membership Number" />
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-3 control-label no-padding-right">
							<button name="RegisterAluminiD" id="" value="Submit"
								class="btn btn-big btn-success">Submit</button>
						</div>
					</div>
				</div>
			</div>

		</form>
	</div>
	<br>
	<br>
	<br>
</body>
</html>