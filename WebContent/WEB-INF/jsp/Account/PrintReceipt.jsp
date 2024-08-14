<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Print Receipt</title>
<script type="text/javascript">
$("#document").ready(function(){
	//alert("Print Receipt");
	var ledgerCount;
	$("#registrationID").blur(function(){
		//alert("Student List");
		var StudID=$("#registrationID").val();
		//alert(StudID);
		
		$.getJSON('GetStudentInformation.html',{StudID:StudID}).done(function(data){
			//alert("In Information");
			if(data.length==0)
			{
			alert("Student Addmission Is Not Approved/Student ID IS Not Present");
			}
		else
			{
		$("#StudentName").val(data[0].studentFirstName+ ' '+ data[0].studentMiddleName+ ' '+ data[0].studentLastName);
		$("#StandIDStud").val(data[0].standardId);
		$("#Standard").val(data[0].standard);
		$("#StreamIDStud").val(data[0].streamId);
		$("#AcademicYearIDStud").val(data[0].acadamicYearId);
		$("#BranchIDStud").val(data[0].branchId);
		$("#AdmissionDate").val(data[0].admissionDate);
		$("#AcadimicYear").val(data[0].acadamicYear);
				
		StudId=data[0].admissionRegId;
		//alert(StudId);
		standard=data[0].standardId;
		//alert(standard)
		AcYear=data[0].acadamicYearId;
		//alert(AcYear);
		Stream=data[0].streamId;
		//alert(Stream)
		Branch=data[0].branchId;
		//alert(Branch);
		
		
		$.getJSON('getLedgerDetails.html',{StudId:StudId,standard:standard,AcYear:AcYear,Stream:Stream,Branch:Branch}).done(function(data){
			//alert("Welcome");
			assignData(data);
				 
		});
		$.getJSON('getFeePaidDetails.html',{StudId:StudId,standard:standard,AcYear:AcYear,Stream:Stream,Branch:Branch}).done(function(data){
			//alert(data);
			fetchTransactionDetails(data);
			
		});
	}
	});
		
	});
	 var assignData=function(data){
			var tableName = $("#studentFeesDetails tbody");
			//alert(data.length);
			
			for(var i=0; i < data.length; i++)
			{
				//alert("id "+data[i].SubLedgerId);
				var row = $('<tr></tr>').appendTo(tableName);
				$('<td> <input type="text" id="Subleadger'+data[i].SubLedgerId+'" value='+data[i].subledger+' name="subledger'+[i]+'" readonly="true" /></td>').appendTo(row);
				$('<td> <input type="text" id="totalfee'+data[i].SubLedgerId+'"  value='+data[i].Fee+' name="Fee'+[i]+'" readonly="true" /></td>').appendTo(row);
			}
			
			//GetTotalFee(data);
		} 
	var fetchTransactionDetails=function(data){
		//alert("Transaction");
		for(var i=0;i<data.length;i++)
			{
				$("#AlreadyPaidFee").val(data[i].AlreadyPaidFees);
				$("#PaidFee").val(data[i].PaidFees);
				$("#PendingFee").val(data[i].PendingFees);
				$("#TotalFee").val(data[i].totalFee);
				$("#PaymentModel").val(data[i].paymentMode);
				$("#ReceiptDate").val(data[i].receiptDate);
				$("#ReceiptNumber").val(data[i].receiptNo);
				$("#transactionDate").val(data[i].transactionDate);
				$("#bankName").val(data[i].bankName);
				$("#TotalDiscount").val(data[i].Discount);
				$("#transactionNumber").val(data[i].transactionNumber);
			}
	}
});
</script>
</head>
<body>
	<div class="page-content">

		<div class="page-header center">
			<h1><b>Payment Print Receipt</b></h1>
		</div>
		<form action="PrintStudentReceipt.html" method="post"
			class="form-horizontal" target="_blank">
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table">
									<thead>
								<tr>
									<th>Approved Registration Id<span style="color:red;">*</span></th>
									<th>Student Name</th>
									<th>Standard</th>
									<th>Admission Date</th>
									<th>Academic Year</th>
								</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" name="registrationID" value=""
											id="registrationID" placeholder="Admission Registration Id"
											required pattern="[0-9]+" title="Please Enter Correct Registration ID" ></td>
										<td><input type="text" value="" name="StudentName"
											id="StudentName" placeholder="Student Name" readonly="true"></td>
										<td><input type="text" value="" name="Standard"
											id="Standard" placeholder="Standard" readonly="true">
											
											<input type="hidden" name="StandIDStud" id="StandIDStud">
											<input type="hidden" name="StreamIDStud" id="StreamIDStud"> 
											<input type="hidden" name="AcademicYearIDStud" id="AcademicYearIDStud">
											<input type="hidden" name="BranchIDStud" id="BranchIDStud">
											
										</td>
										<td><input type="text" value="" name="AdmissionDate"
											id="AdmissionDate" placeholder="Admission Date"
											readonly="true"></td>
										<td><input type="text" value="" name="AcadimicYear"
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


			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table">
									<thead>
								<tr>
									<th>Receipt Number</th>
									<th>Admission Date</th>
								</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" name="ReceiptNumber" value=""
											id="ReceiptNumber" placeholder="Receipt Number"
											readonly="true"></td>
										<td><input type="text" name="CurrentDate"
											id="ReceiptDate" placeholder="Admission Date" readonly="true"></td>
									</tr>
								</tbody>

							</table>
						</div>
					</div>
				</div>
				<!-- /.span -->
			</div>
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="studentFeesDetails" class="table table-bordered">
								<thead>
									<tr>
										<th>Ledger Name</th>
										<th>Total Fee</th>
									</tr>
								</thead>
								<tbody>

								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /.span -->
			</div>

			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table">

								<thead> 
								<tr>
									<th>Total Discount</th>
								</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" value="" class="totaldiscount"
											name="TotalDiscount" placeholder="Total Discount"
											id="TotalDiscount" readonly="true"></td>

									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>


			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table">
									<thead>
								<tr>
									<th>Total Fee</th>
									<th>Already Paid Fee</th>
									<th>Paid Fee</th>
									<th>Pending Fee</th>
								</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" value="" name="TotalFee"
											id="TotalFee" readonly="true"
											placeholder="Admission Total Fee"></td>
										<td><input type="text" value="" name="AlreadyPaidFee"
											value="0.0" readonly="true" id="AlreadyPaidFee"
											placeholder="Already Paid Fee"></td>
										<td><input type="text" value="" name="PaidFee"
											readonly="true" placeholder="Paid Fee" id="PaidFee"></td>
										<td><input type="text" value="" name="PendingFee"
											id="PendingFee" readonly="true" value="0.0"
											placeholder="Pending Fee"></td>
									</tr>
								</tbody>

							</table>
						</div>
					</div>
				</div>
				<!-- /.span -->
			</div>
			<hr>

			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table">

								<thead> 
								<tr>
									<th>Payment Mode</th>
									<th>Transaction/Cheque No</th>
									<th>Transaction Date</th>
									<th>Bank Name</th>
								</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" value="" name="PaymentModel"
											id="PaymentModel" placeholder="Payment Mode" readonly="true"></td>
										<td><input type="text" value="" name="transactionNumber"
											placeholder="Transaction Number" id="transactionNumber"
											value="" readonly="true"></td>
										<td><input type="text" value="" name="transactionDate"
											placeholder="Transaction Date" id="transactionDate"
											readonly="true"></td>
										<td><input type="text" value="" name="bankName"
											id="bankName" value="" placeholder="Bank Name"
											readonly="true"></td>

									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>

			<center>
				<button name="PrintReceipt" id="PrintReceipt" type="submit"
					value="PrintReceipt" class="btn btn-big btn-success">
					Print Receipt</button>
			</center>
		</form>
	</div>
	<br>
	<br>
	<br>
</body>
</html>