<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration Successful</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="card text-center border-success">
        <div class="card-header bg-success text-white">
            <h2>Registration Successful!</h2>
        </div>
        <div class="card-body">
            <p class="card-text">The user has been successfully registered.</p>
            <a href="${pageContext.request.contextPath}/admin/register" class="btn btn-primary">Add another user</a>
        </div>
    </div>
</div>
</body>
</html>
