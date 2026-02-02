<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    double num1 = Double.parseDouble(request.getParameter("num1"));
    double num2 = Double.parseDouble(request.getParameter("num2"));
    String operation = request.getParameter("operation");

    double result = 0;
    String opSymbol = "";

    switch(operation) {
        case "add":
            result = num1 + num2;
            opSymbol = "+";
            break;
        case "subtract":
            result = num1 - num2;
            opSymbol = "-";
            break;
        case "multiply":
            result = num1 * num2;
            opSymbol = "×";
            break;
        case "divide":
            if(num2 != 0){
                result = num1 / num2;
                opSymbol = "÷";
            } else {
                out.println("<h3 style='color:red'>Error: Division by zero is not allowed!</h3>");
                return;
            }
            break;
        default:
            out.println("<h3 style='color:red'>Invalid Operation</h3>");
            return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Result</title>
</head>
<body style="font-family:Arial; margin:20px;">
    <h2>Arithmetic Result</h2>
    <p>
        <strong><%= num1 %> <%= opSymbol %> <%= num2 %> = <%= result %></strong>
    </p>
    <a href="index.jsp">Perform Another Calculation</a>
</body>
</html>
