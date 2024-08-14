<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="page-content">
		<form action="PrintLibraryBookInvoiceRecord.html" 
			method="post" id="" class="form-horizontal" target="_blank">
			<div class="page-header center">
				<h1><b>Library Book Invoice Record Report</b></h1>
				<br>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Academic Year : <span style="color:red;">*</span></label>
						<div class="col-sm-9">
							<!-- <input type="text" name="academicYear" class="col-xs-3"
								id="academicYear" placeholder="Enter Academic year"  /> -->
						<select  id="YearID" name="YearID"
						
						style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;">
						<option value="">Select Academic Year</option>
						<c:forEach var="v" items="${YearList}">
							<option value="${v.value}">${v.value}</option>
						</c:forEach>
					</select>
						</div>
						<div>
							<br> <br>
							<div class="form-group ">

								<div class="col-sm-3 control-label no-padding-right">
									<button id="printAction" name="printInvoice"
										class="btn btn-big btn-success">Print</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</form>

	</div>
</body>
</html>