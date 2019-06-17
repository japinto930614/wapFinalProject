<!DOCTYPE html>
<html>

<head>
    <title>Add Staff</title>

    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2>University Staff</h2>
    </div>
</div>

<div id="container">
    <h3>Add Staff</h3>

    <form action="staff" method="GET">

        <input type="hidden" name="command" value="ADD"/>

        <table>
            <tbody>
            <tr>
                <td><label>Username:</label></td>
                <td><input type="text" name="username"/></td>
            </tr>

            <tr>
                <td><label>Password:</label></td>
                <td><input type="password" name="password"/></td>
            </tr>
            <input type="hidden" name="type" value="Staff"/>

            <%--					<tr>--%>
            <%--						<td><label>Email:</label></td>--%>
            <%--						<td><input type="text" name="email" /></td>--%>
            <%--					</tr>--%>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"/></td>
            </tr>

            </tbody>
        </table>
    </form>

    <div style="clear: both;"></div>

    <p>
        <a href="StaffControllerServlet">Back to List</a>
    </p>
</div>
</body>

</html>











