<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Grade</title>
</head>
<body>
<h3>Add new grade</h3>
<form:form action="${pageContext.request.contextPath}/teacher/grades/save" method="post" modelAttribute="gradeDTO">
    <input type="hidden" name="id" value="${gradeDTO.id}"/>
    <input type="hidden" name="teacherId" value="${teacher.id}"/>
    <label for="student">Student:</label>
    <label for="student">Student:</label>
    <select id="student" name="studentId">
        <c:forEach var="student" items="${students}">
            <option value="${student.id}" ${student.id == gradeDTO.studentId ? 'selected' : ''}>
                    ${student.firstName} - ${student.lastName}
            </option>
        </c:forEach>
    </select>
    <form:errors path="studentId"/>
    <br>

    <label for="subject">Subject:</label>
    <select id="subject" name="subjectId">
        <c:forEach var="subject" items="${subjects}">
            <option value="${subject.id}" ${subject.id == gradeDTO.subjectId ? 'selected' : ''}>
                    ${subject.name}
            </option>
        </c:forEach>
    </select>
    <br>
    <form:errors path="subjectId"/>

    <label for="date">Date:</label>
    <form:input type="date" id="date" path="date" />
    <form:errors path="date"/>

    <br>

    <label for="grade">Mark:</label>
    <form:input type="number" id="grade" path="grade" min="1" max="100"/>
    <form:errors path="grade"/>

    <br>

    <label for="comment">Comment:</label>
    <form:textarea id="comment" path="comment"/>
    <form:errors path="comment"/>

    <br>

    <input type="submit" value="Save">
</form:form>
</body>
</html>
