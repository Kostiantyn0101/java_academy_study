<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Students Grades</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <security:authorize access="hasRole('TEACHER')">
        <h5 class="text-primary">${teacher.firstName}</h5>
    </security:authorize>
    <security:authorize access="hasRole('STUDENT')">
        <h5 class="text-primary">${student.firstName}</h5>
    </security:authorize>

    <div class="text-center mb-4">
        <h1>List of Grades</h1>
    </div>

    <div class="card p-4 mb-4">
        <h3 class="mb-3">Filter Grades</h3>
        <security:authorize access="hasRole('TEACHER')">
        <form action="${pageContext.request.contextPath}/teacher/grades" method="get">
            </security:authorize>
            <security:authorize access="hasRole('STUDENT')">
            <form action="${pageContext.request.contextPath}/student/grades" method="get">
                </security:authorize>

                <div class="form-group">
                    <label for="subject_filter">Subject:</label>
                    <select id="subject_filter" name="subjectId" class="form-control">
                        <option value="">All</option>
                        <c:forEach var="subject" items="${subjects}">
                            <option value="${subject.id}" ${subject.id == param.subjectId ? 'selected' : ''}>
                                    ${subject.name}
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="date_filter">Date:</label>
                    <input type="date" id="date_filter" name="dateStr" value="${dateStr}" class="form-control"/>
                </div>

                <button type="submit" class="btn btn-primary btn-block">Filter</button>
        </form>
    </div>

    <form method="get" action="/teacher/grades" class="form-inline">
        <div class="form-group mb-2">
            <label class="mr-2">Count elements:</label>
            <select name="pageSize" class="form-control" onchange="this.form.submit()">
                <option value="10" ${pageSize == 10 ? 'selected' : ''}>10</option>
                <option value="20" ${pageSize == 20 ? 'selected' : ''}>20</option>
                <option value="50" ${pageSize == 50 ? 'selected' : ''}>50</option>
            </select>
        </div>
        <input type="hidden" name="page" value="${currentPage}">
    </form>

    <table class="table table-striped table-bordered">
        <thead class="thead-dark">
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
                        <button type="button" class="btn btn-info btn-sm" onclick="window.location.href='${editButton}'">Edit</button>
                        <button type="button" class="btn btn-danger btn-sm" onclick="window.location.href='${deleteButton}'">Delete</button>
                    </td>
                </security:authorize>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <c:url var="previousUrl" value="/teacher/grades/">
        <c:param name="page" value="${currentPage - 1}" />
        <c:param name="pageSize" value="${pageSize}" />
    </c:url>

    <c:url var="nextUrl" value="/teacher/grades/">
        <c:param name="page" value="${currentPage + 1}" />
        <c:param name="pageSize" value="${pageSize}" />
    </c:url>

    <button class="btn btn-primary" onclick="window.location.href='${previousUrl}'" ${currentPage == 0 ? 'disabled' : ''}>Previous</button>
    <button class="btn btn-primary" onclick="window.location.href='${nextUrl}'">Next</button>

    <security:authorize access="hasRole('TEACHER')">
        <div class="card p-4 mt-4">
            <h3 class="mb-3 text-center">Add New Grade</h3>
            <form:form action="${pageContext.request.contextPath}/teacher/grades/save" method="post" modelAttribute="gradeDTO">
                <input type="hidden" name="id" value="${gradeDTO.id}"/>
                <input type="hidden" name="teacherId" value="${teacher.id}"/>

                <div class="form-group">
                    <label for="student">Student:</label>
                    <select id="student" name="studentId" class="form-control">
                        <c:forEach var="student" items="${students}">
                            <option value="${student.id}">${student.firstName} - ${student.lastName}</option>
                        </c:forEach>
                    </select>
                    <form:errors path="studentId" cssClass="text-danger"/>
                </div>

                <div class="form-group">
                    <label for="subject">Subject:</label>
                    <select id="subject" name="subjectId" class="form-control">
                        <c:forEach var="subject" items="${subjects}">
                            <option value="${subject.id}">${subject.name}</option>
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

                <button type="submit" class="btn btn-primary btn-lg w-100">Add Grade</button>
            </form:form>
        </div>
    </security:authorize>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
