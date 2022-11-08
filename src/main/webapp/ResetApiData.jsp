<%@include file="include/header.jsp" %>
<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
		
		<strong>Refresh API Data</strong>
		
	
		 <form action="${pageContext.request.contextPath}/operation" method="post">
		 
		 <input type="hidden" name="form" value="resetapioperation">
		<input type="submit" value="Reset API">
		 
		 <!--  <button type="submit" name="reset" value="reset1">Reset Data</button>
		 -->
		<!-- <input type="hidden" name="ResetBtn" value="resetApiOperation"/>
		<input type="submit" value="Reset"/> -->
		
		</form>
		</div>
	</div>
</div>
<%@include file="include/footer.jsp" %>