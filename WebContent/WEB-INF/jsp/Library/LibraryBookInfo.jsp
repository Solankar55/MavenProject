<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/autoCompleter.js"></script>
<link href="${pageContext.request.contextPath}/css/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css">

<script type="text/javascript">

$(document).ready(function(){
	//alert("Hii");
	
	$('#subjectName').autocomplete({
		source : '${pageContext.request.contextPath}/searchSubNameBookInfo.html'
	});
	

	$('#titleName').autocomplete({
		source : '${pageContext.request.contextPath}/searchTitleNameBookInfo.html'
	});
	
	$('#authorName').autocomplete({
		source : '${pageContext.request.contextPath}/searchAuthorNameBookInfo.html'
	});
	
	 $("#subjectName").blur(function(){
			
			var subjectName=$("#subjectName").val();
			var subName=subjectName;
			$("#bookInformation").empty();

			var titleName=$("#titleName").val();
			var authorName=$("#authorName").val();
			if(!subName=="" && titleName=="" && authorName=="")
			{
				
				$("#searchButton").hide();
				$.getJSON('getSubjectListBookInfo.html',{subjectName:subjectName}).done(function(data){
					
					for(var i=0;i<data.length;i++)
					{
						/* var x = document.createElement("BUTTON");
					    var t = document.createTextNode("Click me");
					    x.appendChild(t); */
					   
						
						$("#bookInformation").append("<tr ><td>"+data[i].LibrarySubject+"</td><td>"+data[i].BookFor+"</td><td>"+data[i].Booktype+"</td><td>"+data[i].Title+"</td><td>"+data[i].Author+"</td><td>"+data[i].Edition+"</td><td>"+data[i].PublicationYear+"</td><td>"+data[i].Publisher+"</td><td>"+data[i].StockQuantity+"</td></tr>");
						//document.getElementById("searchButton").disabled = true;
					}
					
					
				});
			}
			else
				{
				if(!subName=="" && !titleName=="" && authorName=="")
				{
					$("#bookInformation").empty();
					$("#searchButton").show();
					
				}
				else
					if(!subName=="" && !titleName=="" && !authorName=="")
					{
						$("#bookInformation").empty();
						$("#searchButton").show();
					}	
				}
				
			
			
			
		});
		 
		
	 	$("#titleName").blur(function(){
			var titleName=$("#titleName").val();
			$("#bookInformation").empty();
			var subName=$("#subjectName").val();
			var authorName=$("#authorName").val();
			if(subName=="" && !titleName=="" && authorName=="")
			{
				
				$("#searchButton").hide();
				$.getJSON('getTitleListBookInfo.html',{titleName:titleName}).done(function(data){
					for(var i=0;i<data.length;i++)
						{
						$("#bookInformation").append("<tr><td>"+data[i].LibrarySubject+"</td><td>"+data[i].BookFor+"</td><td>"+data[i].Booktype+"</td><td>"+data[i].Title+"</td><td>"+data[i].Author+"</td><td>"+data[i].Edition+"</td><td>"+data[i].PublicationYear+"</td><td>"+data[i].Publisher+"</td><td>"+data[i].StockQuantity+"</td></tr>");
						}
					
				});
			}
			else
				{
				if(!subName=="" && !titleName=="" && authorName=="")
				{
					$("#bookInformation").empty();
					$("#searchButton").show();
				}
				else
					if(!subName=="" && !titleName=="" && !authorName=="")
					{
						$("#bookInformation").empty();
						$("#searchButton").show();
					}
					else
						if(subName=="" && !titleName=="" && !authorName=="")
						{
							$("#bookInformation").empty();
							$("#searchButton").show();
						}
				
				}
			//$("#titleName").val("");
			
			
		}); 
		
	 	$("#authorName").blur(function(){
	 		
	 		
	 		
	 		var titleName=$("#titleName").val();
			$("#bookInformation").empty();
			var subName=$("#subjectName").val();
			var authorName=$("#authorName").val();
			if(subName=="" && titleName=="" && !authorName=="")
			{
				
				$("#searchButton").hide();
				$("#bookInformation").empty();
				//$("#authorName").val("");
				$.getJSON('getAuthorListBookInfo.html',{authorName:authorName}).done(function(data){
					for(var i=0;i<data.length;i++)
						{
						$("#bookInformation").append("<tr><td>"+data[i].LibrarySubject+"</td><td>"+data[i].BookFor+"</td><td>"+data[i].Booktype+"</td><td>"+data[i].Title+"</td><td>"+data[i].Author+"</td><td>"+data[i].Edition+"</td><td>"+data[i].PublicationYear+"</td><td>"+data[i].Publisher+"</td><td>"+data[i].StockQuantity+"</td></tr>");
						}
					
				});
			}
			else
				{
				if(!subName=="" && titleName=="" && !authorName=="")
				{
					$("#bookInformation").empty();
					$("#searchButton").show();
				}
				else
					if(subName=="" && !titleName=="" && !authorName=="")
					{
						$("#bookInformation").empty();
						$("#searchButton").show();
					}
					else
						if(!subName=="" && !titleName=="" && !authorName=="")
						{
							$("#bookInformation").empty();
							$("#searchButton").show();
						}
				
				}
			
			
			
		});
		
		
		$("#searchButton").click(function(){
			//alert("Hii Search");
		      
			var subName=$("#subjectName").val();
			
			var titleName=$("#titleName").val();
			var authorName=$("#authorName").val();
			
			//alert(subName+" "+titleName+" "+authorName);
			$("#bookInformation").empty();
			 $("#subjectName").val("");
			$("#titleName").val("");
			$("#authorName").val("");
			
			 if(subName.length!=0  && titleName.length!=0 && authorName.length==0)
				{
					//alert("Hii if subname and title");
					$.getJSON('getBooksubTitleListBookInfo.html',{subName:subName,titleName:titleName,authorName:authorName}).done(function(data){
						for (var i=0;i<data.length;i++)
							{
							
							$("#bookInformation").append("<tr><td>"+data[i].LibrarySubject+"</td><td>"+data[i].BookFor+"</td><td>"+data[i].Booktype+"</td><td>"+data[i].Title+"</td><td>"+data[i].Author+"</td><td>"+data[i].Edition+"</td><td>"+data[i].PublicationYear+"</td><td>"+data[i].Publisher+"</td><td>"+data[i].StockQuantity+"</td></tr>");	
							}
							
							
						});
				}
			else if(titleName.length!=0 && authorName.length!=0 && subName.length==0 )
				{
				//alert("Hiiii title and author called");
				$.getJSON('getBookTitleAuthorListBookInfo.html',{subName:subName,titleName:titleName,authorName:authorName}).done(function(data){
					for(var i=0;i<data.length;i++)
						{
						$("#bookInformation").append("<tr><td>"+data[i].LibrarySubject+"</td><td>"+data[i].BookFor+"</td><td>"+data[i].Booktype+"</td><td>"+data[i].Title+"</td><td>"+data[i].Author+"</td><td>"+data[i].Edition+"</td><td>"+data[i].PublicationYear+"</td><td>"+data[i].Publisher+"</td><td>"+data[i].StockQuantity+"</td></tr>");
						}
				});
				
				}
			else if(subName!=0 && titleName==0 && authorName!=0)
				{
				//alert("Hiiii subName and author called");
				$.getJSON('getBookSubAuthorListBookInfo.html',{subName:subName,titleName:titleName,authorName:authorName}).done(function(data){
					for (var i=0;i<data.length;i++)
						{
						
						$("#bookInformation").append("<tr><td>"+data[i].LibrarySubject+"</td><td>"+data[i].BookFor+"</td><td>"+data[i].Booktype+"</td><td>"+data[i].Title+"</td><td>"+data[i].Author+"</td><td>"+data[i].Edition+"</td><td>"+data[i].PublicationYear+"</td><td>"+data[i].Publisher+"</td><td>"+data[i].StockQuantity+"</td></tr>");	
						}
						
						
					});
				}
			else if(subName!=0 && titleName!=0 && authorName!=0 )
				{
				//alert("Hiiii subName ,Title and  author called");
				$.getJSON('getBookDetailListBookInfo.html',{subName:subName,titleName:titleName,authorName:authorName}).done(function(data){
					for (var i=0;i<data.length;i++)
						{
						
						$("#bookInformation").append("<tr><td>"+data[i].LibrarySubject+"</td><td>"+data[i].BookFor+"</td><td>"+data[i].Booktype+"</td><td>"+data[i].Title+"</td><td>"+data[i].Author+"</td><td>"+data[i].Edition+"</td><td>"+data[i].PublicationYear+"</td><td>"+data[i].Publisher+"</td><td>"+data[i].StockQuantity+"</td></tr>");	
						}
						
						
					});
				}
			
			 
			
		});
});
</script>

</head>
<body>
<div class="page-content">
		<div class="page-header center">
			
			<div class="row">
				<div class="col-lg-12">
					<div class="page-title">
						<h1><b>Online Public Access Catlog(OPAC)</b></h1>
					</div>
				</div>
			</div>
						<div class="form-inline"><hr>

				<div class="portlet-title">
					<center><h4>Search Book as per Book-Subject or Author or Title </h4></center>
				</div><br><br><br>	
			
				<div class="clearfix"></div>
			</div>
			<div id="basicFormExample" class="panel-collapse collapse in">

				<form class="form-inline" action=" ">

					<center>
					

					<div class="form-group">
						<label for="searchSubject"><b>Subject </b></label> <input type="text"
							class="form-control"  id="subjectName"
							name="subjectName" placeholder="Enter Correct Sub-Name" class="cat"  />
					</div>

						<div class="form-group">
						<label for="searchTitle"><b>Title </b></label> <input type="text"
							class="form-control"  id="titleName"
							name="titleName" placeholder="Enter Correct Title-Name" class="cat"  />
					</div>
					
					<div class="form-group">
						<label for="searchAuthor"><b>Author </b> </label><input type="text"
							class="form-control"  id="authorName"
							name="authorName" placeholder="Enter Correct Author-Name" class="cat"  />
					</div>

					<br> <br> <input type="button"
						name="searchbtn" class="btn btn-default" id="searchButton" 
						value="Search"></center>
						
									<hr />
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<table id="simple-table" class="table  table-bordered table-hover">
							<thead>
								<tr>
									<th>Subject</th>
									<th>Book For</th>
									<th>Book Type</th>
									<th>Title</th>
									<th>Author</th>
									<th>Edition</th>
									<th>Publication Year</th>
									<th>Publisher</th>
									<th>Available In Quantity</th>

								</tr>
							</thead>
							<tbody id="bookInformation">
								<%-- <c:forEach var="ba" items="${listofbank}">
									<tr
										onclick="document.getElementById('Update').style.display='block'">
										<td><c:out value="${ba.bankId }"></c:out></td>
										<td><c:out value="${ba.bankName}"></c:out></td>
										<td><c:out value="${ba.branchName}"></c:out></td>
								</tr>
								</c:forEach> --%>
							</tbody>

						</table>
					</div>
				</div>
			</div>
			<!-- /.span -->
		</div>
</form>
			</div>
			
		</div>
		
		
		
</div>
</body>
</html>