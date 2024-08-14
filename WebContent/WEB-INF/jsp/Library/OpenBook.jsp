<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Name</title>

<script src="js/jquery.validate.min.js"></script>


<!-- <style type="text/css">

/* Extra styles for the cancel button */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

/* .container {
	padding: 16px;
} */

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


</style>
 -->



<style type="text/css">
button {
	color: blue;
	width: 200px;
	height: 40px;
}
</style>
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

h3 {
	color: #ff0000;
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
  background: 	#4682B4 ;
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

			<!-- begin PAGE TITLE ROW -->
			<div class="row">
				<div class="col-lg-12">
					<div class="page-title">
						<h1>Open Book</h1>
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
				<div class="col-lg-6">

					<div class="row">

						<!-- Basic Form Example -->
						<div class="col-lg-12">

							<div class="portlet portlet-default">
								<div class="portlet-heading">
									<div class="portlet-title">
										<h4>Open Book Form</h4>
									</div>
									<div class="portlet-widgets">
										<a data-toggle="collapse" data-parent="#accordion"
											href="#basicFormExample"><i class="fa fa-chevron-down"></i></a>
									</div>
									<div class="clearfix"></div>
								</div>
								<div id="basicFormExample" class="panel-collapse collapse in">
									<div class="portlet-body">


										<form role="form" action="ShowBookForData.html" name="Rackadd">


											<div class="form-group">
												<label>Book For:</label> <select id="BookFor" name="BookFor"
													style="width: 180px; height: 35px; margin: 0; padding: 0;">
													<option value="">Select Book For</option> 
													<option value="Degree" >Degree</option>
													<option value="Diploma">Diploma</option>
													<option value="Other">Other</option>
													<%-- <c:forEach var="BTM" items="${BTMList }">
							<option value="${BTM.key }">${BTM.value}</option>
							</c:forEach> --%>

												</select>
											</div>


											<input type="submit" class="btn btn-default" value="Show">
										</form>
									</div>
								</div>
							</div>
							<!-- /.portlet -->
						</div>
					</div>
				</div>
			</div>
			<hr />
			<div class="row">




				<!-- Category Table -->
				<div class="col-md-12">
					<div class="portlet portlet-red">
						<div class="portlet-heading">
							<div class="portlet-title">
								<h4>Rack-Number Table</h4>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="portlet-body">
							<div class="table-responsive">
								<table class="table table-condensed">
									<thead>
										<tr>
											<th>AccessionId</th>
											<th>BookFor</th>
											<th>Vendor</th>
											<th>Author</th>
											<th>Edition</th>
											<th>InDate</th>
											<th>PrizePerbook</th>
											<th>Publication Year</th>
											<th>Publisher</th>
											<th>College Remark</th>
											<th>Discount Remark</th>
											<th>Quantity</th>
											<th>Transaction</th>

											<!-- <th>Delete</th>	 -->
										</tr>
									</thead>

									<tbody>
										<c:forEach var="R" items="${AllData}">
											<tr>

												<td><c:out value="${R.AccessionId}"></c:out></td>
												<td><c:out value="${R.BookFor}"></c:out></td>
												<td><c:out value="${R.Vendor}"></c:out></td>
												<td><c:out value="${R.Author}"></c:out></td>
												<td><c:out value="${R.Edition}"></c:out></td>
												<td><c:out value="${R.InDate}"></c:out></td>
												<td><c:out value="${R.PrizePerBook}"></c:out></td>
												<td><c:out value="${R.PublicationYear}"></c:out></td>
												<td><c:out value="${R.Publisher}"></c:out></td>
												<td><c:out value="${R.CollegeRemark}"></c:out></td>
												<td><c:out value="${R.DiscountRemark}"></c:out></td>
												<td><input
													onclick="document.getElementById('Oprations').style.display='block'"
													type="submit" id="QuantityButton" class="btn btn-default"
													value="Quantity"></td>
												<td><input
													onclick="document.getElementById('TransactionPopup').style.display='block'"
													type="submit" id="TransactionButton"
													class="btn btn-default" value="Transaction"></td>

												<input type="hidden" id="quantity" value="${R.Quantity }">
												<input type="hidden" id="accessionId"
													value="${R.AccessionId }">
												<input type="hidden" id="vendor" value="${R.Vendor }">
												<input type="hidden" id="invoiceno" value="${R.InvoiceNo }">
												<input type="hidden" id="invoicedate"
													value="${R.InvoiceDate }">

												<input type="hidden" id="transactionId"
													value="${R.TransactionMasterId }">
												<input type="hidden" id="inDate" value="${R.InDate }">
												<input type="hidden" id="totalAmount"
													value="${R.TotalAmountOfBook }">
												<input type="hidden" id="discountIn"
													value="${R.TotalDiscountAmount }">
												<input type="hidden" id="discountAmount"
													value="${R.Discount }">
												<input type="hidden" id="payableAmount"
													value="${R.TotalPayableAmount }">
												<input type="hidden" id="withoutdiscountAmount"
													value="${R.TotalWithoutDiscount }">


												<%-- <td><a href="<c:url value='/Delete.html/${R.RackMasterId}'/>"><span class="glyphicon glyphicon-trash"></span></a></td> --%>

											</tr>
										</c:forEach>
									</tbody>
								</table>

								<h3>${NoBookMsgForThisCategory}</h3>

								<!-- <input onclick="document.getElementById('Oprations').style.display='block'" type="submit" id="QuantityButton" class="btn btn-default" value="Quantity">
							<input onclick="document.getElementById('TransactionPopup').style.display='block'" type="submit" id="TransactionButton" class="btn btn-default" value="Transaction">
							 -->

							</div>
						</div>
					</div>
					<!-- /.portlet -->
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<!-- <script>
		var elementid = id;
		alert("Hello "+elementid);
		var r = confirm("Are u sure");
		if(r == true){
		$.getJSON('delete.html',(elementid : elementid)).done(function(data){
			document.getElementById(elementid.trim()).remove();
			alert(data);
		}));
		}
</script> -->

	<!-- <script>
$(document).ready(function(){
	$("#del").click(function(){
		var id = $("#rackid").val($(this).find("td").eq(0).text());
		alert("Hello "+id);
	});
	
});

</script> -->

	<script type="text/javascript">
		$("#QuantityButton").click(function() {
			//alert("HooBhoo");
			$("#rackid").val($(this).find("td").eq(0).text());
			$("#racknumber").val($(this).find("td").eq(1).text());
			var modal = document.getElementById('Oprations');
			// When the user clicks anywhere outside of the modal, close it
			window.onclick = function(event) {
				alert(value);
				if (event.target == modal) {
					modal.style.display = "none";
				}
			}
		});
	</script>

	<div class="container">
		<div id="Oprations" class="modal">

			<div class="panel-collapse collapse in">
				<div class="portlet-body">


					<form class="modal-content animate" action="UpdateRackData.html">

						<div class="imgcontainer">
							<span
								onclick="document.getElementById('Oprations').style.display='none'"
								class="close" title="Close Modal">&times;</span>
						</div>

						<div class="container">


							<div class="form-inline">

								<div class="form-group">
									<label for="Quantity">Quantity :</label> <input type="text"
										class="form-control" id="quantityPopup" placeholder="Quantity"
										readonly name="Quantity"
										style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;">
								</div>

								<div class="form-group">
									<label for="AccessionId">AccessionId :</label> <input
										type="text" class="form-control" id="accessionIdPopup"
										placeholder="AccessionId" readonly name="AccessionId"
										style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;">
								</div>


								<div class="form-group">
									<label for="Vendor">Vendor :</label> <input type="text"
										class="form-control" id="vendorPopup" placeholder="Vendor"
										readonly readonly name="Vendor"
										style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;">
								</div>

								<div class="form-group">
									<label for="InvoiceNo">Invoice No :</label> <input type="text"
										class="form-control" id="invoiceNoPopup"
										placeholder="InvoiceNo" readonly name="InvoiceNo" readonly
										style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;">
								</div>

								<div class="form-group">
									<label for="InvoiceDate">Invoice Date :</label> <input
										type="text" class="form-control" id="invoiceDatePopup"
										placeholder="InvoiceDate" readonly name="InvoiceDate"
										style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;">
								</div>

							</div>
							<br>

							<%-- <center>
						<button type="submit" name="Update"
							onclick="document.getElementById('Oprations').style.display='none'"
							class="btn btn-xs btn-success">Update Rack</button>

						<!-- <button type="submit" name="Delete" value=""
						onclick="document.getElementById('Oprations').style.display='none'"
						class="btn btn-xs btn-success">Delete Year</button> -->
					</center> --%>

						</div>
					</form>
				</div>

			</div>
		</div>
	</div>

	<script type="text/javascript">
		$("#TransactionButton").click(function() {
			//alert("HooBhoo");
			$("#rackid").val($(this).find("td").eq(0).text());
			$("#racknumber").val($(this).find("td").eq(1).text());
			var modal = document.getElementById('TransactionPopup');
			// When the user clicks anywhere outside of the modal, close it
			window.onclick = function(event) {
				//alert(value);
				if (event.target == modal) {
					modal.style.display = "none";
				}
			}
		});
	</script>



	<div class="container">
		<div id="TransactionPopup" class="modal">

			<div class="panel-collapse collapse in">
				<div class="portlet-body">


					<form class="modal-content animate" action="UpdateRackData.html">

						<div class="imgcontainer">
							<span
								onclick="document.getElementById('TransactionPopup').style.display='none'"
								class="close" title="Close Modal">&times;</span>
						</div>

						<div class="container">
							<div class="form-horizontal">
								<!-- <div class="form-group">
												<label style="width:180px; height:35px; for="TransactionId">Transaction Id :</label> 
												<input type="text" class="form-control" id="transactionIdPopup" placeholder="TransactionId" readonly name="TransactionId" style="width:300px; height:35px;line-height:20px;margin:0;padding:0;">
											</div> -->

								<div class="form-group">
									<label for="InDate">In Date:</label> <input type="text"
										class="form-control" id="inDatePopup" placeholder="InDate"
										readonly name="InDate"
										style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;">
								</div>

								<div class="form-group">
									<label for="TotalAmount">Total Amount:</label> <input
										type="text" class="form-control" id="totalAmountPopup"
										placeholder="TotalAmount" readonly name="TotalAmount"
										style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;">
								</div>

								<div class="form-group">
									<label for="DiscountIn">Discount in %:</label> <input
										type="text" class="form-control" id="discountAmountPopup"
										placeholder="DiscountIn" readonly readonly name="DiscountIn"
										style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;">
								</div>
								<!-- discountAmountPopup -->

								<div class="form-group">
									<label for="DiscountAmount">Discount Amount:</label>
									<!-- discountInPopup -->
									<input type="text" class="form-control" id="discountInPopup"
										placeholder="DiscountAmount" readonly name="DiscountAmount"
										style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;">
								</div>

								<div class="form-group">
									<label for="PayableAmount">Payable Amount:</label> <input
										type="text" class="form-control" id="PayableAmountPopup"
										placeholder="PayableAmount" readonly name="PayableAmount"
										style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;">
								</div>

								<div class="form-group">
									<label for="WithoutDiscount">Without Discount:</label> <input
										type="text" class="form-control" id="withoutDiscountPopup"
										placeholder="WithoutDiscount" readonly name="WithoutDiscount"
										style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;">
								</div>
							</div>
							<br>
							<%-- <center>
						<button type="submit" name="Update"
							onclick="document.getElementById('Oprations').style.display='none'"
							class="btn btn-xs btn-success">Update Rack</button>

						<!-- <button type="submit" name="Delete" value=""
						onclick="document.getElementById('Oprations').style.display='none'"
						class="btn btn-xs btn-success">Delete Year</button> -->
					</center> --%>

						</div>
					</form>
				</div>

			</div>
		</div>
	</div>





	<script>
		var Quantity = $("#quantity").val();
		var AccessionId = $("#accessionId").val();
		var Vendor = $("#vendor").val();
		var Invoiceno = $("#invoiceno").val();
		var Invoicedate = $("#invoicedate").val();

		var TransactionId = $("#transactionId").val();
		var InDate = $("#inDate").val();
		var TotalAmount = $("#totalAmount").val();
		var DiscountIn = $("#discountIn").val();
		var DiscountAmount = $("#discountAmount").val();
		var PayableAmount = $("#payableAmount").val();
		var WithoutdiscountAmount = $("#withoutdiscountAmount").val();

		//alert("Quantity " + Quantity);

		$("#quantityPopup").val(Quantity);
		$("#accessionIdPopup").val(AccessionId);
		$("#vendorPopup").val(Vendor);
		$("#invoiceNoPopup").val(Invoiceno);
		$("#invoiceDatePopup").val(Invoicedate);

		$("#transactionIdPopup").val(TransactionId);
		$("#inDatePopup").val(InDate);
		$("#totalAmountPopup").val(TotalAmount);
		$("#discountInPopup").val(DiscountIn);
		$("#discountAmountPopup").val(DiscountAmount);
		$("#PayableAmountPopup").val(PayableAmount);
		$("#withoutDiscountPopup").val(WithoutdiscountAmount);
	</script>




</body>
</html>