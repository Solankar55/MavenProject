<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="page-content">
		<form action="PrintInvoiceDetail.html" 
			method="post" id="" class="form-horizontal" target="_blank">
			<div class="page-header center">
				<h1>Student Fees Transaction Report</h1>
				<br>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							 Admission Registration Id : <span style="color:red;">*</span></label>
						<div class="col-sm-9">
							<input type="text" name="admissinRegId" class="col-xs-3"
								id="admissinRegId" placeholder="Enter Admission Id" required pattern="[0-9]+" title="Please Enter Correct Charges"  />
						</div>
						<div>
							<br> <br>
							<div class="form-group ">

								<div class="col-sm-3 control-label no-padding-right">
									<button id="printAction" name="printFeesTransaction"
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