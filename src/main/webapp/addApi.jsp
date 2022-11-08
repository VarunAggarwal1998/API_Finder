<%@include file="include/header.jsp" %>
<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
		<form action="${pageContext.request.contextPath}/operation" method="post">
		API: <input type="text" name="api" required/><br/>
		Description: <input type="text" name="description" required/><br/>
		Auth: <input type="text" name="auth" required/><br/>
		HTTPS: <input type="text" name="https" required/><br/>
		CORS: <input type="text" name="cors" required/><br/>
		Link: <input type="text" name="link" required/><br/>
		Category: <input type="text" name="category" required/><br/>
		
		<input type="hidden" name="form" value="addapioperation">
		<input type="submit" value="Add API">
		
		</form>
		</div>
	</div>
</div>
<%@include file="include/footer.jsp" %>