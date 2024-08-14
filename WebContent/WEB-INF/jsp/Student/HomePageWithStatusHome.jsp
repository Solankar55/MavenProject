<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="page-content">
		<div class="page-header">
			<h1><b>Student Home Page</b></h1>
		</div>
		<c:forEach var="GetStudInfoList" items="${GetStudInfo}">
		<div class="row">
			<div class="col-xs-12 col-sm-3 center">
				<span class="profile-picture"> <img
					class="editable img-responsive" alt="Alex's Avatar" id="avatar2"
					src="<%=request.getContextPath()%>/images/avatars/dp.jpg" />
				</span>

				<div class="space space-4"></div>

				<!-- <a href="#" class="btn btn-sm btn-block btn-success"> <i
					class="ace-icon fa fa-plus-circle bigger-120"></i> <span
					class="bigger-110"></span>
				</a> <a href="#" class="btn btn-sm btn-block btn-primary"> <i
					class="ace-icon fa fa-envelope-o bigger-110"></i> <span
					class="bigger-110">Send a message</span>
				</a> -->
			</div>
			<!-- /.col -->

			<div class="col-xs-12 col-sm-9">
				<h4 class="blue">
					<span class="middle">${GetStudInfoList.StudentName}</span> <span
						class="label label-purple arrowed-in-right"> <i
						class="ace-icon fa fa-circle smaller-80 align-middle"></i> online
					</span>
				</h4>

				<div class="profile-user-info">
					<div class="profile-info-row">
						<div class="profile-info-name">User Name</div>

						<div class="profile-info-value">
							<span>${GetStudInfoList.StudentUserName}</span>
						</div>
					</div>
					<%-- <div class="profile-info-row">
						<div class="profile-info-name">Address</div>

						<div class="profile-info-value">
							<span>${GetStudInfoList.StudentAddress}</span>
						</div>
					</div> --%>
					<div class="profile-info-row">
						<div class="profile-info-name">Contact </div>

						<div class="profile-info-value">
							<span>${GetStudInfoList.StudentContactNumber}</span>
						</div>
					</div>
					<div class="profile-info-row">
						<div class="profile-info-name">Email</div>

						<div class="profile-info-value">
							<span>${GetStudInfoList.StudentEmail}</span>
						</div>
					</div>
					
				</div>

				<div class="hr hr-8 dotted"></div>

				<div class="profile-user-info"></div>
				<h3><a href="AluminiRegistrationForm.html">Register Alumini Form</a></h3>
			</div>
			<!-- /.col -->
		</div>
		</c:forEach>
	</div>
	<br><br><br>
</body>
</html>