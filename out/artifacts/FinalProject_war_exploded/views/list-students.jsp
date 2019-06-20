<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>List of Students</title>
    <meta charset="utf-8">


    <link type="text/css" rel="stylesheet" href="css/style.css">


    <%--	<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">--%>

    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"
            type="text/javascript"></script>

    <script
            src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous"></script>

    <script src="views/js/student.js" type="text/javascript"></script>

    <%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>--%>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2> University Student</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <!-- put new button: Add Student -->

<%--        <input type="button" value="Add Student"--%>
<%--               onclick="window.location.href='/addstudent'; return false;"--%>
<%--               class="add-student-button"--%>
<%--        />--%>

        <table>

            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Password</th>

            </tr>

            <c:forEach var="tempStudent" items="${STUDENT_LIST}">

                <!-- set up a link for each student -->
                <%--					<c:url var="tempLink" value="/student">--%>
                <%--						<c:param name="command" value="LOAD" />--%>
                <%--						<c:param name="studentId" value="${tempStudent.id}" />--%>
                <%--					</c:url>--%>

                <%--					<!--  set up a link to delete a student -->--%>
                <c:url var="deleteLink" value="/student">
                    <c:param name="command" value="DELETE"/>
                    <c:param name="studentId" value="${tempStudent.id}"/>
                </c:url>

                <tr>
                    <td> ${tempStudent.id} </td>
                    <td> ${tempStudent.username} </td>
                    <td><input class="password" id="${tempStudent.id}" type="text" value="${tempStudent.password}"></td>
                    <td>
                        <button class="update" id="${tempStudent.id}">Update</button>
                        |
                        <button id="${tempStudent.id}" class="delete"
                                onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
                            Delete
                        </button>
                    </td>
                </tr>

            </c:forEach>
            <tr>
                <td>Add new student</td>
                <td><input class="username" type="text"></td>
                <td><input class="password" id="new" type="text"></td>
                <td>
                    <button class="insert">Add Student</button>
                </td>
            </tr>
        </table>

    </div>

    <%--		<p>--%>
    <%--			<a href="/welcome">Back home</a>--%>
    <%--		</p>--%>

</div>
</body>


</html>








