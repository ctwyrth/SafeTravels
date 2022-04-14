<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Safe Travels - Home</title>

	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	
	<script type="text/javascript" src="/js/script.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="container mx-auto mt-5">
			<h1 class="display-5">Save Travels</h1>
			<table class="table table-striped">
				<thead class="table-secondary">
					<tr>
						<th>Expense</th>
						<th>Vendor</th>
						<th>Amount</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!expenses.isEmpty()}">
						<c:forEach var="expense" items="${expenses}">
							<tr>
								<td><c:out value="${expense.expenseName}" /></td>
								<td><c:out value="${expense.vendor}" /></td>
								<td>$<c:out value="${expense.charge}" />.00</td>
								<td><a href="/expenses/<c:out value="${expense.id}" />/edit" class="nav-item">edit</a></td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
		<div class="container mx-auto mt-5">
			<div class="col-6 mx-auto">
				<h2>Add an Expense</h2>
				<form:form action="/expenses" method="POST" modelAttribute="expense" class="rounded bg-info px-4 pt-4 pb-2">
					<div class="input-group mb-3">
						<span class="input-group-text">Name:</span>
						<form:input type="text" path="expenseName" class="form-control" />
					</div>
					<div><form:errors path="expenseName" /></div>
					<div class="input-group mb-3">
						<span class="input-group-text">Vendor:</span>
						<form:input type="text" path="vendor" class="form-control" />
					</div>
					<div><form:errors path="vendor" /></div>
					<div class="input-group mb-3">
						<span class="input-group-text">Charge:</span>
						<form:input type="number" path="charge" class="form-control" />
					</div>
					<div><form:errors path="charge" /></div>
					<div class="mb-3">
						<form:label path="description" class="form-label">Description:</form:label>
						<form:textarea path="description" class="form-control" />
					</div>
					<div><form:errors path="description" /></div>
					<div class="mb-3">
						<input type="submit" value="Submit" class="btn btn-sm btn-secondary mx-auto" />
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>