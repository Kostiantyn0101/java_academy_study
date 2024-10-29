<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="text-center">
        <h3 class="mb-4">User Registration</h3>
    </div>
    <form:form action="${pageContext.request.contextPath}/admin/register" method="post" modelAttribute="userRegistrationDTO" class="border p-4 rounded">
        <div class="form-group">
            <label for="username">Username:</label>
            <form:input type="text" path="username" id="username" class="form-control" required="true"/>
            <form:errors path="username" cssClass="text-danger"/>
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <form:input type="password" path="password" id="password" class="form-control" required="true"/>
            <form:errors path="password" cssClass="text-danger"/>
        </div>

        <div class="form-group">
            <label for="firstName">First Name:</label>
            <form:input type="text" path="firstName" id="firstName" class="form-control" required="true"/>
            <form:errors path="firstName" cssClass="text-danger"/>
        </div>

        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <form:input type="text" path="lastName" class="form-control" required="true"/>
            <form:errors path="lastName" cssClass="text-danger"/>
        </div>

        <div class="form-group">
            <label for="roleId">Role:</label>
            <form:select path="roleId" class="form-control" required="true">
                <form:option value="2">Student</form:option>
                <form:option value="1">Teacher</form:option>
            </form:select>
            <form:errors path="roleId" cssClass="text-danger"/>
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-primary btn-lg w-50">Register</button>
        </div>
    </form:form>
</div>
</body>
</html>
