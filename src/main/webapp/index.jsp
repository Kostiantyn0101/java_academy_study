<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Welcome</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container text-center mt-5">
    <h1 class="display-4">Welcome to the Grading System!</h1>
    <p class="lead">Please select your role to continue.</p>
    <div class="mt-4">
        <security:authorize access="isAnonymous()">
            <a href="${pageContext.request.contextPath}/login" class="btn btn-primary btn-lg">Login</a>
        </security:authorize>
        <security:authorize access="hasRole('STUDENT')">
            <a href="${pageContext.request.contextPath}/student/grades" class="btn btn-primary btn-lg">Go to Student Page</a>
        </security:authorize>
        <security:authorize access="hasRole('TEACHER')">
            <a href="${pageContext.request.contextPath}/teacher/grades" class="btn btn-success btn-lg">Go to Teacher Page</a>
        </security:authorize>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
