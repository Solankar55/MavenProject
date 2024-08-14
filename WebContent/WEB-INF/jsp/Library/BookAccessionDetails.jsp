<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Type</title>

<script type="text/javascript">

	 var makeReadOnly = function() {

		$("#bookId").prop("readonly", true);
		$("#readerId").prop("readonly", false);
		// $('#StudId').removeAttr('readonly');
	}
 	$(document).ready(function(){
		
		
		$("#bookId").blur(function(){
			//alert("bookid inserted");
			var bookBarcode=$("#bookId").val();
			// alert("bookBarcode" +bookBarcode); 
			
			var bookId=$("#bookId").val();
			$.getJSON('getMessageBookId1.html',{bookId:bookId}).done(function(data){
		
				$("#id1").text(data.msg);
	})
			  $.getJSON('getBookBarcodeData.html',{bookBarcode:bookBarcode}).done(function(data){
				 
				 for(var i=0;i<data.length;i++){
					 $("#bookInformation").append("<tr ><td>"+data[i].LibrarySubject+"</td><td>"+data[i].BookFor+"</td><td>"+data[i].booktype+"</td><td>"+data[i].Title+"</td><td>"+data[i].Author+"</td><td>"+data[i].Edition+"</td><td>"+data[i].PublicationYear+"</td><td>"+data[i].Publisher+"</td></tr>");
				 }
				 
				 $("#bookDiv").show();
		}); 
  });
		
		$("#readerId").blur(function(){
			
			 var studentBarcode=$("#readerId").val();
			// alert("studentBarcode" +studentBarcode); 
			 
			 var n=studentBarcode.includes("ST");
			 if(n==true)
				 {
				 	//alert("HIii");
				 	 $.getJSON('getStudentBarcodeData.html',{studentBarcode:studentBarcode}).done(function(data){
						 if(data.length==0)
							 {
							 alert("Student Admission is not approved/Student Admission is cancelled");
							document.getElementById('IssueReturnBookB').disabled=true; 
							
							 }
						 else{
						 for(var i=0;i<data.length;i++){
							 $("#studentInformation").append("<tr ><td>"+data[i].StudId+"</td><td>"+data[i].acadamicYear+"</td><td>"+data[i].streamName+"</td><td>"+data[i].branchName+"</td><td>"+data[i].standard+"</td><td>"+data[i].studentContactNumber+"</td><td>"+data[i].studentFirstName +" "+ data[i].studentLastName +"</td></tr>");
						 }
						 }
					 });
						 $("#bookId").prop("readonly", true);
						$("#readerId").prop("readonly", true);
					 
						 $("#studentDiv").show(); 
				 	
				 }
			 if(n!=true)
				 {
				 	//alert("Staff Barcode");
				 	var staffBarcode=$("#readerId").val();
				 	//alert("staffBarcode" +staffBarcode);
	 				$.getJSON('getStaffData.html',{staffBarcode:staffBarcode}).done(function(data){
						 
						 for(var i=0;i<data.length;i++){
							 $("#staffInformation").append("<tr><td>"+data[i].staffID+"</td><td>"+data[i].StaffName+"</td><td>"+data[i].StaffType+"</td><td>"+data[i].SatffDepartment+"</td><td>"+data[i].MobileNumber+"</td></tr>");
						 }
						 
					 });
						 $("#bookId").prop("readonly", true);
						$("#readerId").prop("readonly", true);
					 
						 $("#staffDiv").show(); 
				 }
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
	<div class="page-content">
		<div class="page-header">
			<!-- begin PAGE TITLE ROW -->
			<div class="row">
				<div class="col-lg-12">
					<div class="page-title">
						<h1><center><b>Issue/Return Books</b></center></h1>
						<h2 style="color: red;"><!-- Student And Teacher Book Status Display Here: -->${Status}</h2>
					</div>
				</div>
			</div>
			
			<div class="form-inline"><hr>

				
				<div class="clearfix"></div>
			</div>

			<!-- end PAGE TITLE ROW -->

			<form action="IssueOrReturnBook.html" method="post">
				<div class="row">

					<!-- begin LEFT COLUMN -->
					

						<div class="row">

							<!-- Basic Form Example -->
							<div class="col-lg-12">

								<div class="portlet portlet-default">
									
									<div id="basicFormExample" class="panel-collapse collapse in">
										
											${msg}
								 <h3 style="color: red;" id="id1"></h3>
											<form:form role="form" action="BookTypeData.html"
												commandName="SaveBrand" method="post" name="BookDetails">
												
												
												<div class="col-md-3">
													<div class="form-group">
														<label for="Accession">Book Barcode </label> <input
															type="text" class="form-control" id="bookId" 
															placeholder="Book Barcode" name="bookId" required
															onchange="makeReadOnly();">
													</div>
												</div>

												<div class="col-md-3">
													<div class="form-group">
														<label for="Accession">Student Barcode</label> <input
															type="text" class="form-control" id="readerId"
															placeholder="Student Barcode" name="readerId" readonly="true"
															required onchange="IssueAndReturn();">
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group">
														<br> <input type="submit" class="btn btn-default" id="IssueReturnBookB"
															name="IssueReturnBook" value="Issue/Return Book">
													</div>
												</div>
											</form:form>
										
									</div>
		<div class="row" id="bookDiv" style="display: none">
			<div class="col-xs-12">
			<div class="portlet-title">
					<center><h4>Book  Details with Respective to  barcode </h4>
			</div>
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div id="bookDetails" class="col-xs-12">
					
						<table id="simple-table" class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>Subject</th>
									<th>Book For</th>
									<th>Book Type</th>
									<th>Title</th>
									<th>Author</th>
									<th>Edition</th>
									<th>Publication Year</th>
									<th>Publisher</th>
									

								</tr>
							</thead>
							<tbody id="bookInformation">
								
							</tbody>

						</table>
					</div>
				</div>
			</div>
			<!-- /.span -->
		</div>
		<div class="row" id="studentDiv" style="display: none">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
						<div class="portlet-title">
					<center><h4>Student Details with Respective to Student Barcode </h4>
				</div>
					<div id="bookDetails" class="col-xs-12">
					
			
						<table id="simple-table" class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>StudentID</th>
									<th>Acadamic Year</th>
									<th>StreamName</th>
									<th>BranchName</th>
									<th>Standard</th>
									<th>Contact No</th>
									<th>Student Name</th>
									

								</tr>
							</thead>
							<tbody id="studentInformation">
								
							</tbody>

						</table>
					</div>
				</div>
			</div>
			<!-- /.span -->
		</div>
		<div class="row" id="staffDiv" style="display: none">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
						<div class="portlet-title">
					<center><h4>Staff Details with Respective to Staff Barcode </h4>
				</div>
					<div id="bookDetails" class="col-xs-12">
					
			
						<table id="simple-table" class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>StaffID</th>
									<th>StaffName</th>
									<th>StaffType</th>
									<th>Department</th>
									<th>Contact No</th>
								</tr>
							</thead>
							<tbody id="staffInformation">
								
							</tbody>

						</table>
					</div>
				</div>
			</div>
			<!-- /.span -->
		</div>
								
								<!-- /.portlet -->
							</div>
						</div>
					
				</div></div>
			</form>
			<!-- <div class="row">
				Category Table
				<div class="col-lg-12">
					<div class="portlet portlet-red">
						<div class="portlet-heading">
							<div class="portlet-title">
								<h4>Access Details Table</h4>
							</div>
							<div class="clearfix"></div>
						</div>

						<div class="portlet-body">
							<div class="table-responsive">
								<table class="table table-condensed">
									<thead>
										<tr>
											<th>Book Accessing</th>
											<th>Reader Name</th>
											<th>Issue Date</th>
											<th>Return Date</th>
											<th>Fine</th>
											<th>Reader Type</th>
										</tr>
									</thead>

									<tbody id="StandardData">


										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>

										</tr>


									</tbody>



								</table>

								<br>
								<div class="col-md-12"></div>
								<div class="col-md-12"></div>
								<div class="col-md-10"></div>
								<br> <br>
								<div class="col-md-12"></div>
								<div class="col-md-12"></div>
								<div class="col-md-6"></div>
								<input type="submit" class="btn btn-default" value="Refresh">



							</div>
						</div>
					</div>
					/.portlet
				</div>
			</div> -->
		</div>

	</div>
	<br>
	<br>
	<br>
	<script>
		$(function() {
			// Initialize form validation on the registration form.
			// It has the name attribute "registration"
			$("form[name='booktypeadd']").validate({
				// Specify validation rules
				rules : {
					// The key name on the left side is the name attribute
					// of an input field. Validation rules are defined
					// on the right side
					Booktype : {
						required : true,
						lettersonly : true,
						numeric : false
					}

				},
				// Specify validation error messages
				messages : {
					Booktype : "Please enter Book properly",

				},
				// Make sure the form is submitted to the destination defined
				// in the "action" attribute of the form when valid
				submitHandler : function(form) {
					form.submit();
				}
			});
		});
	</script>




</body>
</html>