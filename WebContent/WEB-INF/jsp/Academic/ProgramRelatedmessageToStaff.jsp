<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#StaffType").change(function(){
		var Stafftype=$("#StaffType").val();
		//alert(Stafftype);
		$("#StudentData").empty();
		$.getJSON('getStaffList.html',{Stafftype:Stafftype}).done(function(data){
			//alert("Inside");
			 for (var i=0;i<data.length;i++)
			{
				
			$("#StudentData").append("<tr><td><input type='checkbox' name='Staff"+i+"' value='"+data[i].staffRegistrationId+"'  ></td><td>"+data[i].staffRegistrationId+"</td><td>"+data[i].StaffName +"</td><td>"+data[i].SatffDepartment+"</td><td>"+data[i].StaffEmail+"</td><td>"+data[i].StaffType+"</td></tr>");
			
			} 
		});
		
	});
	$("#SubmitCheck").click(function(){
		var numberOfChecked = $('input:checkbox:checked').length;
		$("#Count").val(numberOfChecked);
		//alert("check count"+numberOfChecked);
	});		

	$("#SubmitCheck123").click(function(){
		var numberOfChecked = $('input:checkbox:checked').length;
		$("#Count").val(numberOfChecked);
		//alert("check count"+numberOfChecked);
	});
	
	$("#CheckAll").click(function(){
 		$('input:checkbox').not(this).prop('checked', this.checked);
	});	
});

</script>
</head>
<body>
<div class="page-content">
		<div class="page-header">
			<center>
				<h1><b>Program Related Message For Staff</b></h1>
			</center>
		</div>
		<form action="sendProgramRelatedToStaff.html"  method="post" id="" class="form-horizontal">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="id-date-picker-1">Date :</label>
						<div class="col-sm-9">
							<input class="col-xs-3 " name="DateCurrent" type="text"
								value="${currentDate }" readonly="true" />
						</div>
					</div>
				<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							Select Staff Type:<span style="color:red;">*</span></label>

						<div class="col-sm-9">
							<select class="col-xs-3" name="StaffType" id="StaffType" required>
						<option value="">------Select Staff Type-------</option>
							<option value="Teaching">Teaching</option>
							<option value="Non Teaching">Non Teaching</option>	
							</select>
						</div>
					</div>
				
				<div class="form-group">

						<label class="col-sm-3 control-label no-padding-right">
							Program Related Message:<span style="color:red;">*</span></label>
						<div class="col-sm-6">
							<textarea class="form-control" id="" rows="10"
								placeholder="Notice To Student" name="ProgramRelatedMessage" required></textarea>
						</div>
					</div>
			</div>
		</div>
		
	<hr />
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table id="simple-table" class="table  table-bordered table-hover">
							<thead>
								<tr>
								<th><input type="checkbox" id="CheckAll"></th>
										<th>Staff Id</th>
										<th>Staff Name</th>
										<th>Department </th>
										<th>Staff Email</th>
										<th>Staff Type</th>
								</tr>
							</thead>

							<tbody id="StudentData">
								
							</tbody>
						</table>
						<input type="hidden" id="Count" name="CheckCount">
							<button type="submit" class="btn btn-sm btn-success" name="ProgramRelatedessageToStaff"
								id="SubmitCheck">
								Send... <i
									class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
							</button>
							<button type="submit" class="btn btn-sm btn-success" name="SendSMS"
								id="SubmitCheck123">
								Send SMS... <i
									class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
							</button>
					</div>
				</div>
			</div>
			<!-- /.span -->
		</div>
		</form>
	</div>
	<br><br><br>
</body>
</html>