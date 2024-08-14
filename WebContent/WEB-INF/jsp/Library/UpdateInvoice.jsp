<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<style type="text/css">

/* Extra styles for the cancel button */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

.container {
	padding: 16px;
}

/* span.psw {
    float: right;
    padding-top: 16px;
} */

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 80%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
	position: absolute;
	right: 25px;
	top: 0;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: red;
	cursor: pointer;
}

/* Add Zoom Animation */
.animate {
	-webkit-animation: animatezoom 0.6s;
	animation: animatezoom 0.6s
}

@
-webkit-keyframes animatezoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes animatezoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}
}

/* * Change styles for span and cancel button on extra small screens 
@media screen {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
} */
</style>
<body>
<div class="page-content">
		<form action="UpdateInvoiceSave.html" 
			method="post" id="" class="form-horizontal">
			<div class="page-header center">
				<h1><b>Invoice Updatation Page</b></h1>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Invoice Number: </label>
						<div class="col-sm-9">
							<input type="text" name="invoiceNumber" class="col-xs-3" id="invoiceNo"
								placeholder="Invoice Number" />
						</div>
						<div>
							<br>
							<br>
							<div class="form-group ">
								<div class="col-sm-3 control-label no-padding-right">
									<button type="submit" id="" value="ADD" name="updateInvoiceNo" 
										class="btn btn-big btn-success">Update Invoice </button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
		<hr />
<div class="row">

			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table 
							class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>Invoice Date</th>
									<th>Title</th>
									<th>Book For</th>
									<th>Book Type</th>
									<th>Subject</th>
									<!-- <th>Opearation</th> -->
								<!-- <th>Add</th> --> 
								</tr>
							</thead>
 
							<tbody id="AddtoInvoiceTable">
					<c:forEach var="v" items="${InvoiceDetailList}">
									<tr onclick="document.getElementById('id01').style.display='block'" >
									<td style="display: none;"><c:out value="${v.InvoiceNo}"></c:out></td>
									<td><c:out value="${v.InvoiceDate}"></c:out></td> 
									<td><c:out value="${v.Title}"></c:out></td> 
									<td><c:out value="${v.BookFor}"></c:out></td> 
									<td><c:out value="${v.Booktype}"></c:out></td> 
									<td><c:out value="${v.LibrarySubject}"></c:out></td>
									<td style="display: none;"><c:out value="${v.Author}"></c:out></td>  
									<td style="display: none;"><c:out value="${v.ClassNumber}"></c:out></td>
									<td style="display: none;"><c:out value="${v.Edition}"></c:out></td>
									<td style="display: none;"><c:out value="${v.PublicationYear}"></c:out></td>
									<td style="display: none;"><c:out value="${v.Publisher}"></c:out></td>
									<td style="display: none;"><c:out value="${v.SizeOfBook}"></c:out></td>
									<td style="display: none;"><c:out value="${v.Vendor}"></c:out></td>	
									<td style="display: none;"><c:out value="${v.QuantityId}"></c:out></td>
									<td style="display: none;"><c:out value="${v.TransactionMasterId}"></c:out></td>	
									</tr>
								</c:forEach> 
							</tbody> 
						</table>
					</div>
				</div>
			</div>
			<!-- /.span -->
		</div>	
		<script type="text/javascript">
		$("#AddtoInvoiceTable tr").click(function() {

		//	alert("Hii");
			
 			$("#invoiceNo1").val($(this).find("td").eq(0).text());
			$("#invoiceDate").val($(this).find("td").eq(1).text());
			$("#title").val($(this).find("td").eq(2).text());
			$("#BookFor1").val($(this).find("td").eq(3).text());
			$("#bookType").val($(this).find("td").eq(4).text());
			$("#subject").val($(this).find("td").eq(5).text());
			$("#author").val($(this).find("td").eq(6).text());
			$("#classNumber").val($(this).find("td").eq(7).text());
			$("#edition").val($(this).find("td").eq(8).text());
			$("#publicationYear").val($(this).find("td").eq(9).text());
			$("#publisher").val($(this).find("td").eq(10).text());
			$("#sizeOfBook").val($(this).find("td").eq(11).text());
			$("#vendor").val($(this).find("td").eq(12).text());
			$("#quantityId").val($(this).find("td").eq(13).text());
			$("#transactionId").val($(this).find("td").eq(14).text());
			
		var modal = document.getElementById('id01');
			// When the user clicks anywhere outside of the modal, close it
			window.onclick = function(event) {
				//alert(value);
				if (event.target == modal) {
					modal.style.display = "none";

				}
			} 
		});
		</script>
			<div id="id01" class="modal">

		<form class="modal-content animate" action="UpdateInvEditSave.html"
			method="post" >
			<div class="imgcontainer">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>

			<div class="container">
			
			<table class="">
					<tr>
						<td><label><b>Invoice No :</b></label></td>
						<td><input type="text" name="invoiceNo1" id="invoiceNo1" class="col-sm-9"
							readonly="true"></td>
						<td><label><b>Invoice Date :</b></label></td>
						<td><input type="text" name="invoiceDate" id="invoiceDate" class="col-sm-9"
							readonly="true"></td>

						<td><label><b>Title :</b></label></td>
						<td><input type="text" name="title" id="title" class="col-sm-9"
							></td>
						<td><label><b>Book For :</b></label></td>
						 <td> <select size="1" id="bookfor1"
						name="BookFor1" aria-controls="example-table"
						style="width: 125px; height: 35px; line-height: 20px; margin: 0; padding: 0;">
							<option value="">Select Book For</option>
							<option value="Degree">Degree</option>
							<option value="Diploma">Diploma</option>
							<option value="Other">Other</option>
					</select></td>

					
						</tr>

					<tr>
						<td><label><b>Book Type :</b></label></td>
						<td><select id="bookType" name="bookType"
						style="width: 125px; height: 35px; margin: 0; padding: 0;">
						<option value="">Select Book Type</option>
						<c:forEach var="Bk" items="${BookTypeList}">
						
							<option value="${Bk.key }">${Bk.value}</option>
						</c:forEach>

					</select></td>
							
					<td><label><b>Subject :</b></label></td>
						<td> <select id="subject" name="subject"
						style="width: 125px; height: 35px; margin: 0; padding: 0;">
						<option value="">Select Subject</option>
						<c:forEach var="s" items="${subjectList}">
							<option value="${s.key }">${s.value}</option>
						</c:forEach>

					</select></td>
						<td><label><b>Author :</b></label></td>
						<td><input type="text" name="author" id="author" class="col-sm-9"
							></td>
						<td><label><b>ClassNumber :</b></label></td>
						<td><input type="text" name="classNumber" id="classNumber" class="col-sm-9"
							></td>
							
					</tr>
					
					<tr>
					<td><label><b>Edition :</b></label></td>
						<td><input type="text" name="edition" id="edition" class="col-sm-9"
							></td>
							
					<td><label><b>Publication Year :</b></label></td>
						<td><input type="text" name="publicationYear" id="publicationYear" class="col-sm-9"
							></td>
							
					<td><label><b>Publisher :</b></label></td>
						<td><input type="text" name="publisher" id="publisher" class="col-sm-9"
							></td>
					<td><label><b>SizeOfBook :</b></label></td>
						<td><input type="text" name="sizeOfBook" id="sizeOfBook" class="col-sm-9"
							></td>
							
					
					</tr>
					<tr>
					<td><label><b>Vendor :</b></label></td>
						<td><input type="text" name="vendor" id="vendor" class="col-sm-9"
							></td>
							
					<!-- <td><label><b>Quantity Id :</b></label></td> -->
						<td><input type="hidden" name="quantityId" id="quantityId" class="col-sm-9"
							readonly="true"></td>
							
				<!-- 	<td><label><b>Transaction Id :</b></label></td> -->
						<td><input type="hidden" name="transactionId" id="transactionId" class="col-sm-9"
							readonly="true"></td>
							
					</tr>
			</table>
			<center>
					<button type="submit"
						onclick="document.getElementById('id01').style.display='none'"
						class="btn btn-xs btn-success">Update Invoice</button>
			</center>

			</div>
		</form>
	</div>
		</div>
</body>
</html>