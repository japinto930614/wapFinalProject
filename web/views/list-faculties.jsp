<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<title>List of Faculties</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2> University Faculty</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Faculty -->
			
			<input type="button" value="Add Faculty"
				   onclick="window.location.href='/addfaculty'; return false;"
				   class="add-faculty-button"
			/>
			
			<table>
			
				<tr>
					<th>ID</th>
					<th>Username</th>
					<th>Password</th>

				</tr>
				
				<c:forEach var="tempFaculty" items="${FACULTY_LIST}">

					<!-- set up a link for each student -->
<%--					<c:url var="tempLink" value="/student">--%>
<%--						<c:param name="command" value="LOAD" />--%>
<%--						<c:param name="studentId" value="${tempStudent.id}" />--%>
<%--					</c:url>--%>

<%--					<!--  set up a link to delete a faculty -->--%>
					<c:url var="deleteLink" value="/faculty">
						<c:param name="command" value="DELETE" />
						<c:param name="facultyId" value="${tempFaculty.id}" />
					</c:url>

					<tr>
						<td> ${tempFaculty.id} </td>
						<td> ${tempFaculty.username} </td>
						<td> ${tempFaculty.password} </td>
						<td>
							<a href="/updatefaculty?id=${tempFaculty.id}&username=${tempFaculty.username}">Update</a>
							 |
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this faculty?'))) return false">
							Delete</a>
						</td>
					</tr>

				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








