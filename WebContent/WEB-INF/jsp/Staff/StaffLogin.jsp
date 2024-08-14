<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="description" content="User login page" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

</head>
<body class="login-layout" background="images/avatars/im.jpg" >
	<div class="main-container">
		<div class="main-content">
			<div class="row">
			<center><h4 style="color: red;">${message }</h4></center>
			<center><h4 style="color: red;">${MessageForStaff }</h4></center>
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="ace-icon fa fa-university red"></i> <span
									class="black">SITABAI THITE COLLEGE OF PHARMACY </span><br>
							</h1>
							<h4 class="black" id="id-company-text">&copy; SHIRUR</h4>
						</div>
						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class=" "><b><center>Staff Login</center></b><br>
											<i class="ace-icon fa fa-hand-o-down green"></i><b> Please Enter
											Your Information</b>
										</h4>

										<div class="space-6"></div>

										<form action="StaffLoginController.html" method="post">
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="text" class="form-control" name="Username"
														placeholder="Username" /> <i class="ace-icon fa fa-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="password" class="form-control" name="Password"
														placeholder="Password" /> <i class="ace-icon fa fa-lock"></i>
												</span>
												</label>
											<!-- 	<a style="color: red;" href="ForgotPasswordForStaffUser.html">Forgot Password</a> -->
												<div class="space"></div>

												<div class="clearfix">
													<button type="submit" name="StaffCheck"
														class="width-35 pull-left btn btn-sm btn-primary">
														<i class="ace-icon fa fa-key"></i> <span
															class="bigger-110">Login</span>
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
										</form>

									</div>
									<!-- /.widget-main -->


								</div>
								<!-- /.widget-body -->
							</div>
							<!-- /.login-box -->
						</div>

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


</body>
</body>
</html>