<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accession Library Register</title>

<link href="http://www.jqueryscript.net/css/jquerysctipttop.css"
	rel="stylesheet" type="text/css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

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

form label {
	border: 0;
	margin-bottom: 3px;
	display: block;
	width: 100%;
}

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


<script type="text/javascript">
$(document).ready(function(){
	 $("#donarName").hide();
	 $("#Purchaseupdate").hide();
	 $("#vendorDiscountB").hide();
	$("#prizeperbook").change(function(){
		var prizeperbook=$("#prizeperbook").val();
		var quantity=$("#quantity").val();
		$("#totalamount").val(prizeperbook*quantity);
	});
	$("#quantity").change(function(){
		var prizeperbook=$("#prizeperbook").val();
		var quantity=$("#quantity").val();
	    var tot=prizeperbook*quantity;
		$("#totalamount").val(tot);
		var discount=$("#discount").val();
	    
		if(discount==0)
			{
			$("#paybleAmount").val(tot);
			}
		else
			{
			var payA=(tot*discount)/100;
			var totA=tot-payA;
			$("#paybleAmount").val(totA);
			}
		
		
	});
	$("#discount").blur(function(){
		var totalamount=$("#totalamount").val();
		var discount=$("#discount").val();
		var payA=(totalamount*discount)/100;
		$("#paybleAmount").val(totalamount-payA);
	});
	
	$("#AmountType").change(function(){
		var AmountType=$("#AmountType").val();
	   if(AmountType=="Donate")
		   {
		     $("#donarName").show();
		   }
	   else
		   {
		   $("#donarName").hide();
		   }
	});
	$("#vendorName").change(function(){
		var id=$("#vendorName").val();
		 $("#vendorDiscountB").show();
		$.getJSON('venderDiscountA.html',{id:id}).done(function(data){
			
			$("#vendorDiscountA").val(data[0].discountA);
		});
	});
	
	
});
</script>

<script type="text/javascript">



$(document).ready(function(){
	$("#AmountType").change(function(){
		var dissSt=$("#AmountType").val();
		var vendorDisco1=$("#vendorDiscountA").val(); 
		var paybleAmount1=$("#paybleAmount").val();
		   var vendorDisco=parseInt(vendorDisco1);
		   var paybleAmount=parseInt(paybleAmount1);
		if(dissSt=="BalancedDiscountedAmount")
			{
			if(vendorDisco>paybleAmount)
			{
			alert(vendorDisco+">"+paybleAmount);
			 var total=vendorDisco-paybleAmount;
			   $("#vendorDiscountA").val(total); 
			      $("#paybleAmount").val(0);
			}
			
		
			else if(vendorDisco<paybleAmount)
					{
					alert(vendorDisco+"<"+paybleAmount);
					   var total=paybleAmount-vendorDisco;
					   $("#vendorDiscountA").val(0); 
					      $("#paybleAmount").val(total);
					}
				 
				else  if(vendorDisco==paybleAmount)
					{
					alert(vendorDisco+"="+paybleAmount);
					      $("#vendorDiscountA").val(0); 
					      $("#paybleAmount").val(0);
					}
			}
				else
					{
					
					var prizeperbook=$("#prizeperbook").val();
					var quantity=$("#quantity").val();
				    var tot=prizeperbook*quantity;
					$("#totalamount").val(tot);
					var discount=$("#discount").val();
				    
					if(discount==0)
						{
						$("#paybleAmount").val(tot);
						}
					else
						{
						var payA=(tot*discount)/100;
						var totA=tot-payA;
						$("#paybleAmount").val(totA);
						}
					}
				
			
			
			
	});
	
	
	
});
 var showData=function($this)
 {
	 $("#QuantityId").val($($this).find("td").eq(0).text());
     $("#YearID").val($($this).find("td").eq(1).text());
	 $("#invoiceno").val($($this).find("td").eq(2).text());
	 $("#invoicedate").val($($this).find("td").eq(3).text());
	 $("#title").val($($this).find("td").eq(4).text());
	 $("#author").val($($this).find("td").eq(5).text());
	 $("#edition").val($($this).find("td").eq(6).text());
	 $("#publicationyear").val($($this).find("td").eq(7).text());
	 $("#publisher").val($($this).find("td").eq(8).text());
	 $("#classnumber").val($($this).find("td").eq(9).text());
	 $("#bookfor").val($($this).find("td").eq(10).text());
	 $("#booktype").val($($this).find("td").eq(11).text());
	 $("#sizeofbook").val($($this).find("td").eq(12).text());
	 $("#subject").val($($this).find("td").eq(13).text());
	 $("#vendorName").val($($this).find("td").eq(14).text());
	 $("#prizeperbook").val($($this).find("td").eq(15).text());
	 $("#indate").val($($this).find("td").eq(16).text());
	 $("#quantity").val($($this).find("td").eq(17).text());
	 $("#totalamount").val($($this).find("td").eq(18).text());
	 $("#discount").val($($this).find("td").eq(19).text());
	 $("#paybleAmount").val($($this).find("td").eq(20).text());
	 $("#remark").val($($this).find("td").eq(21).text());
	 $("#AmountType").val($($this).find("td").eq(22).text());
	 $("#donarName").val($($this).find("td").eq(23).text()); 
	 var id=$("#vendorName").val();
	 $("#vendorDiscountB").show();
	 $("#Purchaseupdate").show();
	 $("#Purchase").hide();
	$.getJSON('venderDiscountA.html',{id:id}).done(function(data){
		
		$("#vendorDiscountA").val(data[0].discountA);
	});
 }
</script>
</head>
<body>

	<div id="page-wrapper">

		<div class="page-content">
			<div class="page-header">
				<center>
					<h1><b>Accession Library Register</b></h1>
				</center>
			</div>


			<form:form role="form" action="AccessionDataSave.html"
				commandName="alr" method="post" name="BookIssueForm">
				<div  id="vendorDiscountB">
					
						<label for="InvoiceNo">VendorPendingAmount</label> <input type="text"
							class="form-control" id="vendorDiscountA" 
							name="vendorDiscountA">
					         
				</div>
				<input type="hidden" class="form-control" name="orignaalInvice" id="originalInvoiceNo" value="${id}">
				<input type="hidden" name="QuantityId" id="QuantityId" value="0">
				
				<div class="col-md-3">
					<label> Academic Year <br>
					</label><select size="1" id="YearID" name="YearID"
						aria-controls="example-table"
						style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;">
						<option value="">Select Academic Year</option>
						<c:forEach var="v" items="${YearList}">
							<option value="${v.key}">${v.value}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label for="InvoiceNo">Invoice No</label> <input type="text"
							class="form-control" id="invoiceno" placeholder="FY-1234"
							name="InvoiceNo">
					</div>
				</div>

				<div class="col-md-3">
					<div class="form-group">
						<label for="InviceDate">Invoice Date</label> <input type="Date"
							class="form-control" id="invoicedate" name="InviceDate">
					</div>
				</div>

				<div class="col-md-3" style="display: none;">
					<div class="form-group">
						<label for="AccessionId">Accession Id</label> <input type="text"
							class="form-control" id="accessionid" placeholder="1"
							name="AccessionId" value="1">
					</div>
				</div>

				<div class="col-md-3">
					<div class="form-group">
						<label for="Title">Title</label> <input type="text"
							class="form-control" id="title" placeholder="Basic Electrical"
							name="Title">
					</div>
				</div>

				<div class="col-md-3">
					<div class="form-group">
						<label for="Author">Author</label> <input type="text"
							class="form-control" id="author" placeholder="Shantanu Roy"
							name="Author">
					</div>
				</div>

				<div class="col-md-3">
					<div class="form-group">
						<label for="Edition">Edition</label> <input type="text"
							class="form-control" id="edition" placeholder="Second"
							name="Edition">
					</div>
				</div>

				<div class="col-md-3">
					<div class="form-group">
						<label for="PublicationYear">Publication Year</label> <input
							type="text" class="form-control" id="publicationyear"
							placeholder="2008" name="PublicationYear">
					</div>
				</div>

				<div class="col-md-3">
					<div class="form-group">
						<label for="Publisher">Publisher</label> <input type="text"
							class="form-control" id="publisher" placeholder="Tech Max"
							name="Publisher">
					</div>
				</div>

				<div class="col-md-3">
					<div class="form-group">
						<label for="ClassNumber">Class Number</label> <input type="text"
							class="form-control" id="classnumber" 
							name="ClassNumber">
					</div>
				</div>

				<div class="col-md-3">
					<label> Book For <br> <select size="1" id="bookfor"
						name="BookFor" aria-controls="example-table"
						style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;">
							<option value="">Select Book For</option>
							<option value="PostGraduation">PostGraduation</option>
							<option value="Degree">Degree</option>
							<option value="Diploma">Diploma</option>
							<option value="Other">Other</option>
					</select>
					</label>
				</div>

				<div class="col-md-3">
					<label>Book Type</label> <select id="booktype" name="BookType"
						style="width: 300px; height: 35px; margin: 0; padding: 0;">
						<option value="">Select Book Type</option>
						<c:forEach var="BTM" items="${BTMList }">
							<option value="${BTM.key }">${BTM.value}</option>
						</c:forEach>

					</select>
				</div>

				<div class="col-md-3">
					<div class="form-group">
						<label for="SizeOfBook">Pages/Size Of Book</label> <input type="text"
							class="form-control" id="sizeofbook" placeholder="230"
							name="SizeOfBook">
					</div>
				</div>

				<div class="col-md-3">
					<label>Subject</label> <select id="subject" name="Subject"
						style="width: 300px; height: 35px; margin: 0; padding: 0;">
						<option value="">Select Subject</option>
						<c:forEach var="S" items="${Slist}">
							<option value="${S.key}">${S.value}</option>
						</c:forEach>

					</select>
				</div>

				<div class="col-md-3">
					
						<label for="Vendor">Vendor</label> 
						<select id="vendorName" style="width: 300px; height: 35px; margin: 0; padding: 0;" name="Vendor">   
						<option value="">Select Vendor</option>
						<c:forEach var="v" items="${vendorNameL}">
						<option value="${v.key}">${v.value}</option>
						</c:forEach>
						</select>
					
				</div>

				<div class="col-md-3">
					<div class="form-group">
						<label for="PrizePerBook">Price Per Book</label> <input
							type="text" class="form-control" id="prizeperbook"
							placeholder="290/-" name="PrizePerBook">
					</div>
				</div>

				<div class="col-md-3">
					<div class="form-group">
						<label for="InDate">In Date</label> <input type="Date"
							class="form-control" id="indate" name="InDate">
					</div>
				</div>

				<div class="col-md-3">
					<div class="form-group">
						<label for="Quantity">Quantity</label> <input type="text"
							class="form-control" id="quantity" placeholder="2"
							name="Quantity">
					</div>
				</div>
                <div class="col-md-3">
					<div class="form-group">
						<label for="TotalAmount">Total Amount Of Book</label> <input
							type="text" class="form-control" id="totalamount"
							placeholder="1034/-" name="TotalAmount">
					</div>
				</div>

				<div class="col-md-3">
					<div class="form-group">
						<label for="Discount">Discount</label> <input type="text"
							class="form-control" id="discount" placeholder="25%"
							name="Discount" value="0">
					</div>
				</div>

				<div class="col-md-3">
					<div class="form-group">
						<label for="TotalAmount">Payable Amount Of Book</label> <input
							type="text" class="form-control" id="paybleAmount"
							placeholder="1034/-" name="paybleAmount">
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label for="DiscountRemark">Remark</label> <input
							type="text" class="form-control" id="remark"
							placeholder="Discount" name="purRemark" >
					</div>
				</div>
				
                     <div class="col-md-3">
					<label> Status <br> <select size="1" id="AmountType"
						name="DiscountRemark" aria-controls="example-table"
						style="width: 300px; height: 35px; line-height: 20px; margin: 0; padding: 0;">
							<option value="">Select Amount Type</option>
							<option value="WithDiscount">WithDiscount</option>
							<option value="WithoutDiscount">WithoutDiscount</option>
							<option value="BalancedDiscountedAmount">BalancedDiscountedAmount</option>
							<option value="Donate">Donate</option>
							
					</select>
					</label>
				</div>
				<div class="col-md-3">
					<div class="form-group" id="donarName">
						<label for="DonarName">DonarName</label> <input
							type="text" class="form-control" id="DonarName"
							placeholder="DonarName" name="donarName" >
					</div>
				</div>
				
				<div class="col-md-3" style="display: none;">
					<div class="form-group">

						<input type="text" class="form-control" id="count"
							placeholder="count" name="count" readonly="readonly">
					</div>
				</div>
				<div class="row">
					<div class="col-md-12"></div>
					<div class="col-md-12"></div>
					<div class="col-md-4"></div>
					<div class="col-md-5">
						<input type="submit" id="Purchase" name="PurchaseBook" class="btn btn-default"
							value="Purchase" >
							<input type="submit" id="Purchaseupdate" name="UopdatePurchaseBook" class="btn btn-default"
							value="Update" >
								</div>
							</div>
							
						<div class="row" >

						<div class="col-lg-12">
					    <div class="portlet portlet-red">
						<div class="portlet-heading">
							<div class="portlet-title">



								<h4>Product Tables </h4>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="portlet-body">
							<div class="table-responsive">
								<table id="dynamic-table" class="table  table-bordered table-hover">
									<thead>
										<tr >
											<th>QuantityId</th>
											<th>YearID</th>
											<th>InvoiceNo</th>
											<th>InvoiceDate</th>
											<th>Title</th>
											<th>Author</th>
											<th>Edition</th>
											<th>PublicationYear</th>
											<th>Publisher</th>
											<th>ClassNumber</th>
											<th>BookFor</th>
											<th>BooktypeId</th>
											<th>SizeOfBook</th>
											<th>LibrarySubjectMasterId</th>
											<th>vendorId</th>
											<th>PrizePerBook</th>
											<th>InDate</th>
											<th>Quantity</th>
											<th>TotalAmount</th>
											<th>Discount</th>
											<th>paybleAmount</th>
											<th>purRemark</th>
											<th>DiscountRemark</th>
											<th>Donar Name</th>
											
											
									    </tr>
									</thead>

									<tbody>
										<c:forEach var="tr" items="${purchaseList}">
											<tr onclick="showData(this);">
												<td><c:out value="${tr.QuantityId}"></c:out></td>
												<td><c:out value="${tr.YearID}"></c:out></td>
												<td><c:out value="${tr.InvoiceNo}"></c:out></td>
												<td><c:out value="${tr.InviceDate}"></c:out></td>
												<td><c:out value="${tr.Title}"></c:out></td>
												<td><c:out value="${tr.Author}"></c:out></td>
												<td><c:out value="${tr.Edition}"></c:out></td>
												<td><c:out value="${tr.PublicationYear}"></c:out></td>
												<td><c:out value="${tr.Publisher}"></c:out></td>
												<td><c:out value="${tr.ClassNumber}"></c:out></td>
												<td><c:out value="${tr.BookFor}"></c:out></td>
												<td><c:out value="${tr.BooktypeId}"></c:out></td>
												<td><c:out value="${tr.SizeOfBook}"></c:out></td>
												<td><c:out value="${tr.LibrarySubjectMasterId}"></c:out></td>
												<td><c:out value="${tr.vendorId}"></c:out></td>
												<td><c:out value="${tr.PrizePerBook}"></c:out></td>
												<td><c:out value="${tr.InDate}"></c:out></td>
												<td><c:out value="${tr.Quantity}"></c:out></td>
												<td><c:out value="${tr.TotalAmount}"></c:out></td>
												<td><c:out value="${tr.Discount}"></c:out></td>
												<td><c:out value="${tr.paybleAmount}"></c:out></td>
												<td><c:out value="${tr.purRemark}"></c:out></td>
												<td><c:out value="${tr.DiscountRemark}"></c:out></td>
												<td><c:out value="${tr.donarName}"></c:out></td>
												
											</tr>
										</c:forEach>
									</tbody>



								</table>
								
							</div>
							<!-- /.table-responsive -->
						</div>
						<!-- /.portlet-body -->
					
					<!-- /.portlet -->

				</div></div></div>




		
			
							
							
							
							
						<!-- <input type="button" id="add2" class="btn btn-default"
							value="Purchase on Discount" onclick="setDiscAmount()">  -->
						<!-- <input type="button" id="donate" class="btn btn-default"
							value="Donate" > <input
							type="button" id="purches" class="btn btn-default"
							value="Purches Against Discount" > -->
					
					</form:form>

				</div>

				<%-- </form:form> --%>

				<hr />

			
		</div>
	</div>
	<br>    
	<br>
	<br>
	<script
		src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.bootstrap.min.js"></script>
	<script type="text/javascript">
		jQuery(function($) {
			//initiate dataTables plugin { "bSortable": false }
			var myTable = $('#dynamic-table').DataTable(
					{
						bAutoWidth : false,
						"aoColumns" : [ null, null, null, null, null, null,
								null, null, null, null, null,null,null,null,null,null,null,null,null,null,null,null,null,null ],
						"aaSorting" : [],
						"scrollX": true

					});
		})
	</script>
</body>
</html>