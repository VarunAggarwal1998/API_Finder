<%@include file="include/header.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apifinder.entity.apiData"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
			<strong>Listing API</strong>
			 
			
			<hr />
			<table border="1">
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
 				<td>${apiData.link}</td>
 				<td>${apiData.category}</td>
 				<td>
 				<a href="${updateURL}">Update</a>|
 				<a href="${deleteApi}"
					onclick="if(!confirm('Are you sure to delete the API?')) return false">Delete</a>
 				</td>
 				</tr>			
				</c:forEach>
			</table>
		</div>
	</div>
</div>
				
				
				<%--  <%!String deleteURL;%>
				<%
				
					List<apiData> listApi = (List) request.getAttribute("listApi");
					String updateURL;
					for (int i = 0; i < listApi.size(); i++) {
						out.print("<tr>");
						out.print("<td>" + listApi.get(i).getApiId() + "</td>");
						out.print("<td>" + listApi.get(i).getApi() + "</td>");
						out.print("<td>" + listApi.get(i).getDescription() + "</td>");
						out.print("<td>" + listApi.get(i).getAuth() + "</td>");
						out.print("<td>" + listApi.get(i).getHttps() + "</td>");
						out.print("<td>" + listApi.get(i).getCors() + "</td>");
						out.print("<td>" + listApi.get(i).getLink() + "</td>");
						out.print("<td>" + listApi.get(i).getCategory() + "</td>");
						updateURL = request.getContextPath() + "/operation?page=updateApi" + "&apiId=" + listApi.get(i).getApiId() + "&api=" + listApi.get(i).getApi() + "&description="+listApi.get(i).getDescription() +"&auth=" + listApi.get(i).getAuth() +"&https=" + listApi.get(i).getHttps() +"&cors=" + listApi.get(i).getCors()+"&link=" + listApi.get(i).getLink()+"&category=" + listApi.get(i).getCategory();
						
						deleteURL = request.getContextPath() + "/operation?page=deleteApi" + "&apiId="
								+ listApi.get(i).getApiId();
						out.print("<td><a href=" + updateURL + ">Update</a>|"); 
				%>
				 
			 <a href="<%=deleteURL%>"
					onclick="if(!confirm('Are you sure to delete the user?')) return false">Delete</a>
				</td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
	</div>
</div>--%>

<%@include file="include/footer.jsp"%>


<%-- <%@include file="include/header.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="org.studyeasy.entity.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
			<strong>Listing users</strong>
			<hr />
			<table border="1">
				<thead>
					<th>User ID</th>
					<th>Username</th>
					<th>Email</th>
					<th>Operation</th>
				</thead>
				<c:forEach items="${listUsers}" var="user">
				<c:url var="updateURL" value="operation">
				<c:param name="page" value="updateUser"></c:param>			
				<c:param name="usersId" value="${user.users_id}"></c:param>
				<c:param name="username" value="${user.username}"></c:param>
				<c:param name="email" value="${user.email}"></c:param>
				</c:url>
			
				<c:url var="deleteUser" value="operation">
				<c:param name="page" value="deleteUser"></c:param>			
				<c:param name="usersId" value="${user.users_id}"></c:param>
				</c:url>			
 				<tr>
 				<td>${user.users_id}</td>
 				<td>${user.username}</td>
 				<td>${user.email}</td>
 				<td>
 				<a href="${updateURL}">Update</a>|
 				<a href="${deleteUser}"
					onclick="if(!confirm('Are you sure to delete the user?')) return false">Delete</a>
 				</td>
 				</tr>			
				</c:forEach>
			</table>
		</div>
	</div>
</div> --%>

<%@include file="include/footer.jsp"%>








 