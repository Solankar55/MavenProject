<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#invoiceNo").blur(function(){
		
		//alert("Hiiii");
		var invoiceno=$("#invoiceNo").val();
	///	alert("invoice : " +invoiceno);
		
		$.getJSON('getInvoiceDetail.html',{invoiceno:invoiceno}).done(function(data) {
			///alert("on jsp page getINvoice");
			if(data.length==0)
		{
		alert("Please Enter Correct Invoice Number...");
		}
	else{
			 for(var i=0;i<data.length;i++)
			{ 
				//alert("Data" +data);
				$("#InvoiceData").append("<tr><td>"+data[i].Title+"</td><td>"+data[i].PrizePerBook +"</td><td>"+ data[i].Quantity+ "</td><td>"+data[i].TotalAmountOfBook+"</td><td>"+data[i].TotalDiscountAmount+"</td><td>"+data[i].DiscountRemark+"</td><td>"+data[i].Vendor+"</td></tr>");
			
			}
	}});
	});
});
</script>
</head>
<body>
	<div class="page-content">
		<form action="PrintYearDetail.html" 
			method="post" id="" class="form-horizontal" target="_blank">
			<div class="page-header center">
				<h1><b>Year- Report Wise Invoice Report</b></h1>
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
						aria-controls="example-table"
						style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;">
						<option value="">Select Academic Year</option>
						<c:forEach var="v" items="${YearList}">
							<option value="${v.key}">${v.value}</option>
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
<!-- 
			<div class="row">

				<div class="col-xs-12">
					PAGE CONTENT BEGINS
					<div class="row">
						<div class="col-xs-12">
							<table id="" class="table  table-bordered table-hover">
								<thead>
									<tr>
										<th>Book Title</th>
										<th>Prize per Book</th>
										<th>Quantity</th>
										<th>Total Book Amount</th>
										<th>Total Discount Amount</th>
										<th>Discount Remark</th>
										<th>Vender</th>
									</tr>
								</thead>

								<tbody id="InvoiceData">
								

								</tbody>
							</table>
						</div>
					</div>
				</div>
				/.span
			</div> -->

		</form>

	</div>
</body>
</html>