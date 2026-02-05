<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Basic Arithmetic</title>
</head>
<body style="font-family:Arial; margin:20px;">
    <h2>Basic Arithmetic Operations</h2>
    <form action="calculate.jsp" method="post">
        <label>First Number:</label>
        <input type="number" name="num1" required><br><br>

        <label>Second Number:</label>
        <input type="number" name="num2" required><br><br>

        <label>Operation:</label>
        <select name="operation">
            <option value="add">Addition (+)</option>
            <option value="subtract">Subtraction (-)</option>
            <option value="multiply">Multiplication (×)</option>
            <option value="divide">Division (÷)</option>
        </select><br><br>

        <input type="submit" value="Calculate">
    </form>
</body>
</html>
