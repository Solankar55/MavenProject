<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>Login Page</title>

<meta name="description" content="User login page" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<script type="text/javascript">
$(document).ready(function() {
	//alert("Hello");
	
	$("#StudentEmail").blur(function(){
		var StudEmail=$("#StudentEmail").val();
		var studContact=$("#StudentContactNumber").val();
		$.getJSON('checkStudentEmailJSON.html',{StudEmail:StudEmail,studContact:studContact}).done(function(data){
			//alert("Email Length"+data.length);
			if(data.length==0)
				{
					$("#ButtonController").hide();
				}
			else
				{
					alert("Please Enter Another Email Address/Contact Number");
					$("#ButtonController").hide();
				}
		});
		
	});
	
	$("#StudentUserName").blur(function(){
		var UserNameValue=$("#StudentUserName").val();
		var StudEmail=$("#StudentEmail").val();
		var studContact=$("#StudentContactNumber").val();
		//alert(UserNameValue);
		$.getJSON('checkStudentUserNameJSON.html',{UserNameValue:UserNameValue,StudEmail:StudEmail,studContact:studContact}).done(function(data){
			//alert("UserNameValue"+data.length);
			if(data.length!=0)
				{
					alert("Please Use Another User Name! User Name Already in Used!!");
					$("#ButtonController").hide();
				}
			else
				{
					$("#ButtonController").show();
				}
		});
	}); 
	$("#register").click(function() {
		//alert("Good!!Registration Successfully Completed");
        //location.href = "PayMakePayment.html";
	});
	
	
});
</script>
<script type="text/javascript">
function check_pass() {
    if (document.getElementById('StudentPassword').value ==
            document.getElementById('StudConfirmPassword').value) {
        document.getElementById('register').disabled = false;
    } else {
    	alert("Password not matched.");
        document.getElementById('register').disabled = true;
    }
}
</script>	
</head>
<body class="login-layout" background="images/avatars/im.jpg">
<%-- <div class="alert alert-success">
<button class="close" data-dismiss="alert"></button>
<strong><font>${message}</font></strong>
</div> --%>
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<center>
					<h4 style="color: red;">${Message }</h4>
				</center>
				<center>
					<h4 style="color: red;">${MessageToAccount }</h4>
				</center>
				<center>
					<h4 style="color: red;">${MessageToStudent }</h4>
				</center>
				<center>
					<h4 style="color: red;">${RegProc }</h4>
				</center>
				<%--     <center><h4 style="color: red;">${Message }</h4></center> --%>
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="ace-icon fa fa-university red"></i> <span
									class="black">SITABAI THITE COLLEGE OF PHARMACY</span><br>
							</h1>
							<h4 class="black" id="id-company-text">&copy; SHIRUR</h4>
						</div>

						<div class="space-6"></div>

						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class=""><center><b>Administrator Login</b></center><br>
											<i class="ace-icon fa fa-hand-o-down green"></i><b> Please Enter
											Your Information</b>
										</h4>

										<div class="space-6"></div>

										<form action="HomeP.html" method="post">
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="text" class="form-control" name="username"
														placeholder="Username" /> <i class="ace-icon fa fa-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="password" class="form-control" name="password"
														placeholder="Password" /> <i class="ace-icon fa fa-lock"></i>
												</span>
												</label>

												<div class="space"></div>

												<div class="clearfix">
													<%-- <label class="inline"> <input type="checkbox"
														class="ace" /> <span class="lbl"> Remember Me</span>
													</label> --%>

													<button type="submit"
														class="width-35 pull-right btn btn-sm btn-primary">
														<i class="ace-icon fa fa-key"></i> <span
															class="bigger-110">Login</span>
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
										</form>

									</div>
									<!-- /.widget-main -->

									<div class="toolbar clearfix">
										<!-- <div>
											<a href="#" data-target="#forgot-box"
												class="forgot-password-link"> <i
												class="ace-icon fa fa-arrow-left"></i>forgot password
											</a>
										</div> -->

										<!-- <div>
											<a href="#" data-target="#signup-box"
												class="user-signup-link"> Student Registration <i
												class="ace-icon fa fa-arrow-right"></i>
											</a>
										</div> -->
									</div>
								</div>
								<!-- /.widget-body -->
							</div>
							<!-- /.login-box -->

							<div id="forgot-box" class="forgot-box widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header red lighter bigger">
											<i class="ace-icon fa fa-key"></i> Retrieve Password
										</h4>

										<div class="space-6"></div>
										<p>Enter your email and to receive instructions</p>

										<form action="sendEMail.html" method="post">
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="text" name="emailTo" class="form-control"
														placeholder="Email" /> <i class="ace-icon fa fa-envelope"></i>
												</span>
												</label>

												<div class="clearfix">
													<button type="submit"
														class="width-35 pull-right btn btn-sm btn-danger">
														<i class="ace-icon fa fa-lightbulb-o"></i> <span
															class="bigger-110">Send Me!</span>
													</button>
												</div>
											</fieldset>
										</form>
									</div>
									<!-- /.widget-main -->

									<div class="toolbar center">
										<a href="#" data-target="#login-box"
											class="back-to-login-link"> Back to login <i
											class="ace-icon fa fa-arrow-right"></i>
										</a>
									</div>
								</div>
								<!-- /.widget-body -->
							</div>
							<!-- /.forgot-box -->

							<div id="signup-box" class="signup-box widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header green lighter bigger">
											<i class="ace-icon fa fa-users blue"></i> <b>New Student
											Registration</b>
										</h4>
										<font color="blue">Please,fill the correct information as below information can not be changed.</font>
										<div class="space-6"></div>
										<!-- <p>Enter your details to begin:</p> -->
										<h6 style="color: red;">All Field Are Compulsory!!!</h6>
										<form action="RegisterStudent.html" method="post">
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														name="StudentName" type="text" id="StudentName"
														class="form-control" placeholder="Student First Name Only"
														required pattern="[a-zA-Z]+"
														title="Please Enter First Name Only" /> <i
														class="ace-icon fa fa-user"></i>
												</span>
												</label> 
												<%-- <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														name="StudentAddress" type="text" id="StudentAddress"
														class="form-control" placeholder="Address" required
														pattern="[a-z A-Z 0-9._%+-]+"
														title="Please Enter Correct Address" /> <i
														class="ace-icon fa fa-address"></i>
												</span>
												</label>  --%>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														name="StudentContactNumber" type="text"
														id="StudentContactNumber" class="form-control"
														placeholder="Contact No" required maxlength="10" 
														pattern="[789][0-9]{9}" minlength="10"
														title="Please Enter Correct Mobile Number" /> <i
														class="ace-icon fa fa-phone-square"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														name="StudentEmail" type="email" id="StudentEmail"
														class="form-control" placeholder="Email" required
														pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" /> <i
														class="ace-icon fa fa-envelope"></i>
												</span>
												</label>
												<div id="UserDisplay" style="display: ;">
													<label class="block clearfix"> <span
														class="block input-icon input-icon-right"> <input
															name="StudentUserName" type="text" class="form-control"
															id="StudentUserName" placeholder="Username" required
															pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
															title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" />
															<i class="ace-icon fa fa-user"></i>
													</span>
													</label> <label class="block clearfix"> <span
														class="block input-icon input-icon-right"> <input
															name="StudentPassword" type="password"
															id="StudentPassword" class="form-control"
															placeholder="Password" required
															pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
															title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" 
															/>
															<i class="ace-icon fa fa-lock"></i>
													</span>
													</label> <label class="block clearfix"> <span
														class="block input-icon input-icon-right"> <input
															type="password" class="form-control"
															id="StudConfirmPassword" placeholder="Repeat password"
															required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
															title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" 
															onchange='check_pass();'/>
															<i class="ace-icon fa fa-retweet"></i>
													</span>

													</label>
												</div>
												<%-- <label class="block"> <input id="Agreement" type="checkbox"
													class="ace" /> <span class="lbl"> I accept the <a
														href="#">User Agreement</a>
												</span>
												</label> --%>

												<!-- <div class="space-24"></div> -->

												<div id="ButtonController" style="display: none;"
													class="clearfix">
													<button type="reset" class="width-30 pull-left btn btn-sm">
														<i class="ace-icon fa fa-refresh"></i> <span
															class="bigger-110">Reset</span>
													</button>

													<button id="register" type="submit"
														class="width-65 pull-right btn btn-sm btn-success" disabled="true">
														<span class="bigger-110">Register</span> <i
															class="ace-icon fa fa-arrow-right icon-on-right"></i>
													</button>
												</div>
											</fieldset>
										</form>
									</div>

									<div class="toolbar center">
										<a href="#" data-target="#login-box"
											class="back-to-login-link"> <i
											class="ace-icon fa fa-arrow-left"></i> Back to login
										</a>
									</div>
								</div>

							</div>
							<!-- /.signup-box -->
						</div>
						<!-- /.position-relative -->


					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.main-content -->
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->
	<script src="<%=request.getContextPath()%>/js/jquery-2.1.4.min.js"></script>

	<!-- <![endif]-->

	<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
	<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
			jQuery(function($) {
			 $(document).on('click', '.toolbar a[data-target]', function(e) {
				e.preventDefault();
				var target = $(this).data('target');
				$('.widget-box.visible').removeClass('visible');//hide others
				$(target).addClass('visible');//show target
			 });
			});			
		</script>
</body>
</html>