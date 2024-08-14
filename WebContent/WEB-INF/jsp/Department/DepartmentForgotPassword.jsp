<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="description" content="User login page" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

</head>
<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="ace-icon fa fa-university red"></i> <span
									class="white">Department Login </span><br>
							</h1>
							<h4 class="blue" id="id-company-text">&copy;
								S.T.C.O.P.Shirur</h4>
								<h4 class="blue" id="id-company-text">
								Department</h4>
						</div>
						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="ace-icon fa fa-hand-o-down green"></i> Please Enter
											Your Information
										</h4>

										<div class="space-6"></div>

										<form action="GetDepartmentPassword.html" method="post">
											<fieldset>
												<label class="block clearfix"> <span 
													class="block input-icon input-icon-right"> <input
														type="email" class="form-control" name="EmailAddress"
														placeholder="Email Address" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"/> <i class="ace-icon fa fa-user"></i>
												</span>
												</label> 
												<div class="clearfix">
													<button type="submit" name="GetPass"
														class="width-65 pull-left btn btn-sm btn-primary">
														<i class="ace-icon fa fa-key"></i> <span
															class="bigger-110">Get Password</span>
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
</html>