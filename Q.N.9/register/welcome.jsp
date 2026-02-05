<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%
    // Get session
    String name = request.getParameter("name");
    if(name != null && !name.isEmpty()){
        session.setAttribute("userName", name); // store logged-in user
    } else {
        name = (String)session.getAttribute("userName");
    }

    if(name == null) {
        response.sendRedirect("index.jsp"); // redirect if no session
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
    <h2>Welcome, <%= name %>!</h2>
    <h3>Total Visitors: <%= application.getAttribute("visitorCount") %></h3>

    <form action="index.jsp">
        <input type="submit" value="Logout">
    </form>
</body>
</html>
