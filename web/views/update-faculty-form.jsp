<!DOCTYPE html>
<html>

<head>
	<title>Add Faculty</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-faculty-style.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Update Faculty</h3>
		
		<form action="faculty" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Username:</label></td>
						<td><input type="text" name="username" readonly="readonly" value="${username}"/></td>
					</tr>

					<tr>
						<td><label>Password:</label></td>
						<td><input type="password" name="password" value="${password}"/></td>
					</tr>
					<input type="hidden" name="id" value="${id}"/>
					<input type="hidden" name="type" value="Faculty"/>

<%--					<tr>--%>
<%--						<td><label>Email:</label></td>--%>
<%--						<td><input type="text" name="email" /></td>--%>
<%--					</tr>--%>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="FacultyControllerServlet">Back to List</a>
		</p>
	</div>
</body>

</html>











