<%@page import="java.net.URI"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	//alert("Hiii");
	$('#subjectName').change(function(){
		//alert("Hii clicked");
		var bookName=$('#subjectName').val();
		//alert("bookName : " +bookName);
		$("#LibrarySubjectTable").empty();
	 	$.getJSON('getBookSubDetailStudent.html',{bookName:bookName}).done(function(data){
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
		<div class="page-header center">
			<center>
				<h1>
					<b>Library Books Records(Subject) </b>
				</h1>
			</center>

		</div>

		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->

				<form action="#" method="get" id="" class="form-horizontal">

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
								Select Subject Name :<span style="color:red;">*</span></label>

						<div class="col-sm-9">
							<select class="col-xs-3" id="subjectName" required>
								<option value="">----------Select Book Subject------</option>
								<c:forEach var="v" items="${BookSubList}">
									<option value="${v.key}">${v.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</form>

			</div>
		</div>
		<hr/>
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table id="" class="table  table-bordered table-hover">
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
</body>
</html>