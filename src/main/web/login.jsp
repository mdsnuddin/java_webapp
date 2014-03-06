<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<% if (request.getAttribute("isUserLoggedIn").equals("false")) {%>

<form name="loginForm" method="post" action="/Login">
<table>
    <tr>
        <td>User Name</td>
        <td><input type="text" name="userNameLoginInput"/></td>
    </tr>
    <tr>
        <td>Password</td>
        <td><input type="text" name="passwordLoginInput"/></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" name="loginSubmit"/></td>
    </tr>
</table>
</form>

<br>
<p>If you don't have an account then why not <a href="register.jsp">register</a> an account</p>

<% } else {%>
<p>You are already logged in.</p>
<%}%>

</body>
</html>
