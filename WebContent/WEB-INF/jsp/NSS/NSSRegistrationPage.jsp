<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//alert("Ready");
						$("#StreamID")
								.change(
										function() {
											//alert("Branch");
											var id = $("#StreamID").val();
											$("#branchName").empty();
											$("#StandardData").empty();
											$("#branchName")
													.append(
															"<option>"
																	+ "--Select Branch Name--"
																	+ "</option>");
											$
													.getJSON(
															'GetBranchListJsonNSS.html',
															{
																id : id
															})
													.done(
															function(data) {//alert(data[0].branchId);
																for (var i = 0; i < data.length; i++) {
																	//alert("sss");
																	$(
																			"#branchName")
																			.append(
																					"<option id='dynamic' value='"+data[i].branchId+"'>"
																							+ data[i].branchName
																							+ "</option>");
																}
															});
										});

						$("#branchName")
								.change(
										function() {
											//alert("Standard");
											var branchid = $("#branchName")
													.val();
											$("#StandardData").empty();
											$("#standardName").empty();
											$("#standardName")
													.append(
															"<option>"
																	+ "--Select Standard Name--"
																	+ "</option>");

											$
													.getJSON(
															'GetStandardListJSONNSS.html',
															{
																branchid : branchid
															})
													.done(
															function(data) {
																//alert(data[0].branchId);

																for (var i = 0; i < data.length; i++) {
																	//alert("sss");

																	$(
																			"#standardName")
																			.append(
																					"<option id='dynamicStd' value='"+data[i].standardId+"'>"
																							+ data[i].standard
																							+ "</option>");
																}
															});
										});

						$("#CalculatePercent").blur(function() {
							//alert("Calculate Percentage ");
							var ObtainMark = $("#StudMark").val();
							var OutOff = $("#CalculatePercent").val();

							var percent = (+ObtainMark / +OutOff) * 100;

							//alert("Percent"+percent);

							$("#Percentage").val(percent);

						});
					});
</script>
</head>
<body>
	<div class="page-content">
		<div class="page-header center">
			<h1>Application Form For NSS Volunteer</h1>
		</div>
		<form action="SaveNssStudentForm.html" action="post" commandName=""
			class="form-horizontal">
			<div class="row">
				<div class="col-xs-12">

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Student Name: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="StudName"
								path="StudName" placeholder="StudentName" required
								pattern="[a-z A-Z]+" title="Please Enter Correct Student Name" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Student Address: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="StudAddress"
								path="StudAddress" placeholder="StudentAddress" required
								pattern="[a-z A-Z 0-9._%+-]+"
								title="Please Enter Correct Address" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Phone No: </label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="PhoneNumber"
								path="PhoneNumber" placeholder="PhoneNumber" type="text" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Mobile No: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="MobileNumber"
								path="MobileNumber" placeholder="mobileNumber" maxlength="10"
								required pattern="[789][0-9]{9}"
								title="Please Enter Correct Mobile Number" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Email Address: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input class="col-xs-3" name="StudMail" path="StudMail"
								placeholder="Email" type="email" required
								pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Student Category: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="StudCategory"
								path="StudCategory" placeholder="Category" required
								pattern="[a-z A-Z]+" title="Please Enter Correct Category" />
						</div>
					</div>
					<hr />
					<div align="center">
						<h4>DETAILS OF PREVIOUS EXAMINATION PASSED</h4>
					</div>
					<hr />
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Academic Year:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<select class="col-xs-3" name="YearID" id="YearID" required>
								<option value="">------Select Year-------</option>
								<c:forEach var="v" items="${YearList}">
									<option value="${v.key}">${v.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Stream Name: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<select class="col-xs-3" name="StreamID" id="StreamID" required>
								<option value="">------Select Stream Name-------</option>
								<c:forEach var="v" items="${StreamList}">
									<option value="${v.key}">${v.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Branch Name:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<select class="col-xs-3" name="branchID" id="branchName" required>
								<option id="dynamic" value="0">------Select Branch
									Name-------</option>

							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Standard Name:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<select class="col-xs-3" name="standardID" id="standardName"
								required>
								<option id="dynamicStd" value="0">------Select Standard
									Name-------</option>

							</select>
						</div>
					</div>
					<div class="form-group">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<b>Detail of previous examination passed.</b>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Marks Obtained:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" id="StudMark" name="StudMark"
								path="StudMark" placeholder="" required pattern="[0-9]+"
								title="Please Enter Correct Mark" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							out of:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="StudMarkOutOff"
								path="StudMarkOutOff" id="CalculatePercent" placeholder=""
								required pattern="[0-9]+"
								title="Please Enter Correct Out Of Mark" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Percentage </label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="StudPercent"
								id="Percentage" path="StudPercent" placeholder="%"
								readonly="true" />
							<h6>%</h6>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							PCM:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="StudMarkPCM"
								path="StudMarkPCM" id="" placeholder="12th MHT-CET PCM Marks"
								required pattern="[0-9]+" title="Please Enter Correct PCM Mark" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							PCB:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="StudMarkPCB"
								path="StudMarkPCB" id="" placeholder="12th MHT-CET PCB Marks"
								required pattern="[0-9]+" title="Please Enter Correct PCB Mark" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							PCMB:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="StudMarkPCMB"
								path="StudMarkPCMB" id="" placeholder="12th MHT-CET PCMB Marks"
								required pattern="[0-9]+" title="Please Enter Correct PCMB Mark" />
						</div>
					</div>


					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Date: </label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" value="${curentdate }"
								path="ApplicaionDate" placeholder="" name="ApplicaionDate"
								readonly="true" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Place: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<input type="text" class="col-xs-3" name="StudPlace"
								path="StudPlace" placeholder="" required pattern="[a-z A-Z]+"
								title="Please Enter Correct Place" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-3 control-label no-padding-right">
							<button name="RegistersNSS" id="" value="Submit"
								class="btn btn-big btn-success">Save</button>
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