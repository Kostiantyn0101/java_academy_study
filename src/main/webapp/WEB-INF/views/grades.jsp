<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Students Grades</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
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

    <security:authorize access="hasRole('TEACHER')">
        <c:set var="formAction" value="${pageContext.request.contextPath}/teacher/grades" />
    </security:authorize>
    <security:authorize access="hasRole('STUDENT')">
        <c:set var="formAction" value="${pageContext.request.contextPath}/student/grades" />
    </security:authorize>

    <div class="card p-4 mb-4">
        <h3 class="mb-3">Filter Grades</h3>
        <form:form action="${formAction}" method="get">
            <div class="row g-2 align-items-center">
                <div class="col-md-4">
                    <label for="subject_filter" class="form-label">Subject:</label>
                    <select id="subject_filter" name="subjectId" class="form-control">
                        <option value="">All</option>
                        <c:forEach var="subject" items="${subjects}">
                            <option value="${subject.id}" ${subject.id == param.subjectId ? 'selected' : ''}>
                                    ${subject.name}
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <div class="col-md-4">
                    <label for="date_filter" class="form-label">Date:</label>
                    <input type="date" id="date_filter" name="dateStr" value="${dateStr}" class="form-control"/>
                </div>

                <div class="col-md-4">
                    <label class="form-label" style="visibility: hidden;">Filter</label>
                    <button type="submit" class="btn btn-primary w-100">Filter</button>
                </div>
            </div>
        </form:form>
    </div>

    <form:form method="get" action="${formAction}" class="form-inline">
        <div class="form-group mb-2 d-flex align-items-center">
            <label for="pageSize" class="mr-2">Count elements:</label>
            <select id="pageSize" name="pageSize" class="form-control" onchange="this.form.submit()" style="width: auto;">
                <option value="10" ${pageSize == 10 ? 'selected' : ''}>10</option>
                <option value="20" ${pageSize == 20 ? 'selected' : ''}>20</option>
                <option value="50" ${pageSize == 50 ? 'selected' : ''}>50</option>
            </select>
        </div>
        <input type="hidden" name="page" value="${currentPage}">
    </form:form>

    <div class="container mt-4">
        <h2>Grades List</h2>
            <ul class="list-group">
                <c:if test="${empty grades}">
                    <li class="list-group-item text-center">
                        <strong>No grades yet</strong>
                    </li>
                </c:if>
                <c:forEach var="grade" items="${grades}">
                    <c:url var="editButton" value="/teacher/grades/edit/">
                        <c:param name="id" value="${grade.id}"/>
                    </c:url>
                    <c:url var="deleteButton" value="/teacher/grades/delete/">
                        <c:param name="id" value="${grade.id}"/>
                    </c:url>
                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-3">
                                <strong>Student:</strong> ${grade.student.firstName} ${grade.student.lastName}
                            </div>
                            <div class="col-md-2">
                                <strong>Subject:</strong> ${grade.subject.name}
                            </div>
                            <div class="col-md-2">
                                <strong>Date:</strong> ${grade.date}
                            </div>
                            <div class="col-md-1">
                                <strong>Grade:</strong> ${grade.grade}
                            </div>
                            <div class="col-md-2">
                                <strong>Comment:</strong> ${grade.comment}
                            </div>
                            <div class="col-md-2">
                                <security:authorize access="hasRole('TEACHER')">
                                        <button type="button" class="btn btn-info btn-sm" onclick="window.location.href='${editButton}'">Edit</button>
                                        <button type="button" class="btn btn-danger btn-sm" onclick="window.location.href='${deleteButton}'">Delete</button>
                                </security:authorize>
                                <security:authorize access="hasRole('STUDENT')">
                                        <strong>Teacher:</strong> ${grade.teacher.firstName} ${grade.teacher.lastName}
                                </security:authorize>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
                <security:authorize access="hasRole('TEACHER')">
                    <c:url var="previousUrl" value="/teacher/grades">
                        <c:param name="page" value="${currentPage - 1}" />
                        <c:param name="pageSize" value="${pageSize}" />
                    </c:url>
                    <c:url var="nextUrl" value="/teacher/grades">
                        <c:param name="page" value="${currentPage + 1}" />
                        <c:param name="pageSize" value="${pageSize}" />
                    </c:url>
                </security:authorize>
                <security:authorize access="hasRole('STUDENT')">
                    <c:url var="previousUrl" value="/student/grades">
                        <c:param name="page" value="${currentPage - 1}" />
                        <c:param name="pageSize" value="${pageSize}" />
                    </c:url>
                    <c:url var="nextUrl" value="/student/grades">
                        <c:param name="page" value="${currentPage + 1}" />
                        <c:param name="pageSize" value="${pageSize}" />
                    </c:url>
                </security:authorize>
            <div>
                <button class="btn btn-primary" onclick="window.location.href='${previousUrl}'" ${currentPage == 0 ? 'disabled' : ''}>Previous</button>
                <button class="btn btn-primary" onclick="window.location.href='${nextUrl}'">Next</button>
            </div>
    </div>

    <security:authorize access="hasRole('TEACHER')">
        <div class="card p-4 mt-4">
            <h3 class="mb-3 text-center">Add New Grade</h3>
            <form:form action="${pageContext.request.contextPath}/teacher/grades/save" method="post" modelAttribute="gradeOutDTO">
                <input type="hidden" name="id" value="${gradeOutDTO.id}"/>
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
