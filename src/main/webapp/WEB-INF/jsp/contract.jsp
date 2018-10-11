<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<form:form method="post" modelAttribute="contract">

		<form:hidden path="id"/>
		<fieldset class="form-group">
			<form:label path="contractName">Contract name</form:label>
			<form:input path="contractName" type="text" class="form-control"
						required="required" />
			<form:label path="system">system</form:label>
			<form:input path="system" type="text" class="form-control"
				required="required" />
			<form:label path="active">active</form:label>
			<form:input path="active" type="text" class="form-control"
						required="required" />
		</fieldset>


		<button type="submit" class="btn btn-success">Add</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>