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
						<h1>Lecturer Clearence</h1>
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
										<h4>Lecturer Details</h4>
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
												<label>Select Year</label> <select id="selectYear"
													name="SelectYear"
													style="width: 180px; height: 35px; margin: 0; padding: 0;">

													<c:forEach var="acadamicYr" items="${acadamicYr }">
														<option value="${acadamicYr.key }">${acadamicYr.value }</option>
													</c:forEach>

												</select>
											</div>

											<div class="form-group">
												<label for="StaffRegistrationId">Staff Registration
													Id</label> <input
													style="width: 180px; height: 35px; margin: 0; padding: 0;"
													type="text" class="form-control" id="StaffRegistrationId"
													placeholder="Staff Registration Id"
													name="StaffRegistrationId">
											</div>

											<div class="col-md-12"></div>
											<div class="col-md-12"></div>
											<div class="col-md-12"></div>
											<div class="col-md-12"></div>
											<div class="col-md-12"></div>
											<div class="col-md-12"></div>

											<input type="submit" class="btn btn-default"
												value="Get Details">

										</form>
									</div>
								</div>
							</div>
							<!-- /.portlet -->
						</div>
					</div>
				</div>

	<%-- 			<div class="col-lg-8">

					<div class="col-md-3">
						<div class="form-group">
							<label for="StudentRegistrationId" style="font-size: 18px"><b>Total Fine :</b></label> <input
								type="text" class="form-control" id="studentRegistrationId"
								placeholder="Total Fine" name="StudentRegistrationId"
								value="${FineForNotReturn}">
						</div>
					</div>
				</div> --%>

			</div>

			<div class="row">
				<!-- Category Table -->
				<div class="col-lg-12">
					<div class="portlet portlet-red">
						<div class="portlet-heading">
							<div class="portlet-title">
								<h4>Lecturer Details Table</h4>
							</div>
							<div class="clearfix"></div>
						</div>

						<div class="portlet-body">
							<div class="table-responsive">

								<table class="table table-condensed">

									<thead>
										<tr>
											<th>Book Id</th>
											<th>Issue Date</th>
											<th>Return Date</th>
											<th>Fine</th>
										</tr>
									</thead>

									<tbody id="FirstTable">

										<c:forEach var="R" items="${finedetails}">
											<tr>
												<td><c:out value="${R.BookAccessionId}"></c:out></td>
												<td><c:out value="${R.IssueDate}"></c:out></td>
												<td><c:out value="${R.ReturnDate}"></c:out></td>
												<td><c:out value="${R.Fine}"></c:out></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<div class="col-md-3">
									<div class="form-group">
										<label for="StudentRegistrationId">Total Fine :</label> <input
											type="text" class="form-control" id="studentRegistrationId"
											placeholder="Total Fine" name="StudentRegistrationId"
											value="${totalfine}">
									</div>
								</div>

								<table class="table table-condensed">

									<thead>
										<tr>
											<th>Book Id</th>
											<th>Book Name</th>
											<th>Book Author</th>
											<th>Lost Date</th>
											<th>Prize Per Book</th>
										</tr>
									</thead>

									<tbody id="SecondTable">

										<c:forEach var="R1" items="${Lostdetails}">
											<tr>
												<td><c:out value="${R1.AccessionLibraryRegisterId}"></c:out></td>
												<td><c:out value="${R1.Title}"></c:out></td>
												<td><c:out value="${R1.Author}"></c:out></td>
												<td><c:out value="${R1.DateLost}"></c:out></td>
												<td><c:out value="${R1.PrizePerBook}"></c:out></td>
											</tr>
										</c:forEach>

									</tbody>

								</table>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3">
							<div class="form-group">
								<label for="StudentRegistrationId">Total Price of Book :</label> <input
									type="text" class="form-control" id="studentRegistrationId"
									placeholder="Total Price of Book" name="StudentRegistrationId"
									value="${SetLostTotal}">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3">
							<div class="form-group">
								<label for="" style="color: red;">Total Fine is Rupess :</label>
								<input type="text" class="form-control" id="SecondID"
									placeholder="Total Fine" name="" value="${TotalFineOnBook}">
							</div>
						</div>
					</div>
					<br> <br> <br>
				</div>
			</div>
		</div>
	</div>
</body>
</html>