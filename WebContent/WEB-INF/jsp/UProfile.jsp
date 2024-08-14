<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/font-awesome/4.5.0/css/font-awesome.min.css" />

		<!-- page specific plugin styles -->

		<!-- text fonts -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/fonts.googleapis.com.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="<%=request.getContextPath()%>/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/ace-skins.min.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/ace-rtl.min.css" />

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->
		<script src="<%=request.getContextPath()%>/js/ace-extra.min.js"></script>

		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
		
		<!--[if !IE]> -->
		<script src="<%=request.getContextPath()%>/js/jquery-2.1.4.min.js"></script>

		
		<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->

		<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->
		<script src="<%=request.getContextPath()%>/js/jquery-ui.custom.min.js"></script>
		<script src="<%=request.getContextPath()%>/js/jquery.ui.touch-punch.min.js"></script>
		<script src="<%=request.getContextPath()%>/js/jquery.easypiechart.min.js"></script>
		<script src="<%=request.getContextPath()%>/js/jquery.sparkline.index.min.js"></script>
		<script src="<%=request.getContextPath()%>/js/jquery.flot.min.js"></script>
		<script src="<%=request.getContextPath()%>/js/jquery.flot.pie.min.js"></script>
		<script src="<%=request.getContextPath()%>/js/jquery.flot.resize.min.js"></script>

		<!-- ace scripts -->
		<script src="<%=request.getContextPath()%>/js/ace-elements.min.js"></script>
		<script src="<%=request.getContextPath()%>/js/ace.min.js"></script>



</head>
<body>

	<div class="page-content">
		<div class="page-header">
			<h1>
				Student Profile Page 
			</h1>
		</div>
		<!-- /.page-header -->

		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->

				<div>
					<div id="user-profile-1" class="user-profile row">
						<div class="col-xs-12 col-sm-3 center">
							<div>
								<span class="profile-picture"> <img id="avatar"
									class="editable img-responsive" alt="Alex's Avatar"
									src="<%=request.getContextPath()%>/images/avatars/profile-pic.jpg" />
								</span>

								<div class="space-4"></div>

								<div
									class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
									<div class="inline position-relative">
										<a href="#" class="user-title-label dropdown-toggle"
											data-toggle="dropdown"> <i
											class="ace-icon fa fa-circle light-green"></i> &nbsp; <span
											class="white">Alex M. Doe</span>
										</a>

										
									</div>
								</div>
							</div>

							<!-- <div class="space-6"></div> -->
							
						</div>

						<div class="col-xs-12 col-sm-9">

							<div class="space-12"></div>

							<div class="profile-user-info profile-user-info-striped">
								<div class="profile-info-row">
									<div class="profile-info-name">Student Name:</div>

									<div class="profile-info-value">
										<span class="editable" id="username">alexdoe</span>
									</div>
								</div>

								<div class="profile-info-row">
									<div class="profile-info-name">Gender:</div>

									<div class="profile-info-value">
										<span class="editable" id="">38</span>
									</div>
								</div>

								<div class="profile-info-row">
									<div class="profile-info-name">Address:</div>

									<div class="profile-info-value">
										<span class="editable" id="age">38</span>
									</div>
								</div>

								<div class="profile-info-row">
									<div class="profile-info-name">Date Of Birth:</div>

									<div class="profile-info-value">
										<span class="editable" id="signup">2010/06/20</span>
									</div>
								</div>

								<div class="profile-info-row">
									<div class="profile-info-name">Contact Number:</div>

									<div class="profile-info-value">
										<span class="editable" id="login">3 hours ago</span>
									</div>
								</div>

								<div class="profile-info-row">
									<div class="profile-info-name">Email Address:</div>

									<div class="profile-info-value">
										<span class="editable" id="about">Editable as WYSIWYG</span>
									</div>
								</div>
								
							</div>

							<div class="space-20"></div>

							<div class="hr hr2 hr-double"></div>

							<div class="space-6"></div>
						</div>
					</div>
				</div>

				
				</div>

			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->

	<br><br><br>

	<!--[if !IE]> -->
	<script src="<%=request.getContextPath()%>/js/jquery-2.1.4.min.js"></script>

	<!-- <![endif]-->

	<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
					.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

	<!-- page specific plugin scripts -->

	<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->
	<script src="<%=request.getContextPath()%>/js/jquery-ui.custom.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/js/jquery.ui.touch-punch.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.gritter.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootbox.js"></script>
	<script
		src="<%=request.getContextPath()%>/js/jquery.easypiechart.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/js/bootstrap-datepicker.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/js/jquery.hotkeys.index.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap-wysiwyg.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/select2.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/spinbox.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/js/bootstrap-editable.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/ace-editable.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/js/jquery.maskedinput.min.js"></script>

	<!-- ace scripts -->
	<script src="<%=request.getContextPath()%>/js/ace-elements.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/ace.min.js"></script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function($) {

			//editables on first profile page
			$.fn.editable.defaults.mode = 'inline';
			$.fn.editableform.loading = "<div class='editableform-loading'><i class='ace-icon fa fa-spinner fa-spin fa-2x light-blue'></i></div>";
			$.fn.editableform.buttons = '<button type="submit" class="btn btn-info editable-submit"><i class="ace-icon fa fa-check"></i></button>'
					+ '<button type="button" class="btn editable-cancel"><i class="ace-icon fa fa-times"></i></button>';

			//editables 

			//text editable
			$('#username').editable({
				type : 'text',
				name : 'username'
			});

			
			$('#city').editable({
				type : 'select2',
				value : 'Amsterdam',
				//onblur:'ignore',
				source : cities[currentValue],
				select2 : {
					'width' : 140
				}
			});

			//custom date editable
			$('#signup').editable({
				type : 'adate',
				date : {
					//datepicker plugin options
					format : 'yyyy/mm/dd',
					viewformat : 'yyyy/mm/dd',
					weekStart : 1

				//,nativeUI: true//if true and browser support input[type=date], native browser control will be used
				//,format: 'yyyy-mm-dd',
				//viewformat: 'yyyy-mm-dd'
				}
			})

			$('#age').editable({
				type : 'spinner',
				name : 'age',
				spinner : {
					min : 16,
					max : 99,
					step : 1,
					on_sides : true
				//,nativeUI: true//if true and browser support input[type=number], native browser control will be used
				}
			});
			$('#login').editable({
				type : 'slider',
				name : 'login',

				slider : {
					min : 1,
					max : 50,
					width : 100
				//,nativeUI: true//if true and browser support input[type=range], native browser control will be used
				},
				success : function(response, newValue) {
					if (parseInt(newValue) == 1)
						$(this).html(newValue + " hour ago");
					else
						$(this).html(newValue + " hours ago");
				}
			});

			$('#about').editable({
				mode : 'inline',
				type : 'wysiwyg',
				name : 'about',

				wysiwyg : {
				//css : {'max-width':'300px'}
				},
				success : function(response, newValue) {
				}
			});

			
			
		});
	</script>


</body>
</html>