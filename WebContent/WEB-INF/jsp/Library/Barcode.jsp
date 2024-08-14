<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Barcode Generate</title>

<link href="http://www.jqueryscript.net/css/jquerysctipttop.css"
	rel="stylesheet" type="text/css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<style type="text/css">
button {
	color: blue;
	width: 150px;
	height: 40px;
}
</style>
<script type="text/javascript">

$(document).ready(function (){
	//alert("jefgufsg");
	
	$("#todate").blur(function(){
	//	alert("sss");
		
		var fromDate=$("#fromdate").val();
		var bookFor=$("#BookFor").val();
		var toDate=$("#todate").val();
		//alert(bookFor +" "+fromDate +" "+toDate);		
/* 	$.getJSON('getBarcodeBook.html',{bookFor:bookFor,fromDate:fromDate,toDate:toDate}).done(function(data) {
	//alert("on jsp page getBarcodeBook");
	
	for(var i=0;i<data.length;i++)
	{
		$("#BarcodeData").append("<tr><td>"+data[i].AccessionLibraryRegisterId+"</td><td>"+data[i].accessionId+"</td><td>"+data[i].title +" "+ data[i].Author+ "</td></tr>");
	}
	}); */
	});
	$("#BookFor").blur(function(){
		//alert("Hello in blur ");
		
		var bookFor=$("#BookFor").val();
		$("#BarcodeData").empty();
		$.getJSON('getBarcodeBook.html',{bookFor:bookFor}).done(function(data) {
			//alert("on jsp page getBarcodeBook"); +data[i].AccessionLibraryRegisterId+"</td><td>"
			
			for(var i=0;i<data.length;i++)
			{
				$("#BarcodeData").append("<tr><td>"+data[i].accessionId+"</td><td>"+data[i].title +" "+ data[i].Author+ "</td></tr>");
			}
			});
	});
});
</script>
</head>
<body>
	<div class="page-content">
		<div class="page-header">
			<center>
				<h1>Genrate Barcode</h1>
			</center>
		</div>

		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<form action="Barcode1.html" method="get" id="" class="form-horizontal" target="_Blank">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Book For:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<select type="text" class="col-xs-3" id="BookFor"
								name="BookFor">
								<option value="">Select Book For </option>
								<option value="PostGraduation">PostGraduation</option>
								<option value="Degree">Degree</option>
								<option value="Diploma">Diploma</option>
								<option value="Other">Other</option>
							</select>
						</div>
					</div>
					<!-- <div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							From Date:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
						 <input type="Date" class="col-xs-3" id="fromdate"  name="fromDate">
							
						</div>
					</div> -->
					<!-- <div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							To Date:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
						 <input type="Date" class="col-xs-3" id="todate"  name="toDate">
							
						</div>
						<div class="col-sm-3 control-label no-padding-right">
							<button type="submit" id="generateBarcode" class="btn btn-big btn-success">
								Genrate</button>
						</div>
					</div> -->
                   <div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							From :<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
						 <input type="text" class="col-xs-3" id="fromdate"  name="fromNumber" placeholder="Enter starting BookAccession Id">
							
						</div>
					</div> 
				 <div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							To :<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
						 <input type="text" class="col-xs-3" id="todate"  name="toNumber" placeholder="Enter Last BookAccession Id">
							
						</div>
					</div> 
   
					<div class="form-group ">
						
						<div class="col-sm-3 control-label no-padding-right">
							<button type="submit" class="btn btn-default btn-success"
								name="printDataBarcode" id="printData" value="Print">Print</button>
						</div>
					</div>
				</form>
			</div>
		</div>

		<hr />

		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table id="dynamic-table" class="table  table-bordered table-hover">
							<thead>
								<tr>
								<%-- <th><center>Serial Number</center></th> --%>
									<th><center>Book Accession ID</center></th>
									<th><center>Book Name</center></th>
									
								</tr>
							</thead>
							<tbody id="BarcodeData">
								<tr>
								<td></td><td></td></tr>
							</tbody>

						</table>
					</div>
				</div>
			</div>
			<!-- /.span -->
		</div>
	</div>
	<br>
	<br>
	<br>
	<script src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.bootstrap.min.js"></script>
	<script type="text/javascript">
		jQuery(function($) {
			//initiate dataTables plugin { "bSortable": false }
			var myTable = $('#dynamic-table').DataTable({
				bAutoWidth : false,
				"aoColumns" : [ null, null],
				"aaSorting" : []
				
			});
		})
	</script>

</body>
</html>