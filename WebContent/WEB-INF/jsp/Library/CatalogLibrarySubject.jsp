<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Subject Report</title>

<script src="js/jquery.validate.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//alert("Hiii");
	$('#subject').change(function(){
		//alert("Hii clicked");
		var bookName=$('#subject').val();
		var bookfor=$('#bookfor').val();
		//alert("bookName : " +bookName);
		$("#LibrarySubjectTable").empty();
	 	$.getJSON('getBookSubDetailStudent.html',{bookName:bookName,bookfor:bookfor}).done(function(data){
	 		for(var i=0;i<data.length;i++)
	 			{
	 			$("#LibrarySubjectTable").append("<tr><td>"+data[i].BookFor+"</td><td>"+data[i].Title +"</td><td>"+ data[i].Author+ "</td><td>"+data[i].Edition+"</td><td>"+data[i].Publisher+"</td><td>"+data[i].PublicationYear+"</td><td>"+data[i].quantity+"</td><td>"+data[i].PrizePerBook+"</td></tr>");
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
				<h1>
					<b>Catalog Subject Report </b>
				</h1>
			</center>
		</div>

		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<form action="SubjectWiseReportPrintLab.html" method="get" id=""
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
							Select Subject:<span style="color: red;">*</span>
						</label>
						<div class="col-sm-9">
							<select id="subject" name="Subject" class="col-xs-3" required>
								<option value="">Select Subject</option>
								<c:forEach var="Slist" items="${LibrarySubjectList }">
									<option value="${Slist.key }">${Slist.value}</option>
								</c:forEach>

							</select>

						</div>
					</div>

					<div class="form-group ">
					<div class="col-sm-3"></div>
						<div class="col-sm-3 control-label no-padding-right">
							<button type="submit" class="btn btn-big btn-success"
								name="SubjectWiseReportPrint" value="Report Generate">
								Genrate Report</button>
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
						<table id="dynamic-table"
							class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>Book For</th>
									<th>Title</th>
									<th>Author</th>
									<th>Edition</th>
									<th>Publisher</th>
									<th>Publication Year</th>
									<th>Quantity</th>
									<th>Prize Per Book</th>
								</tr>
							</thead>

							<tbody id="LibrarySubjectTable">
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- /.span -->
		</div>
	</div>
<br><br><br>
	<script src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.bootstrap.min.js"></script>
	<script type="text/javascript">
		jQuery(function($) {
			//initiate dataTables plugin { "bSortable": false }
			var myTable = $('#dynamic-table').DataTable({
				bAutoWidth : false,
				"aoColumns" : [ null, null, null, null, null, null, null, null ],
				"aaSorting" : []
				
			});
		})
	</script>

</body>
</html>