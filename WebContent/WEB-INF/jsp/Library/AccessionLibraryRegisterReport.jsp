<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
button {
	color: blue;
	width: 150px;
	height: 40px;
	
}
</style>
</head>
<body>
	<div class="page-content">
		<div class="page-header">
			<center>
				<h1>Accession Register Report</h1>
			</center>
		</div>

		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<form action="printforReport.html" method="get" id=""
					class="form-horizontal" target="_blank">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Book For :</label>
						<div class="col-sm-9">
							<select  id="bookfor" name="BookFor"
								class="col-sm-3">
								<option value="All">Select Book For</option>
								<option value="PostGraduation">PostGraduation</option>
								<option value="Degree">Degree</option>
								<option value="Diploma">Diploma</option>
								<option value="Other">Other</option>
							</select>
						</div>
					</div>
				<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Vendor Name  :<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
						 	<select type="text" class="col-xs-3" id="vendorName"
								name="vendorName">
								<option value="All">----Select Vendor Name----</option>
								<c:forEach var="S" items="${vendorNameL}">
								<option value="${S.key}">${S.value}</option>
								</c:forEach>
							</select>
						</div>
						</div>
						<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Book Type :<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
						 	<select type="text" class="col-xs-3" id="bookType"
								name="bookType">
								<option value="All">----Select Book Type----</option>
								<c:forEach var="S" items="${bookTypeList}">
								<option value="${S.key}">${S.value}</option>
								</c:forEach>
							</select>
						</div>
						</div>
									<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Academic Year :<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
						 	<select type="text" class="col-xs-3" id="bookType"
								name="AcademicYear">
								<option value="All">----Select Academic Year----</option>
								<c:forEach var="S" items="${academicYearList}">
								<option value="${S.key}">${S.value}</option>
								</c:forEach>
							</select>
						</div>
						</div>
					<div class="form-group ">
						<div class="col-sm-3 control-label no-padding-right">
							<button type="submit" class="btn btn-big btn-success" name="AccessionPrint">
								Print</button>
						</div>
					</div>
				</form>
			</div>
		</div></div>
</body>
</html>