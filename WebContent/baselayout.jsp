<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<!-- bootstrap & fontawesome -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/font-awesome/4.5.0/css/font-awesome.min.css" />

<!-- text fonts -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/fonts.googleapis.com.css" />

<!-- ace styles -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<!--[if lte IE 9]>
			<link rel="stylesheet" href="<%=request.getContextPath()%>/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/ace-skins.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/ace-rtl.min.css" />

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/font-awesome/4.5.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/fonts.googleapis.com.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/ace-skins.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/ace-rtl.min.css" />
	<script src="<%=request.getContextPath()%>/js/ace-extra.min.js"></script>
<!--[if !IE]> -->
<script src="<%=request.getContextPath()%>/js/jquery-2.1.4.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-ui.custom.min.js"></script>
<script
	src="<%=request.getContextPath()%>/js/jquery.ui.touch-punch.min.js"></script>
<script
	src="<%=request.getContextPath()%>/js/jquery.easypiechart.min.js"></script>
<script
	src="<%=request.getContextPath()%>/js/jquery.sparkline.index.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.flot.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.flot.pie.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.flot.resize.min.js"></script>
<script src="<%=request.getContextPath()%>/js/ace-elements.min.js"></script>
<script src="<%=request.getContextPath()%>/js/ace.min.js"></script>
<script src="<%request.getContextPath();%>/js/daterangepicker.min.js"></script>
<script
	src="<%request.getContextPath();%>/js/bootstrap-datetimepicker.min.js"></script>


</head>
<body>
<!-- ace settings handler -->
	<div id="mainContainer">
		<div style="width: 100%;">
			<tiles:insertAttribute name="header" />
		</div>

		<div style="width: 100%; margin: 5px 0px 0px 0px; float: left;">
			<tiles:insertAttribute name="menu" />
		</div>

		<div class="container"
			style="width: 100%; margin-top: 15px; float: left;">
			<tiles:insertAttribute name="body" />
		</div>

		<div style="width: 100%; bottom: 0px;">
			<tiles:insertAttribute name="footer" />
		</div>

	</div>
</body>
</html>

