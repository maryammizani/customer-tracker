<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>

<!DOCTYPE html>
<head>
	<title>List Customers</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<html>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>				
			</div>
		</div>
		<div id="container">
			<div id="content">
				<input type="button" value="Add Customer"				
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button"
				/>
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					<!-- customers is the Model attribute we added in CustomerController: iModel.addAttribute("customers",lCustomers) -->
					<c:forEach var="tempCustomer" items="${customers}">
						
						<!--  Construct an update link with customer id -->
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>
						<tr>
							<!-- firstName is what is returned from lCustomer.getFirstName() -->
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>
							<td>${tempCustomer.email}</td>
							<td>
								<a href="${updateLink }">Update</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>