
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%
    // Visitor counter (application scope)
    Integer counter = (Integer)application.getAttribute("visitorCount");
    if(counter == null){
        counter = 0;
    }
    counter++;
    application.setAttribute("visitorCount", counter);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register Form</title>
</head>
<body>
    <h2>Visitor Count: <%= counter %></h2>
    <h2>Register Form</h2>
    <form action="welcome.jsp" method="post">
        <label for="name">Name:</label><br>
        <input type="text" name="name" id="name" required><br><br>

        <label for="email">Email:</label><br>
        <input type="email" name="email" id="email" required><br><br>

        <label for="password">Password:</label><br>
        <input type="password" name="password" id="password" required><br><br>

        <input type="submit" value="Register">
    </form>
</body>
</html>
