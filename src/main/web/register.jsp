<%--
  Created by IntelliJ IDEA.
  User: uddinm
  Date: 06/03/14
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

// Below keeps on breaking when the commented lines are made not comment
<%--<% if (request.getAttribute("isUserLoggedIn").equals("false")) {%>--%>

<form name="loginForm" method="post" action="/Register">
    <table>
        <tr>
            <td>User Name</td>
            <td><input type="text" name="userNameRegisterInput"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" name="passwordRegisterInput"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" name="registerSubmit"/></td>
        </tr>
    </table>
</form>

<%--<% } else {%>--%>
<p>You are already registered.</p>
<%--<%}%>--%>

</body>
</html>
