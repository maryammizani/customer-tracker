<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>

<!DOCTYPE html>
<head>
	<title>List Customers</title>
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
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					</tr>
					<!-- customers is the Model attribute we added in CustomerController: iModel.addAttribute("customers",lCustomers) -->
					<c:forEach var="tempCustomer" items="${customers}">
						<tr>
							<!-- firstName is what is returned from lCustomer.getFirstName() -->
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>