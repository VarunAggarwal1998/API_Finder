<%@include file="include/header.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apifinder.model.apiData"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="assets/css/syle.css" rel="stylesheet">
<link href="assets/css/bootstarp.css" rel="stylesheet">
<link href="assets/css/moreStyle.css" rel="stylesheet">

<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
			<strong>Listing API</strong><br/>
			
			 <form action="" method="get">
			 <br>
			Search :  <input type="text" name="apiText" placeholder="type keywords here..."/>
			<input type="hidden" name="page" value="listapi"/>
			<input type="submit" value=" go ">
			
		
		</form> 
			 
			
			<hr />
			
    		
    		
			<table border="1"  style="margin-bottom:200px;">
				<thead>
					<th>ID</th>
					<th>API</th>
					<th>Description</th>
					<th>Auth</th>
					<th>HTTPS</th>
					<th>Cors</th>
					<th>Link</th>
					<th>Category</th>
					<th>Operation</th>
				</thead>
				
				
				<tbody>
				
				
				<c:forEach items="${listApi}" var="apiData">
				<c:url var="updateURL" value="operation">
				<c:param name="page" value="updateApi"></c:param>
				<c:param name="apiId" value="${apiData.apiId}"></c:param>
				<c:param name="api" value="${apiData.api}"></c:param>
				<c:param name="description" value="${apiData.description}"></c:param>
				<c:param name="auth" value="${apiData.auth}"></c:param>
				<c:param name="https" value="${apiData.https}"></c:param>
				<c:param name="cors" value="${apiData.cors}"></c:param>
				<c:param name="link" value="${apiData.link}"></c:param>
				<c:param name="category" value="${apiData.category}"></c:param>
				
				
				</c:url>	
				<c:url var="deleteApi" value="operation">
				<c:param name="page" value="deleteApi"></c:param>			
				<c:param name="apiId" value="${apiData.apiId}"></c:param>
				</c:url>
				
				<tr>
 				<td>${apiData.apiId}</td>
 				<td>${apiData.api}</td>
 				<td>${apiData.description}</td>
 				<td>${apiData.auth}</td>
 				<td>${apiData.https}</td>
 				<td>${apiData.cors}</td>
 				<td><a href="${apiData.link}">${apiData.link}</a></td>
 				<td>${apiData.category}</td>
 				<td>
 				<a href="${updateURL}">Update</a>|
 				<a href="${deleteApi}"
					onclick="if(!confirm('Are you sure to delete the API?')) return false">Delete</a>
 				</td>
 				</tr>
 						
				</c:forEach>
				</tbody>
					
				
				
			</table>
			
			
			
		</div>
	</div>
</div>
				
				
 <div id="footerr">
<%@include file="include/footer.jsp" %>
</div>







 