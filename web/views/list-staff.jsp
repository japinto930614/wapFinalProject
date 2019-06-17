<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<title>List of Students</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2> University Staff</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Staff -->
			
			<input type="button" value="Add Staff"
				   onclick="window.location.href='/addstaff'; return false;"
				   class="add-staff-button"
			/>
			
			<table>
			
				<tr>
					<th>ID</th>
					<th>Username</th>
					<th>Password</th>

				</tr>
				
				<c:forEach var="tempStaff" items="${STAFF_LIST}">

					<!-- set up a link for each staff -->
<%--					<c:url var="tempLink" value="/staff">--%>
<%--						<c:param name="command" value="LOAD" />--%>
<%--						<c:param name="staffId" value="${tempstaff.id}" />--%>
<%--					</c:url>--%>

<%--					<!--  set up a link to delete a staff -->--%>
					<c:url var="deleteLink" value="/staff">
						<c:param name="command" value="DELETE" />
						<c:param name="staffId" value="${tempStaff.id}" />
					</c:url>

					<tr>
						<td> ${tempStaff.id} </td>
						<td> ${tempStaff.username} </td>
						<td> ${tempStaff.password} </td>
						<td>
							<a href="/updatestaff?id=${tempStaff.id}&username=${tempStaff.username}">Update</a>
							 |
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this staff?'))) return false">
							Delete</a>
						</td>
					</tr>

				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








