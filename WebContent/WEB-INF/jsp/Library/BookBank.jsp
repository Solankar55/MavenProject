<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	
	
	
$("#bookId").blur(function(){
	
	var bookId=$("#bookId").val();
	$.getJSON('getMessageBookId.html',{bookId:bookId}).done(function(data){
		
		
	$("#id1").text(data.msg);
	})
	
	});

	$("#studDetailButton").click(function(){
	//	alert("hellooo");
		var studentId=$("#studentId").val();
		//alert("studName" +studentId);
		
		/* var contactNum=$("#studContactNo").val();
		alert("contactNum" +contactNum); */
		
		 $.getJSON('getStudentDetail.html',{studentId:studentId}).done(function(data){
			
			 if(data.length==0)
				 {
				 	alert("Student Admission is Not yet Approved or Student Admission is Cancelled..");
				 	document.getElementById('IssueReturnBookBtn').disabled=true;
				 }
			 else{ 
			 for (var i=0;i<data.length;i++)
				{
				
				/* $("#ThirdTable").append("<tr><td>"+data[i].StudId+"</td><td>"+data[i].studentFirstName+""+data[i].studentLastName+"</td><td>"+data[i].acadamicYear+"</td><td>"+data[i].streamName+"</td><td>"+data[i].branchName+"</td><td>"+ data[i].standard +"</td><td>"+data[i].studentCategory+"</td><td>"+data[i].studentContactNumber+"</td></tr>"); */
				$("#studIdTable").val(data[i].StudId);
				$("#studentNameTable").val(data[i].studentFirstName);
				$("#AcadamicYrTable").val(data[i].acadamicYear);
				$("#streamNameTable").val(data[i].streamName);
				$("#branchNameTable").val(data[i].branchName);
				$("#standardNameTable").val(data[i].standard);
				$("#studentCatagoryTable").val(data[i].studentCategory);
				$("#studentBarcodeTable").val(data[i].studentBarcode);
				$("#readerId").val(data[i].studentBarcode);
			}
		 }
			var catagory=	$("#studentCatagoryTable").val();
			//alert("catagory" +catagory);
			
			if(catagory =="Open" || catagory == "OBC")
				{
					//alert("we are in IF");	
					
					//$("#IssueReturnDiv").hide();
				}	
		
			}); 
	  
			
	});	/* $("#studContactNo").blur(function(){	 */
	 $("#getRecordsButton").click(function(){ 
	//alert("Hii");
	
	 var bookAccId=$("#bookId").val();
	var studbarcode=$("#readerId").val();
	$("#barcodeStudent").val(studbarcode);
	//alert("bookId" +bookAccId + "studbarcodeId" +studbarcode);
	 $.getJSON('getStudentBookBank.html',{studbarcode:studbarcode}).done(function(data){
			for (var i=0;i<data.length;i++)
				{
				 $("#studBookBankRecords").append("<tr><td>"+data[i].StudId+"</td><td>"+data[i].acadamicYear+"</td><td>"+data[i].studentAcYearId+"</td><td>"+data[i].bookAccessionId+"</td><td>"+data[i].bkIssueDate+"</td><td>"+ data[i].bkReturnDate +"</td><td>"+data[i].IssuedBookStatus+"</td><td>"+data[i].Fine+"</td></tr>"); 
				 
				 $("#totalTransaction").val(data[i].totalTransaction);
				}
			
	}); 
	
	});
});
</script>
<style>
* {
	margin: 0;
	padding: 0;
}

body {
	font-family: "Open Sans";
	font-size: 14px;
}

.container {
	width: 100px;
	margin: 10px;
}

/* form {
  padding: 40px;
  background: 	#4682B4;
  color: #fff;
  -moz-border-radius: 0.5px;
  -webkit-border-radius: 0.5px;
  border-radius: 0.5px;
}  */
form label {
	border: 0;
	margin-bottom: 3px;
	display: block;
	width: 100%;
}
/* form input {
  height: 25px;
  line-height: 25px;
  background: #fff;
  color: #000;
  padding: 0 6px;
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
} */
form button {
	height: 30px;
	line-height: 30px;
	background: #e67e22;
	color: #fff;
	margin-top: 10px;
	cursor: pointer;
}

form .error {
	color: #ff0000;
}
</style>

</head>
<body>
	<div id="page-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-lg-12">
					<div class="page-title">
						<h1>Book Bank For Category Student</h1>
						<!-- <ol class="breadcrumb">
							<li>
							</li>
						</ol> -->
					</div>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<!-- end PAGE TITLE ROW -->

			<!-- begin MAIN PAGE ROW -->
			<div class="row">

				<!-- begin LEFT COLUMN -->
				<div class="col-lg-4">

					<div class="row">

						<!-- Basic Form Example -->
						<div class="col-lg-12">

							<div class="portlet portlet-default">
								<div class="portlet-heading">
									<div class="portlet-title">
										<h4>Student Details</h4>
									</div>
									<div class="portlet-widgets">
										<a data-toggle="collapse" data-parent="#accordion"
											href="#basicFormExample"><i class="fa fa-chevron-down"></i></a>
									</div>
									<div class="clearfix"></div>
								</div>
								<div id="basicFormExample" class="panel-collapse collapse in">
									<div class="portlet-body">


										<form class="form-inline" action="GetDetails.html">

											<div class="form-group">
												<label>Student Registration Id</label><input
													style="width: 180px; height: 35px; margin: 0; padding: 0;"
													type="text" class="form-control" id="studentId"
													placeholder="Enter Student ID" name="studentName">
											</div>

										<!-- 	<div class="form-group">
												<label for="StaffRegistrationId">Student Contact No
													Id</label> <input
													style="width: 180px; height: 35px; margin: 0; padding: 0;"
													type="text" class="form-control" id="studContactNo"
													placeholder="Studen Contact No" name="studentContactNum">
											</div> -->
											
											<br>

	
											<div class="col-md-12"></div>
											<div class="col-md-12"></div>
											<div class="col-md-12"></div>
											<div class="col-md-12"></div>
											<div class="col-md-12"></div>
											<div class="col-md-12"></div>

											<input type="button" class="btn btn-default"
												value="Get Details" id="studDetailButton">

										</form>
									</div>
								</div>
							</div>
							<!-- /.portlet -->
						</div>
					</div>
				</div>

				<div class="col-lg-8">
					<table class="table table-condensed">
						<tr>
							<td>
								<div class="form-group">
									<label>Student Registration Id</label><input
										style="width: 180px; height: 35px; margin: 0; padding: 0;"
										type="text" class="form-control" id="studIdTable"
										placeholder="Student Reg Id" name="studIdTable" readOnly>
								</div>
							</td>
							<td><div class="form-group">
									<label>Student Name</label><input
										style="width: 180px; height: 35px; margin: 0; padding: 0;"
										type="text" class="form-control" id="studentNameTable"
										placeholder="Enter Student Name" name="studentName" readOnly>
								</div></td>
							<td><div class="form-group">
									<label>Acadamic Yr</label><input
										style="width: 180px; height: 35px; margin: 0; padding: 0;"
										type="text" class="form-control" id="AcadamicYrTable"
										placeholder="Enter Student Academic Year" name="AcadamicYrTable"
										readOnly>
								</div></td>

							<td><div class="form-group">
									<label>Stream Name</label><input
										style="width: 180px; height: 35px; margin: 0; padding: 0;"
										type="text" class="form-control" id="streamNameTable"
										placeholder="Enter Student Stream Name" name="streamNameTable"
										readOnly>
								</div></td>
						</tr>
						<tr>
							<td><div class="form-group">
									<label>Branch Name</label><input
										style="width: 180px; height: 35px; margin: 0; padding: 0;"
										type="text" class="form-control" id="branchNameTable"
										placeholder="Enter Student Branch Name" name="branchNameTable"
										readOnly>
								</div></td>

							<td><div class="form-group">
									<label>Standard Name</label><input
										style="width: 180px; height: 35px; margin: 0; padding: 0;"
										type="text" class="form-control" id="standardNameTable"
										placeholder="Enter Student Standard Name" name="standardNameTable"
										readOnly>
								</div></td>

							<td><div class="form-group">
									<label>Catagory</label><input
										style="width: 180px; height: 35px; margin: 0; padding: 0;"
										type="text" class="form-control" id="studentCatagoryTable"
										placeholder="Student Catagory" name="studentCatagory" readOnly>
								</div></td>

							<td><div class="form-group">
									<label>Student Barcode No.</label><input
										style="width: 180px; height: 35px; margin: 0; padding: 0;"
										type="text" class="form-control" id="studentBarcodeTable"
										placeholder="Student Catagory" name="studentBarcodeTable"
										readOnly>
								</div></td>
						</tr>
					</table>

					<%-- 					<table class="table table-condensed">

						<thead>
							<tr>
								<th>Student Reg. ID</th>
								<th>Name</th>
								<th>Acadamic Yr</th>
								<th>Stream Name</th>
								<th>Branch Name</th>
								<th>Standard</th>
								<th>Category</th>
								<th>Contact No</th>
								
							</tr>
						</thead>

						<tbody id="ThirdTable">

							<c:forEach var="R3" items="${NotReturningDetails}">
								<tr>
									 <td><c:out value="${R3.AccessionId}"></c:out></td>
									<td><c:out value="${R3.BookFor }"></c:out>
									<td><c:out value="${R3.Author}"></c:out></td>
									<td><c:out value="${R3.Title}"></c:out></td>
									<td><c:out value="${R3.issueDate}"></c:out></td>
									<td><c:out value="${R3.PrizePerBook}"></c:out></td>
								</tr>
							</c:forEach>


						</tbody>

					</table> --%>
				</div>

			</div>

			<div class="row">
				<!-- Category Table -->
				<div class="col-lg-12">
					<div class="portlet portlet-red" id="IssueReturnDiv">
						<div class="portlet-heading">
							<div class="portlet-title">
								<h4>Book Issue/Return</h4>
								<h4 style="color: red;">
									<!-- Student And Teacher Book Status Display Here: -->${Status}</h4>
							</div>
							<div class="clearfix"></div>
						</div>
						<div id="basicFormExample" class="panel-collapse collapse in">
							<div class="portlet-body">

								${msg}
								 <h3 style="color: red;" id="id1"></h3>
								<form:form role="form" action="BookBankIsssueReturn.html"
									commandName="SaveBrand" method="post" name="BookDetails">
									<div class="col-md-3">
										<div class="form-group">
											<label for="Accession">Student Barcode</label> <input
												type="text" class="form-control" id="readerId"
												placeholder="Student Barcode" name="readerId" required
												onchange="IssueAndReturn();">
										</div>
									</div>
                                   
									<div class="col-md-3">
										<div class="form-group">
											<label for="Accession">Book Accession ID</label> <input
												type="text" class="form-control" id="bookId"
												placeholder="Book Barcode" name="bookId" required
												onchange="makeReadOnly();">
										</div>
									</div>


									<div class="col-md-3">
										<div class="form-group">
											<br> <input type="submit" class="btn btn-default" id="IssueReturnBookBtn"
												name="IssueReturnBook" value="Issue/Return Book">
										</div>

									</div>
									<br>
									<br>
									<br>

								</form:form>
							</div>
						</div>
						<!-- style="display: none" -->
						<div class="row" id="staffDiv">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="row">
									<input type="button" class="btn btn-default"
										value="Get Student Transaction" id="getRecordsButton">
										<br><br><div class="form-group">
									<label>Total Transactions   </label> &emsp;&emsp;
									<input
										style="width: 140px; height: 35px; margin: 0; padding: 0;"
										type="text"  id="totalTransaction"
										placeholder="Total Transaction" name="totalTransaction" readOnly>
								</div>
									<div class="portlet-title">
										<center>
											<h4>Student Issue-Return Transaction Details :</h4>
									</div>
									<form class="form-inline" action="getTransactionStud.html"
										target="_blank">
										<div id="bookDetails" class="col-xs-12">


											<table id="simple-table"
												class="table  table-bordered table-hover">
												<thead>
													<tr>
														<th><center>StudentID</center></th>
														<th><center>Acadamic Year</center></th>
														<th><center>Student Barcode</center></th>
														<th><center>Book-Accession ID</center></th>
														<th><center>IssueDate</center></th>
														<th><center>Return Date</center></th>
														<th><center>IssueReturn Status</center></th>
														<th><center>Fine</center></th>
													</tr>
												</thead>
												<tbody id="studBookBankRecords">

												</tbody>

											</table>
											<input type="hidden" id="barcodeStudent"
												name="barcodeStudent">
											<!-- <a href="printTransaction.html">Print Transaction </a> -->
											<input type="submit" class="btn btn-default"
												value="Print Transaction" id="printTransaction"
												name="printTransaction">
										</div>
									</form>
								</div>
							</div>
							<!-- /.span -->
						</div>

						
						<br> <br> <br>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>