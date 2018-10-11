<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <table class="table table-striped">
        <caption>List of contracts</caption>
        <thead>
        <tr>
            <th>Contract Name</th>
            <th>System</th>
            <th>Active</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${contracts}" var="contract">
            <tr>

                <c:if test="${contract.active == true}">
                    <td>${contract.contractName}</td>
                    <td>${contract.system}</td>
                    <td>${contract.active}</td>

                    <td><a type="button" class="btn btn-success"
                           href="/update-contract?id=${contract.id}">Update</a></td>
                    <td><a type="button" class="btn btn-warning"
                           href="/delete-contract?id=${contract.id}">Delete</a></td>
                </c:if>


            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<%@ include file="common/footer.jspf" %>