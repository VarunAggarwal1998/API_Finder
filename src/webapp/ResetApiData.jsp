<%@include file="include/header.jsp" %>
<link href="assets/css/moreStyle.css" rel="stylesheet">
<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
		
		<strong>Refresh API Data</strong><br>
		
		<p>
		Clicking the below "Reset API" button will delete all the existing data in the database and will reload the fresh data from the API.
		</p>
		
	
		 <form action="${pageContext.request.contextPath}/operation" method="post">
		 
		 <input type="hidden" name="form" value="resetapioperation">
		<input type="submit" value="Reset API" onclick="if(!confirm('Are you sure to Reset the API?')) return false">
		 
		
		</form>
		</div>
	</div>
</div>
 <div id="footerr">
<%@include file="include/footer.jsp" %>
</div>