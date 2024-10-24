<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Students!!!
<c:forEach var="student" items="${students}">
    <p>${student.firstName} - ${student.lastName}</p>
</c:forEach>
</body>
</html>
