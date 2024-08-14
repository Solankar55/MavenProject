<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index Page</title>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />

<meta name="description" content="404 Error Page" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/font-awesome.min.css" />

<!-- page specific plugin styles -->

<!-- text fonts -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/fonts.googleapis.com.css" />

<!-- ace styles -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/ace-skins.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/ace-rtl.min.css" />

<%-- 	<!--[if lte IE 9]>
		  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/ace-ie.min.css" />
		<![endif]--> --%>

<!-- inline styles related to this page -->

<!-- ace settings handler -->
<script src="<%=request.getContextPath()%>/js/ace-extra.min.js"></script>
</head>
<body>
	<%-- <c:redirect url="FirstPage.html"></c:redirect> --%>
	<!-- <a href="AdminLogin.html">Admin Login</a>
<a href="FirstPage.html">Administrator/Principal Login</a>
<a href="FirstPage.html">HOD Login</a>
<a href="DepartmentLogin.html">Department Login</a>
<a href="FirstPage.html">Account Login</a>
<a href="StaffLogin.html">Staff Login</a>
<a href="FirstPage.html">Student Login</a>
<a href="FirstPage.html">Library Login</a> -->
	<!-- <a href=""></a>
<a href=""></a>
<a href=""></a> -->
	<div class="main-content">
		<div class="main-content-inner">

			<div class="page-content">
				<div class="row">

					<div class="col-xs-12">
						<!-- PAGE CONTENT BEGINS -->

						<div class="error-container">
							<div class="well">
								<center>
									<h1 class="blue lighter smaller">
										<img src="images/avatars/uni.png" height="35" width="45">&nbsp;<b>Education
											Management System</b>
									</h1>
								</center>
								<hr />
								<marquee style="color: red;">
									<h3 class="gray lighter smaller">For Login kindly use
										below links with respect to Department</h3>
								</marquee>
								<hr />
								<div class="space"></div>

								<div class="row">
									<div class="col-xs-12">
										<table id="simple-table" class="table">
											<tbody>
												<tr>
													<td><a href="AdminLogin.html"
														class="btn btn-lg btn-danger bigger-230" style=""> <span
															class=" "></span> &nbsp; &nbsp; &nbsp;Admin Login
															&nbsp;&nbsp;
													</a></td>
													<td><a href="PrincipalLogin.html"
														class="btn btn-lg btn-gray bigger-230"> <span
															class=" "></span> Principal Login
													</a></td>
													<td><a href="HODLogin.html"
														class="btn btn-lg btn-purple bigger-230"> <span
															class=" "></span> HOD Login &nbsp; &nbsp; &nbsp;
													</a></td>
													<td><a href="DepartmentLogin.html"
														class="btn btn-lg btn-yellow bigger-230"> <span
															class=" "></span> Department Login
													</a></td>
												</tr>

											</tbody>
										</table>
									</div>
								</div>

								<div class="space"></div>
								
									<div class="row">
											<div class="col-xs-12">
												<table id="" class="table   table-hover">
													<tr>
														<th><a href="AccountLogin.html"
															class="btn btn-lg btn-success bigger-230"> <span></span>
																Accountant Login
														</a></th>
														<th><a href="StaffLogin.html"
															class="btn btn-lg btn-info bigger-230"> <span
																class=" "></span> Staff Login &nbsp; &nbsp; &nbsp;&nbsp;
														</a></th>
														<th><a href="LibraryLogin.html"
															class="btn btn-lg btn-pink bigger-230"> <span
																class=" "></span> Library Login &nbsp;
														</a></th>
														<th><a href="FirstPage.html"
															class="btn btn-lg btn-inverse bigger-230"> <span
																class=" "></span> &nbsp; &nbsp; &nbsp;Student Login
																&nbsp;
														</a></th>
													</tr>


												</table>
											</div>
										</div>
									

								<div class="space"></div>


								<hr />
								<!-- <center>
									<h4 class="blue lighter smaller">Copyright © Sohamshakti
										Industries Pvt Ltd</h4>
								</center>
								<hr /> -->
								<!-- <div class="center">
									<a href="javascript:history.back()" class="btn btn-grey"> <i
										class="ace-icon fa fa-arrow-left"></i> Go Back
									</a> <a href="#" class="btn btn-primary"> <i
										class="ace-icon fa fa-tachometer"></i> Dashboard
									</a>
								</div> -->
							</div>
						</div>

						<!-- PAGE CONTENT ENDS -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
		</div>
	</div>
	<!-- /.main-content -->
</body>
</html>