<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2>Register User</h2>
    <form:form action="${pageContext.request.contextPath}/admin/register" method="post" modelAttribute="userRegistrationInDTO" class="border p-4 rounded">
        <div class="form-group">
            <label for="userName">Username:</label>
            <form:input type="text" path="userName" id="username" class="form-control" required="true"/>
            <form:errors path="userName" cssClass="text-danger"/>
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

    <h2 class="mt-5">Registered Users</h2>
    <ul class="list-group">
        <c:if test="${empty userDTOs}">
            <li class="list-group-item text-center">
                <strong>No registered users yet</strong>
            </li>
        </c:if>
        <c:forEach var="user" items="${userDTOs}">
            <li class="list-group-item">
                <div class="row">
                    <div class="col-md-3">
                        <strong>Username:</strong> ${user.userName}
                    </div>
                    <div class="col-md-3">
                        <strong>Name:</strong> ${user.firstName} ${user.lastName}
                    </div>
                    <div class="col-md-3">
                        <strong>Roles:</strong>
                        <c:forEach var="roleName" items="${user.roles}" varStatus="status">
                            ${roleName.name} <c:if test="${!status.last}">, </c:if>
                        </c:forEach>
                    </div>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>


</body>
</html>
