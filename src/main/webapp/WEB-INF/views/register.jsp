<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
<h2>User Registration</h2>
<form action="${pageContext.request.contextPath}/admin/register" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required>
    <br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
    <br>
    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName" required>
    <br>
    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName" required>
    <br>
    <label for="role">Role:</label>
    <select id="role" name="role" required>
        <option value="teacher">Teacher</option>
        <option value="student">Student</option>
    </select>
    <br><br>
    <button type="submit">Register</button>
</form>
</body>
</html>
