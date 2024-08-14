<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Make Pay</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/autoCompleter.js"></script>
<link href="${pageContext.request.contextPath}/css/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
$(document).ready(function(){
	
	 $('#StudentName').autocomplete({
	   
		source : '${pageContext.request.contextPath}/searchStudentNew.html'
	}); 
	// debugger;
	 $("#StudentName").change(function(){
		// debugger;
		    var	StudentName = $("#StudentName").val();
		    document.getElementById("registrationID").readOnly = true;
		   // alert(StudentName);
	         //  $("#siteName").empty();
		    $.getJSON('getStudentDetails.html',{StudentName:StudentName}).done(function(data){
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
			$("#registrationID").val(data[0].admissionRegId);	
			//debugger;
			StudId=data[0].admissionRegId;
			//alert(StudId);
			standard=data[0].standard;
			//alert(standard)
			AcYear=data[0].acadamicYear;
			//alert(AcYear);
			Stream=data[0].streamName;
			//Branch Name
			Branch=data[0].branchName;
			
			
			$.getJSON('FetchDetailInfo.html',{StudId:StudId,standard:standard,AcYear:AcYear,Stream:Stream,Branch:Branch}).done(function(data){
				//alert("Welcome");
				assignData(data);
				
					 
			});
			
			$.getJSON('GetFeeDetailInfo.html',{StudId:StudId,standard:standard,AcYear:AcYear,Stream:Stream,Branch:Branch}).done(function(data){
				
				GetOtherFeeDetails(data);
				
					 
			});
			
			$.getJSON('GetRefundFeeDetailInfo.html',{StudId:StudId,standard:standard,AcYear:AcYear,Stream:Stream,Branch:Branch}).done(function(data){
				
				GetRefundFeeDetails(data);
				
					 
			});
				}
		    	
		});
	 });
	 
	 var assignData=function(data){
			
			var tableName = $("#studentFeesDetails tbody");
			//alert(data.length);
			       $("#studentFeesDetails tbody tr").remove();
			for(var i=0; i < data.length; i++)
			{
				//alert("id "+data[i].SubLedgerId);
				var row = $('<tr></tr>').appendTo(tableName);
				$('<td> <input type="text" id="Subleadger'+data[i].SubLedgerId+'" value='+data[i].subledger+' name="subledger'+[i]+'" readonly="true" /></td>').appendTo(row);
				$('<td> <input type="text" id="totalfee'+data[i].SubLedgerId+'"  value='+parseInt(data[i].fee)+' name="Fee'+[i]+'" readonly="true" /></td>').appendTo(row);
			}
			
			GetTotalFee(data);
		} 
		
		 var GetTotalFee=function(data){
			
			var total=0;
			
			for(var i=0;i<data.length;i++)
			{
				total +=parseInt(data[i].fee);	
			}

			$("#TotalFee").val(total);
			
			//GetOtherFeeDetails(data);
		} 
		 
		 var GetOtherFeeDetails=function(data)
			{
				
				var AlPaidFee;
				var PendFee;
				var paidFees;
				var totalFee;
				var allready;
				AlPaidFee=data[0].AlreadyPaidFees;
				PendFee=data[0].PendingFees;
			    paidFees=data[0].PaidFees;
				totalFee=data[0].totalFee;
				
				/* var studID=$("#registrationID").val();
				
				$.getJSON('getRefundamt.html',{studID:studID}).done(function(data){
					//alert("get refund");
					
					var lastRefund=data[0].refundamount;
					var rA=0;
				//	alert(lastRefund);
					if(data.length<0)
						{
							allready=AlPaidFee+paidFees;
							//alert(allready);
							$("#AlreadyPaidFee").val(allready);
							$("#AlreadyRefundPaidFee").val(rA);
						}
					else
						{
							allready=AlPaidFee+paidFees;
							//allready=allready-lastRefund;
							document.getElementById("DiscountMode").disabled=true;
							//alert(allready);
							$("#AlreadyPaidFee").val(allready);
							$("#AlreadyRefundPaidFee").val(lastRefund);
						}
				}); */
				allready=AlPaidFee+paidFees;
					
			//alert("allready............................"+allready);
			//alert("AlPAid Fee"+AlPaidFee);
			//alert("pending Fee ans"+PendFee);
			//alert("Paid"+paidFees);
			
			if (allready > 0.0){
				//alert(" Aj");
				document.getElementById("DiscountMode").disabled=true;
			}
			
			if (totalFee == allready ){
				alert("Student Fee Already Completed");
				//document.getElementById("PaidFee").disabled=true;
			}
				
			$("#AlreadyPaidFee").val(allready);
				$("#PendingFee").val(PendFee);
				$("#TotalFee").val(totalFee);
				$("#AlreadyPaidFee").val(allready);
				$("#PendingFee").val(PendFees);
				$("#TotalFee").val(totalFee);

				//hidefield(allready,totalFee,AlPaidFee);
				//alert("hdfk");

			}
			
			var GetRefundFeeDetails=function(data){
				
				var rAmt=0;
				if(data.length==0)
					{
					
						$("#RefoundAmount").val(rAmt);
					}
				else
					{
						
						rAmt=data[0].refundamount;
						//alert(rAmt);
						$("#RefoundAmount").val(rAmt);
					}
				
			}
			
		/* 	var hidefield=function(allready,totalFee,AlPaidFee){
				alert("abcd");
				/* if (allready > 0.0){
					alert(" Aj");
					document.getElementById("DiscountMode").disabled=true;
				}
				if (totalFee == AlPaidFee ){
					document.getElementById("PaidFee").disabled=true;
				} 
			} */
});
</script>
<script type="text/javascript">
$("#document").ready(function(){
	//alert("jbmv");
	
	
	$("#PaymentMode").change(function(){
		//alert("MOde");
		var mode=$("#PaymentMode").val();
		//alert("sfg"+mode);
		if(mode == "Cheque")
			{
			//alert("in mode");
			document.getElementById("transactionNumber").readOnly = false;
			document.getElementById("transactionDate").readOnly = false;
			document.getElementById("bankName").readOnly = false;
			}
		else if(mode == "NEFT")
			{
			document.getElementById("transactionNumber").readOnly = false;
			document.getElementById("transactionDate").readOnly = false;
			document.getElementById("bankName").readOnly = false;
			}
		else if(mode == "RTGS")
			{
			document.getElementById("transactionNumber").readOnly = false;
			document.getElementById("transactionDate").readOnly = false;
			document.getElementById("bankName").readOnly = false;
			}
		else
			{
			document.getElementById("transactionNumber").readOnly = true;
			document.getElementById("transactionDate").readOnly = true;
			document.getElementById("bankName").readOnly = true;
			document.getElementById("transactionNumber").value = "";
			document.getElementById("transactionDate").value = "";
			document.getElementById("bankName").value = "";
			}
			
	});
	
	$("#DiscountMode").change(function(){
		var DisMode=$("#DiscountMode").val();
		var TotalFees= $("#TotalFee").val();
		var TotalDis =$("#TotalDiscount").val();
	
		TotalFees= +TotalFees + +TotalDis;
		
		
		if(DisMode== "NoDiscount")
		{
			document.getElementById("DiscountReason").disabled=true;
			document.getElementById("OtherReson").readOnly = true;	
			document.getElementById("TotalDiscount").readOnly = true;
			$("#TotalFee").val(TotalFees);
		}
		else
		{
			document.getElementById("DiscountReason").disabled=false;
			document.getElementById("OtherReson").readOnly = false;
			document.getElementById("TotalDiscount").readOnly = false;
		}	
	});
	
	var standard;
	var AcYear;
	var StudId;
	var Branch;
	$("#registrationID").blur(function() {
		//alert("kasdg");
		var registrationID = $("#registrationID").val();
		//alert(registrationID);
		 document.getElementById("StudentName").readOnly = true;
		$.getJSON('FetchStudentInfo.html',{registrationID : registrationID}).done(function(data) {
		//alert("sjdg");
		//alert(data.length);
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
		standard=data[0].standard;
		//alert(standard)
		AcYear=data[0].acadamicYear;
		//alert(AcYear);
		Stream=data[0].streamName;
		//Branch Name
		Branch=data[0].branchName;
		
		
		$.getJSON('FetchDetailInfo.html',{StudId:StudId,standard:standard,AcYear:AcYear,Stream:Stream,Branch:Branch}).done(function(data){
			//alert("Welcome");
			assignData(data);
			
				 
		});
		
		$.getJSON('GetFeeDetailInfo.html',{StudId:StudId,standard:standard,AcYear:AcYear,Stream:Stream,Branch:Branch}).done(function(data){
			
			GetOtherFeeDetails(data);
			
				 
		});
		
		$.getJSON('GetRefundFeeDetailInfo.html',{StudId:StudId,standard:standard,AcYear:AcYear,Stream:Stream,Branch:Branch}).done(function(data){
			
			GetRefundFeeDetails(data);
			
				 
		});
			}
		
		
		});
		
	});
	 var assignData=function(data){
		
		var tableName = $("#studentFeesDetails tbody");
		//alert(data.length);
		       $("#studentFeesDetails tbody tr").remove();
		for(var i=0; i < data.length; i++)
		{
			//alert("id "+data[i].SubLedgerId);
			var row = $('<tr></tr>').appendTo(tableName);
			$('<td> <input type="text" id="Subleadger'+data[i].SubLedgerId+'" value='+data[i].subledger+' name="subledger'+[i]+'" readonly="true" /></td>').appendTo(row);
			$('<td> <input type="text" id="totalfee'+data[i].SubLedgerId+'"  value='+parseInt(data[i].fee)+' name="Fee'+[i]+'" readonly="true" /></td>').appendTo(row);
		}
		
		GetTotalFee(data);
	} 
	
	 var GetTotalFee=function(data){
		
		var total=0;
		
		for(var i=0;i<data.length;i++)
		{
			total +=parseInt(data[i].Fee);	
		}

		$("#TotalFee").val(total);
		
		//GetOtherFeeDetails(data);
	} 
	
	var GetOtherFeeDetails=function(data)
	{
		
		var AlPaidFee;
		var PendFee;
		var paidFees;
		var totalFee;
		var allready;
		AlPaidFee=data[0].AlreadyPaidFees;
		PendFee=data[0].PendingFees;
	    paidFees=data[0].PaidFees;
		totalFee=data[0].totalFee;
		
		/* var studID=$("#registrationID").val();
		
		$.getJSON('getRefundamt.html',{studID:studID}).done(function(data){
			//alert("get refund");
			
			var lastRefund=data[0].refundamount;
			var rA=0;
		//	alert(lastRefund);
			if(data.length<0)
				{
					allready=AlPaidFee+paidFees;
					//alert(allready);
					$("#AlreadyPaidFee").val(allready);
					$("#AlreadyRefundPaidFee").val(rA);
				}
			else
				{
					allready=AlPaidFee+paidFees;
					//allready=allready-lastRefund;
					document.getElementById("DiscountMode").disabled=true;
					//alert(allready);
					$("#AlreadyPaidFee").val(allready);
					$("#AlreadyRefundPaidFee").val(lastRefund);
				}
		}); */
		allready=AlPaidFee+paidFees;
			
	//alert("allready............................"+allready);
	//alert("AlPAid Fee"+AlPaidFee);
	//alert("pending Fee ans"+PendFee);
	//alert("Paid"+paidFees);
	
	if (allready > 0.0){
		//alert(" Aj");
		document.getElementById("DiscountMode").disabled=true;
	}
	
	if (totalFee == allready ){
		alert("Student Fee Already Completed");
		//document.getElementById("PaidFee").disabled=true;
	}
		
	$("#AlreadyPaidFee").val(allready);
		$("#PendingFee").val(PendFee);
		$("#TotalFee").val(totalFee);
		$("#AlreadyPaidFee").val(allready);
		$("#PendingFee").val(PendFees);
		$("#TotalFee").val(totalFee);

		//hidefield(allready,totalFee,AlPaidFee);
		//alert("hdfk");

	}
	
	var GetRefundFeeDetails=function(data){
		
		var rAmt=0;
		if(data.length==0)
			{
			
				$("#RefoundAmount").val(rAmt);
			}
		else
			{
				
				rAmt=data[0].refundamount;
				//alert(rAmt);
				$("#RefoundAmount").val(rAmt);
			}
		
	}
	
/* 	var hidefield=function(allready,totalFee,AlPaidFee){
		alert("abcd");
		/* if (allready > 0.0){
			alert(" Aj");
			document.getElementById("DiscountMode").disabled=true;
		}
		if (totalFee == AlPaidFee ){
			document.getElementById("PaidFee").disabled=true;
		} 
	} */
	
	
	 $("#TotalDiscount").blur(function(){
		//alert("Total Di");
		var TotalFees= $("#TotalFee").val();
		//alert("TotalFees"+TotalFees);
		var TotalDis =$("#TotalDiscount").val();
		//alert(TotalDis);
		if( +TotalFees < +TotalDis)
			{
			//alert("add");
			alert("Scholership Amount Should Not Be Greater Than Total Fees..");
			$("#makePayment").hide();
			location.reload();
			}
		else
			{
			//alert("Else part");
			TotalFees=TotalFees-TotalDis;
			$("#TotalFee").val(TotalFees);
			}
		
		
	});
	 
	 $("#PaidFee").blur(function(){
		
		//alert("Calculate Fee");
		var TotalFees= $("#TotalFee").val();
		var AlreadyPaidFees= $("#AlreadyPaidFee").val();
		var PaidFees = $("#PaidFee").val();
		var PendingFees=0;
		var valu=0;
		if(AlreadyPaidFees==0)
			{
				PendingFees=TotalFees-PaidFees;
				if(PendingFees<0)
					{
					alert("Plese Enter Correct Amount");
					}
				else
					{
					$("#PendingFee").val(PendingFees.toFixed(2));
					$("#RefoundAmount").val(valu);
					}
				
			}
		else
			{
				//alert("Calcuate FEe In ");
			var tempval =	TotalFees-AlreadyPaidFees;
			//alert(""+tempval);
				PendingFees = tempval-PaidFees;//AlreadyPaidFees-PaidFees;
				
				if(PendingFees<0)
				{
					alert("Exceed Amount will Have To Be Refund..");
					//alert("Already Paid Fee"+AlreadyPaidFees);
					//alert("Paid Fee"+PaidFees);
					var newAmt=+AlreadyPaidFees + +PaidFees;
				//	alert("Total:"+newAmt);
					var refoundAmt=0;
					var value=0;
					var r=$("#RefoundAmount").val();
					//var alRAmt=$("#AlreadyRefundPaidFee").val();
					if(newAmt>TotalFees)
						{
							if(r==0)
								{
									refoundAmt=newAmt-TotalFees;
									//refoundAmt=refoundAmt-alRAmt;
									$("#PendingFee").val(value);
									$("#RefoundAmount").val(refoundAmt);
								}
							else
								{
									refoundAmt=+r + +PaidFees;
									$("#RefoundAmount").val(refoundAmt);
								}
						}
				}
				else
				{
					$("#PendingFee").val(PendingFees);
					$("#RefoundAmount").val(valu);
				}
				
			}
		
	});
	
	$("#BankID").change(function(){
		 //alert("sss");
		var Bankid=$("#BankID").val();
		$("#AccountNumber").find("option").remove("#dynamic");
		//alert("List Found");
		$.getJSON('GetAccountNumberJson.html',{Bankid:Bankid}).done(function(data){	
			//alert(data[0].branchId);
			for (var i = 0; i<data.length; i++) {
				//alert("sss");
				$("#AccountNumber").append("<option id='dynamic'  value='"+data[i].bankId+"'>"+data[i].accuntNumber+"</option>");
				//html += "<option value='"+data[i].branchId+"' id='dynamic'>"
						//+ data[i].branchName + "</option>";
			}
		});
	});
	
	$("#DiscountReason").change(function(){
	
		var disR=$("#DiscountReason").val();
		//alert("djhfj");
		
		if(disR=='ScholarShip' || disR=='Cast')
			{
				document.getElementById("OtherReson").disabled=true;
			}
		else
			{
				document.getElementById("OtherReson").disabled=false;
			}
	});
	
	 $("#makePayment").click(function() {
		 /* if($("#BankID").val()==0)
			{
				alert("Please Select Bank");
			} */ 
		//alert("Payment Submited...");
		//location.href = "PayMakePayment.html";
	}); 
	 
	 
	 
	/*  $("#makePaymentForm").validate({
			debug : true,
			rules : {
				"BankID" :{required:true},
				"PaymentMode":{required:true},
				
			},
			messages : {
				"BankID" :{required:"Please Select Bank "},
				"PaymentMode":{required:"Select Payment Mode"},
							},
			submitHandler : function(form) {
				form.submit();
			}
		}); 
	  */
	
});

</script>
</head>
<body>
	<div class="page-content">
		<form action="MakePaymentSave.html" method="post" id="makePaymentForm"
			class="form-horizontal" target="_blank">
			<div class="page-header center">
				<h1><b>Make Payment</b></h1>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table">
									<thead>
								<tr>
									<th>Approved Registration Id<span style="color: red;">*</span></th>
									<th>Student Name<span style="color: red;">*</span></th>
									<th>Standard</th>
									<th>Admission Date</th>
									<th>Academic Year</th>
								</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" name="registrationID" value="${StudentID}"
											id="registrationID" placeholder="Admission Registration Id"
											required pattern="[0-9]+"
											title="Please Enter Correct Registration ID" ></td>
										<td><input type="text" name="StudentName"
											id="StudentName" placeholder="Student Name" required ></td>
										<td><input type="hidden" name="StandIDStud"
											id="StandIDStud"> <input type="text" name="Standard"
											id="Standard" placeholder="Standard" readonly="true">
											<input type="hidden" name="StreamIDStud" id="StreamIDStud">
											<input type="hidden" name="AcademicYearIDStud"
											id="AcademicYearIDStud"> <input type="hidden"
											name="BranchIDStud" id="BranchIDStud"></td>
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
									<th>Receipt Number</th>
									<th>Current Date</th>
									<th>Bank Name<span style="color: red;">*</span></th>
									<th>Account Number<span style="color: red;">*</span></th>
								</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" name="ReceiptNumber"
											value="${ReceiptNumber }" readonly="true"></td>
										<td><input type="text" name="CurrentDate"
											value="${currentdate }" readonly="true"></td>
										<td><select class="span-sm9" name="BankID" id="BankID"
											required>
												<option value="">------Select Bank Name-------</option>
												<c:forEach var="v" items="${BankList}">
													<option value="${v.key}">${v.value}</option>
												</c:forEach>
										</select></td>
										<td><select class="span-sm9" name="AccountNumber"
											id="AccountNumber" required>
												<option id="dynamic" value="">------Select Account
													Number-------</option>
										</select></td>
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
<hr/>
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table">

								<thead> 
								<tr>
									<th>Discount<span style="color: red;">*</span></th>
									<th>Reason</th>
									<th>Other</th>
									<th>Total Discount</th>
								</tr>
								</thead>
								<tbody>
									<tr>
										<td><select class="" name="DiscountMode"
											id="DiscountMode" required>
												<option value="">------Select Discount Mode-------</option>
												<option value="Discount">Discount</option>
												<option value="NoDiscount">No Discount</option>
										</select></td>
										<td><select class="" name="DiscountReason"
											id="DiscountReason" disabled=true>
												<option value="">------Select Discount
													Reason-------</option>
												<option value="ScholarShip">ScholarShip</option>
												<option value="Cast">Cast</option>
												<option value="other">other</option>
										</select></td>
										<td><input type="text" name="OtherReson" id="OtherReson"
											readonly="true" pattern="[a-z A-Z]+" title="Please Enter Correct Other Resion"
											></td>
										<td><input type="text" class="totaldiscount"
											name="TotalDiscount" id="TotalDiscount" readonly="true"
											pattern="[0-9]+" title="Please Enter Correct Total Discount "></td>

									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
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
									<th>Already Paid Fee</th>
									<!-- <th>Already Refund Fee</th> -->
									<th>Paying Fee<span style="color: red;">*</span></th>
									<th>Pending Fee</th>
								</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" name="TotalFee" id="TotalFee"
											readonly="true" placeholder="Admission Total Fee"></td>
										<td><input type="text" name="AlreadyPaidFee" value="0.0"
											readonly="true" id="AlreadyPaidFee"
											placeholder="Already Paid Fee"></td>
										<!-- <td><input type="text" name="AlreadyRefundPaidFee" value="0.0"
											readonly="true" id="AlreadyRefundPaidFee"
											placeholder="Already Refund Fee"></td>
										 --><td><input type="text" name="PaidFee" id="PaidFee"
											required pattern="[0-9]+"
											title="Please Enter Correct Paid Amount"></td>
										<td><input type="text" name="PendingFee" id="PendingFee"
											readonly="true" value="0.0" placeholder="Pending Fee"></td>
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
									<th>Refund Amount</th>
								</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" name="RefoundAmount" id="RefoundAmount"
											readonly="true" placeholder="Refund Amount"></td>
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

								<!-- <thead>  -->
								<thead><tr>
									<th>Payment Mode<span style="color: red;">*</span></th>
									<th>Transaction/Cheque No/UID No</th>
									<th>Transaction Date</th>
									<th>Bank Name</th>
								</tr><thead>
								<!-- </thead> -->
								<tbody>
									<tr>
										<td><select class="" name="PaymentMode" id="PaymentMode"
											required>
												<option value="">------Select Payment Mode-------</option>
												<option value="Cash">Cash</option>
												<option value="Cheque">Cheque</option>
												<option value="NEFT">NEFT</option>
												<option value="RTGS">RTGS</option>
										</select></td>
										<td><input type="text" name="transactionNumber"
											class="transactionDetail" id="transactionNumber" value=""
											readonly="true"  pattern="[0-9]+" title="Please Enter Correct Transaction/Cheque No"></td>
										<td><input type="date" name="transactionDate"
											class="transactionDetail" id="transactionDate"
											value="${currentdate }" readonly="true"></td>
										<td><input type="text" name="bankName"
											class="transactionDetail" id="bankName" value=""
											readonly="true"
											pattern="[a-z A-Z]+" title="Please Enter Correct Bank Name"
											></td>

									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
<hr/>
			<center>
				<button name="makePayment" id="makePayment" type="submit"
					value="makePayment" class="btn btn-big btn-success">Make
					Payment</button>
			</center>
		</form>
	</div>
	<br>
	<br>
	<br>
</body>
</html>