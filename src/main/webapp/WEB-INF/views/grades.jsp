<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students grades</title>
</head>
<body>
<security:authorize access="hasRole('TEACHER')">
    ${teacher.firstName}
</security:authorize>
<security:authorize access="hasRole('STUDENT')">
    ${student.firstName}
</security:authorize>
<h1>List grades</h1>
<h3>Filter Grades</h3>
<security:authorize access="hasRole('TEACHER')">
    <form action="${pageContext.request.contextPath}/teacher/grades" method="get">
</security:authorize>
<security:authorize access="hasRole('STUDENT')">
    <form action="${pageContext.request.contextPath}/student/grades" method="get">
</security:authorize>
        <label for="subject_filter">Subject:</label>
        <select id="subject_filter" name="subjectId">
            <option value="">All</option>
            <c:forEach var="subject" items="${subjects}">
                <option value="${subject.id}" ${subject.id == param.subjectId ? 'selected' : ''}>
                        ${subject.name}
                </option>
            </c:forEach>
        </select>

        <label for="date_filter">Date:</label>
        <%--    <form:input type="date" id="date_filter" path="date" />--%>
        <input type="date" id="date_filter" name="dateStr" value="${dateStr}"/>

        <input type="submit" value="Filter"/>
    </form>
    <table>
        <thead>
        <tr>
            <th>Student</th>
            <th>Subject</th>
            <th>Date</th>
            <th>Grade</th>
            <th>Comment</th>
            <security:authorize access="hasRole('TEACHER')">
                <th>Actions</th>
            </security:authorize>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="grade" items="${grades}">
            <c:url var="editButton" value="/teacher/grades/edit/">
                <c:param name="id" value="${grade.id}"/>
            </c:url>
            <c:url var="deleteButton" value="/teacher/grades/delete/">
                <c:param name="id" value="${grade.id}"/>
            </c:url>
            <tr>
                <td>${grade.student.firstName} - ${grade.student.lastName}</td>
                <td>${grade.subject.name}</td>
                <td>${grade.date}</td>
                <td>${grade.grade}</td>
                <td>${grade.comment}</td>
                <security:authorize access="hasRole('TEACHER')">
                    <td>
                        <input type="button" value="edit" onclick="window.location.href='${editButton}'"/>
                        <input type="button" value="delete" onclick="window.location.href='${deleteButton}'"/>
                    </td>
                </security:authorize>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <security:authorize access="hasRole('TEACHER')">
    <h3>Add new grade</h3>
        <form:form action="${pageContext.request.contextPath}/teacher/grades/save" method="post" modelAttribute="gradeDTO">
            <input type="hidden" name="id" value="${gradeDTO.id}"/>
            <input type="hidden" name="teacherId" value="${teacher.id}"/>
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
                <form:errors path="subjectId"/>

            <br>

            <label for="date">Date:</label>
                <form:input type="date" id="date" path="date" required="true"/>
                <form:errors path="date"/>

            <br>

            <label for="grade">Mark:</label>
                <form:input type="number" id="grade" path="grade" min="1" max="100" required="true"/>
                <form:errors path="grade"/>

            <br>

            <label for="comment">Comment:</label>
                <form:textarea id="comment" path="comment"/>
                <form:errors path="comment"/>

            <br>

            <input type="submit" value="Add mark">
        </form:form>
    </security:authorize>

</body>
</html>