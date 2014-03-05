<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<% if (request.getAttribute("isUserLoggedIn").equals("true")) {%>
<p>Welcome <%= request.getAttribute("currentUserName") %> </p>
<% } else {%>
<p>Sorry, your username and / or password was not recognised. Please try <a href="login.jsp">logging in again.</a></p>
<%}%>

</body>
</html>
