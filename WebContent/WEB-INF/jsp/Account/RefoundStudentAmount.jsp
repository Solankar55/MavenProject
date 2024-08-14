<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/autoCompleter.js"></script>
<link href="${pageContext.request.contextPath}/css/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
$("#document").ready(function(){
	
	 $('#StudentName').autocomplete({
		   
			source : '${pageContext.request.contextPath}/searchStudentNew.html'
		});
	
	$("#StudentName").blur(function() {
		//alert("kasdg");
		var StudentName = $("#StudentName").val();
		//alert(registrationID);
		
		$.getJSON('getStudentRefoundDate.html',{StudentName : StudentName}).done(function(data) {
		//alert("In Data");
		if(data.length==0)
		{
		alert("Student Has No Rerfund Amount/Alredy Refounded.");
		}
	else
		{
		$("#refundID").val(data[0].refundid);
		$("#RefoundAmount").val(data[0].refundamount);
		//$("#StudentName").val(data[0].studentFirstName+' '+ data[0].studentLastName);
		//$("#StudentName").val(data[0].studentnamessc);
		$("#AdmissionDate").val(data[0].admissionDate);
		$("#AcadimicYear").val(data[0].acadamicYear);
		$("#Standard").val(data[0].standard);
		$("#PaidFee").val(data[0].PaidFees);
		$("#TotalFee").val(data[0].totalFee); 
		}
		});
	});
});
</script>
</head>
<body>
	<div class="page-content">
		<form action="SubmitStudentRefundAmount.html" method="post" id=""
			class="form-horizontal" target="_blank">
			<div class="page-header center">
				<h1><b>Refund Student Amount</b></h1>
				<h3>${MessageRefundAmt}</h3>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table">
									<thead>
								<tr>
									<!-- <th>Approved Registration Id<span style="color: red;">*</span></th> -->
									<th>Student Name <span style="color: red;">*</span></th>
									<th>Standard</th>
									<th>Admission Date</th>
									<th>Academic Year</th>
								</tr>
								</thead>
								<tbody>
									<tr>
										<!-- <td><input type="text" name="registrationID" value=""
											id="registrationID" placeholder="Admission Registration Id"
											required pattern="[0-9]+"
											title="Please Enter Correct Registration ID"></td> -->
										<td><input type="text" name="StudentName"
											id="StudentName" placeholder="Student Name" required pattern="[a-z A-Z]+"
											title="Please Enter Correct Student Name"></td>
										<td><input type="text" name="Standard"
											id="Standard" placeholder="Standard" readonly="true">
										<td><input type="text" name="AdmissionDate"
											id="AdmissionDate" placeholder="Admission Date"
											readonly="true"></td>
										<td><input type="text" name="AcadimicYear"
											id="AcadimicYear" placeholder="Acadimic Year" readonly="true" />
										</td>
									</tr>
								</tbody>

							</table>
						</div>
					</div>
				</div>
				<!-- /.span -->
			</div>
			<hr/>
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table">
									<thead>
								<tr>
									<th>Total Fee</th>
									<th>Paid Fee</th>
									<th>Refund Fee</th>
								</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" name="TotalFee" id="TotalFee"
											readonly="true" placeholder="Admission Total Fee"></td>
										<td><input type="text" name="PaidFee" id="PaidFee"
											 readonly="true"
											placeholder="Paid Amount"></td>
										<td style="display: none;"><input type="text" name="refundID" id="refundID"
											readonly="true" placeholder="Refound Amount ID"></td>
										<td><input type="text" name="RefoundAmount" id="RefoundAmount"
											readonly="true" placeholder="Refound Amount"></td>
									</tr>
								</tbody>

							</table>
						</div>
					</div>
				</div>
				<!-- /.span -->
			</div>
			<hr/>
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table">
									<thead>
								<tr>
									<th>Bank Name<span
										style="color: red;">*</span></th>
									<th>Branch Name<span
										style="color: red;">*</span></th>
									<th>IFSC Code<span
										style="color: red;">*</span></th>
									<th>Cheque Number<span
										style="color: red;">*</span></th>
									<th>Cheque Date<span
										style="color: red;">*</span></th>
								</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" name="BankName" id=""
											 placeholder="Bank Name"
											 required pattern="[a-z A-Z]+" title="Please Enter Correct Bank Name"></td>
										<td><input type="text" name="BranchName" value=""
											 id="" placeholder="Branch Name"
											 required pattern="[a-z A-Z]+" title="Please Enter Correct Branch Name"></td>
										<td><input type="text" name="IFSCCode" value=""
											 id="" placeholder="IFSC Code"
											 required pattern="[A-Z]{4}[0-9]{7}" title="Please Enter Correct IFSC Code"></td> 
										<td><input type="text" name="CheckNumber" id=""
											 placeholder="Cheque Number" required ></td>
										<td><input type="date" name="CheckDate" id=""
											 placeholder="Cheque Date" required></td>
									</tr>
								</tbody>

							</table>
						</div>
					</div>
				</div>
				<!-- /.span -->
			</div>
			<hr/>
			<center>
				<button name="" id="" type="submit"
					value="" class="btn btn-big btn-success">Refund Amount</button>
			</center>
		</form>
	</div>
	<br><br><br>
</body>
</html>