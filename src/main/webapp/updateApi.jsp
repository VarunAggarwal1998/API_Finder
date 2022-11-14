<%@include file="include/header.jsp" %>
<link href="assets/css/moreStyle.css" rel="stylesheet">
<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
		<strong>UPDATE API</strong><br/>
		
		<form action="${pageContext.request.contextPath}/operation" method="post">
		<br>
		API: <input type="text" name="api" value="${param.api }" required/><br/>
		Description: <input type="text" name="description" value="${param.description }" required/><br/>
		Auth: <input type="text" name="auth" value="${param.auth }" required/><br/>
		HTTPS: <input type="text" name="https" value="${param.https }" required/><br/>
		Cors: <input type="text" name="cors" value="${param.cors }" required/><br/>
		Link: <input type="text" name="link" value="${param.link }" required/><br/>
		Category: <input type="text" name="category" value="${param.category }" required/><br/>
		
		<input type="hidden" name="apiId" value="${param.apiId}"/>
		<input type="hidden" name="form" value="updateApiOperation"/>
		<input type="submit" value="Update API"/>
		
		</form>
		</div>
	</div>
</div>
 <div id="footerr">
<%@include file="include/footer.jsp" %>
</div>