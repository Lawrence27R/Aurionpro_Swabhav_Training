<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet, java.sql.SQLException"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>View Customers</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<form action="viewCustomers" method="get" class="mb-4">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-auto">
						<button type="submit" class="btn btn-secondary" name="viewAll" value="true">View All</button>
					</div>
					<div class="col">
						<div class="form-row justify-content-end">
							<div class="form-group mb-2 mr-2">
								<label for="sortBy" class="sr-only">Sort By:</label>
								<select id="sortBy" name="sortBy" class="form-control">
									<option value="balance">Maximum Balance</option>
									<option value="accountNumber">Ascending Account Number</option>
								</select>
							</div>
							<div class="form-group mb-2 mr-2">
								<label for="searchName" class="sr-only">Search by Name:</label>
								<input type="text" id="searchName" name="searchName" class="form-control" placeholder="Enter name">
							</div>
							<button type="submit" class="btn btn-primary mb-2">Apply Filter</button>
						</div>
					</div>
				</div>
			</div>
		</form>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Account Number</th>
					<th>Balance</th>
				</tr>
			</thead>
			<tbody>
				<%
				ResultSet rs = (ResultSet) request.getAttribute("customers");
				String errorMessage = (String) request.getAttribute("errorMessage");

				if (errorMessage != null) {
				%>
				<tr>
					<td colspan="4" class="text-danger"><%= errorMessage %></td>
				</tr>
				<%
				} else if (rs == null) {
				%>
				<tr>
					<td colspan="4">No customers found.</td>
				</tr>
				<%
				} else {
					try {
						while (rs.next()) {
							String firstName = rs.getString("customerFName");
							String lastName = rs.getString("customerLName");
							String accountNumber = rs.getString("customerAccountNum");
							double balance = rs.getDouble("customerBalance");
				%>
				<tr>
					<td><%= firstName %></td>
					<td><%= lastName %></td>
					<td><%= accountNumber %></td>
					<td><%= balance %></td>
				</tr>
				<%
						}
					} catch (SQLException e) {
				%>
				<tr>
					<td colspan="4" class="text-danger">Error: <%= e.getMessage() %></td>
				</tr>
				<%
					}
				}
				%>
			</tbody>
		</table>
		<div class="mt-3">
			<a href="adminDashboard.jsp" class="btn btn-info">Go to Admin Dashboard</a>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
