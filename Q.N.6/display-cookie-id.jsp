<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Display Cookie / Session ID</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        h2 { color: #333; }
        .info { background: #f8f9fa; padding: 15px; border-radius: 5px; }
        .cookie { margin: 10px 0; padding: 10px; background: #e9ecef; border-radius: 4px; }
    </style>
</head>
<body>

<h2>Session & Cookie Information</h2>

<div class="info">
    <p><strong>Session ID (JSESSIONID cookie value):</strong> <%= session.getId() %></p>
    <p><strong>Is new session?</strong> <%= session.isNew() %></p>
    <p><strong>Session created:</strong> <%= new java.util.Date(session.getCreationTime()) %></p>
    <p><strong>Last accessed:</strong> <%= new java.util.Date(session.getLastAccessedTime()) %></p>
</div>

<h3>Cookies received in this request:</h3>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length > 0) {
        for (Cookie c : cookies) {
%>
            <div class="cookie">
                <strong>Name:</strong> <%= c.getName() %><br>
                <strong>Value:</strong> <%= c.getValue() %><br>
                <strong>Max Age:</strong> <%= c.getMaxAge() %> seconds
            </div>
<%
        }
    } else {
%>
        <p><i>No cookies present in this request</i></p>
<%
    }
%>

<p><a href="display-cookie-id.jsp">Refresh page</a></p>
<p><small>→ Session ID remains same across refreshes (until browser closes or session times out)</small></p>

</body>
</html>