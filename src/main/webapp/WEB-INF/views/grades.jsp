<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admiral-Legion
  Date: 24.10.2024
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students grades</title>
</head>
<body>
<h1>List grades</h1>
<table>
    <thead>
    <tr>
        <th>Student</th>
        <th>Subject</th>
        <th>Dte</th>
        <th>Grade</th>
        <th>Comment</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="grade" items="${grades}">
        <c:url var="updateButton" value="/teacher/grades/edit/">
            <c:param name="gradeId" value="${grade.id}"/>
        </c:url>
        <c:url var="deleteButton" value="/teacher/grades/delete/">
            <c:param name="gradeId" value="${grade.id}"/>
        </c:url>
        <tr>
            <td>${grade.student.firstName} - ${grade.student.lastName}</td>
            <td>${grade.subject.name}</td>
            <td>${grade.date}</td>
            <td>${grade.grade}</td>
            <td>${grade.comment}</td>
            <td>
                <input type="button" value="update" onclick="window.location.href='${updateButton}'"/>
                <input type="button" value="delete" onclick="window.location.href='${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h3>Add new grade</h3>
<form:form action="grades/add" method="post" modelAttribute="grade">
    <label for="student">Student:</label>
    <select id="student" name="studentId">
        <c:forEach var="student" items="${students}">
            <option value="${student.id}">${student.firstName} - ${student.lastName}</option>
        </c:forEach>
    </select>
    <br>

    <label for="subject">Subject:</label>
    <select id="subject" name="subjectId">
        <c:forEach var="subject" items="${subjects}">
            <option value="${subject.id}">${subject.name}</option>
        </c:forEach>
    </select>
    <br>

    <label for="date">Date:</label>
    <input type="date" id="date" name="date" required>
    <br>

    <label for="score">Mark:</label>
    <input type="number" id="score" name="score" min="1" max="100" required>
    <br>

    <label for="comment">Comment:</label>
    <textarea id="comment" name="comment"></textarea>
    <br>

    <button type="submit">Add mark</button>
</form:form>

</body>
</html>