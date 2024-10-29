<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Grade</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="text-center">
            <h3 class="mb-4">Grade</h3>
        </div>
        <form:form action="${pageContext.request.contextPath}/teacher/grades/save" method="post" modelAttribute="gradeOutDTO" class="border p-4 rounded">
            <input type="hidden" name="id" value="${gradeOutDTO.id}"/>
            <input type="hidden" name="teacherId" value="${teacher.id}"/>

            <div class="form-group">
                <label for="student">Student:</label>
                <select id="student" name="studentId" class="form-control">
                    <c:forEach var="student" items="${students}">
                        <option value="${student.id}" ${student.id == gradeOutDTO.studentId ? 'selected' : ''}>
                                ${student.firstName} - ${student.lastName}
                        </option>
                    </c:forEach>
                </select>
                <form:errors path="studentId" cssClass="text-danger"/>
            </div>

            <div class="form-group">
                <label for="subject">Subject:</label>
                <select id="subject" name="subjectId" class="form-control">
                    <c:forEach var="subject" items="${subjects}">
                        <option value="${subject.id}" ${subject.id == gradeOutDTO.subjectId ? 'selected' : ''}>
                                ${subject.name}
                        </option>
                    </c:forEach>
                </select>
                <form:errors path="subjectId" cssClass="text-danger"/>
            </div>

            <div class="form-group">
                <label for="date">Date:</label>
                <form:input type="date" id="date" path="date" class="form-control" required="true"/>
                <form:errors path="date" cssClass="text-danger"/>
            </div>

            <div class="form-group">
                <label for="grade">Mark:</label>
                <form:input type="number" id="grade" path="grade" class="form-control" min="1" max="100" required="true"/>
                <form:errors path="grade" cssClass="text-danger"/>
            </div>

            <div class="form-group">
                <label for="comment">Comment:</label>
                <form:textarea id="comment" path="comment" class="form-control"/>
                <form:errors path="comment" cssClass="text-danger"/>
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-primary btn-lg w-50">Save</button>
            </div>
        </form:form>
    </div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
