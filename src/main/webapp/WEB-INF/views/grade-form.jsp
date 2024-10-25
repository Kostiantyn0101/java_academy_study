<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Grade</title>
</head>
<body>
<h3>Add new grade</h3>
<form:form action="grades/save" method="post" modelAttribute="gradeDTO">
    <input type="hidden" name="teacherId" value="${teacher.id}"/>
    <label for="student">Student:</label>
    <select id="student" name="studentId">
        <c:forEach var="student" items="${students}">
            <option value="${student.id}">${student.firstName} - ${student.lastName}</option>
        </c:forEach>
    </select>
<%--    <form:select id="student" path="studentId">--%>
<%--        <form:options items="${student.id}" itemValue="${student.firstName} - ${student.lastName}"/>--%>
<%--&lt;%&ndash;        <c:forEach var="student" items="${students}">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <option value="${student.id}">${student.firstName} - ${student.lastName}</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </c:forEach>&ndash;%&gt;--%>
<%--    </form:select>--%>
<%--    <form:errors path="studentId"/>--%>

    <br>
    <label for="subject">Subject:</label>
    <select id="subject" name="subjectId">
        <c:forEach var="subject" items="${subjects}">
            <option value="${subject.id}">${subject.name}</option>
        </c:forEach>
    </select>
    <form:errors path="subjectId"/>

    <br>

    <label for="date">Date:</label>
    <form:input type="date" id="date" path="date" />
    <form:errors path="date"/>

    <br>

    <label for="grade">Mark:</label>
    <form:input type="number" id="grade" path="grade" min="1" max="100"/>
    <form:errors path="score"/>

    <br>

    <label for="comment">Comment:</label>
    <form:textarea id="comment" path="comment"/>
    <form:errors path="comment"/>

    <br>

    <input type="submit" value="Add mark">
</form:form>
</body>
</html>
