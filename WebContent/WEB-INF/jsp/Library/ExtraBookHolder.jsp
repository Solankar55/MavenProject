<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Extra Book Holder</title>

<style>
* {
  margin: 0;
  padding: 0;
}

body {
  font-family: "Open Sans";
  font-size: 14px;
}

h3{
color: #ff0000;
}

.container {
  width: 100px;
  margin: 10px ;
}

/* form {
  padding: 40px;
  background: 	#4682B4;
  color: #fff;
  -moz-border-radius: 0.5px;
  -webkit-border-radius: 0.5px;
  border-radius: 0.5px;
}  */
 form label
 {
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


<div id="page-wrapper" >

		<div class="page-content">

			<!-- begin PAGE TITLE ROW -->
			<div class="row">
				<div class="col-lg-12">
					<div class="page-title">
						<h1>Extra Book Holder Detail</h1>
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
										<h4>Select To Get Book Holder Details</h4>
									</div>
									<div class="portlet-widgets">
										<a data-toggle="collapse" data-parent="#accordion"
											href="#basicFormExample"><i class="fa fa-chevron-down"></i></a>
									</div>
									<div class="clearfix"></div>
								</div>
								<div id="basicFormExample" class="panel-collapse collapse in">
									<div class="portlet-body">


										<form class="form-inline" action="GetHolderDetails.html" >
											
											<div class="row">
											<div class="col-md-6">
											<div class="form-group">
												<label>Select Book Holder</label>
												<select id="category"  name="Category"
												style="width:180px; height:35px;margin:0;padding:0;">
												<option value="">Select Book Holder</option>
												<option value="Student" >Student</option>
												<option value="Staff">Staff</option>
												<!-- <option value="other">Other</option> -->
												</select>
											</div>
											</div>
											</div>
											<br>
      										 <input type="submit" class="btn btn-default" value="Get Details" id="GetDetails">
											 
										</form>
										
									</div>
								</div>
							</div>
							<!-- /.portlet -->
						</div>
					</div>
				</div>
			
				<br>
	
			</div>
		
		<br><br><br><br>
		
		
		
		<div class="row">
			<!-- Category Table -->
			<div class="col-lg-12">
				<div class="portlet portlet-red">
					<div class="portlet-heading">
						<div class="portlet-title">
							<h4>Student Extra Book Holders List </h4>
						</div>
						<div class="clearfix"></div>
					</div>
					
					<div class="portlet-body">
							<div class="table-responsive">
							<div id="StudentTable">
							<table class="table table-condensed" >
								
								<thead>
									<tr>
										<th>Book Accession Id</th>
										<th>Title</th>
										<th>Author</th>
										<th>Issue Date</th>
										<th>Book Hoder Name</th>
										<th>Catagory</th>
									</tr>
								</thead>
									
								<tbody id="FirstTable">
									<c:forEach var="R" items="${TableData}">
									<tr>
										<td><c:out value="${R.BookAccessionId}"></c:out></td>
										<td><c:out value="${R.Title}"></c:out></td>
										<td><c:out value="${R.Author}"></c:out></td>
										<td><c:out value="${R.IssueDate}"></c:out></td>
										<td><c:out value="${R.studentFirstName} ${R.studentLastName }"></c:out></td>
										<td><c:out value="Student"></c:out></td>
										<!-- <td>Student</td> -->
									</tr>
									</c:forEach>
									
									
								</tbody>
											
							</table>
							
							<h3>${StudentDataNotPresentMsg }</h3>
					</div>
					<hr/>
					<h4>Staff Extra Book Holders List </h4>
					<!-- Teacher Book Hilding  -->
					<div id="Stafftable">
							 <table class="table table-condensed" >
								
								<thead>
									<tr>
										<th>Book Id</th>
										<th>Title</th>
										<th>Author</th>
										<th>Issue Date</th>
										<th>Book Hoder Nameee</th>
										<th>Category</th>
										
									</tr>
								</thead>
									
								<tbody>
									<c:forEach var="R1" items="${tabledataStaff}">
									<tr>
										<td><c:out value="${R1.BookBarcode}"></c:out></td>
										<td><c:out value="${R1.Title}"></c:out></td>
										<td><c:out value="${R1.Author}"></c:out></td>
										<td><c:out value="${R1.IssueDate}"></c:out></td>
										<td><c:out value="${R1.StaffName}"></c:out></td>
										<td><c:out value="Staff"></c:out></td>
										<!-- <td>Staff</td> -->
									</tr>
									</c:forEach>
									
						
										
								</tbody>
											
							</table>
							<h3>${StaffDataNotPresentMsg }</h3>
							</div>
							<%-- <div class="col-md-3">
							<div class="form-group">
      						<label for="StudentRegistrationId">Total Fine :</label>
      						<input type="text" class="form-control" id="studentRegistrationId" placeholder="Total Fine" name="StudentRegistrationId" value="${FineForNotReturn}">
    						</div>
							</div> --%>
				 			<hr/>
							
							<br><br><br><br><br><br><br><br><br><br>
							
						</div>
					</div>
				</div>
				<!-- /.portlet -->
			</div>
		</div>
	</div>

</div>

<script>


	$("#GetDetails").click(function(){
		//alert("in table ");
		var category=$("#category").val();
		//alert("category"+category);
 if(category=="Student"){
	// alert("ear");
	// alert(" abcd"+category)
	// alert("abcd");
	//$('#StudentTable').show();
	$("#Stafftable").hide();
}else if(category=="Staff"){
	//alert("decb")
	$("#Stafftable").show();
	$("#StudentTable").hide();
}else{
	alert("Enter proper Information")
}
 		
			});




</script>




</body>
</html>