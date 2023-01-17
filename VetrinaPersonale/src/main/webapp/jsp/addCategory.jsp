<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<jsp:include page="head.jsp"></jsp:include>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<c:if test="${operation == true}">
<div class="alert alert-success" role="alert">
    ok
</div>
</c:if>
<form action="${pageContext.request.contextPath}/insertCategory" method="post">
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Nome</label>
        <input type="text" name="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    <div class="mb-3">
        <label for="skillSelect" class="form-label">Skills</label>
        <select name="category" class="form-control" id="skillSelect">
            <option value="" disabled selected>Selziona skills</option>
            <c:forEach var="skill" items="${skills}">
                <option value="${skill.name}">${skill.description}</option>
            </c:forEach>
        </select>
    </div>
        <div class="mb-3">
            <label for="projectSelect" class="form-label">Skills</label>
            <select name="category" class="form-control" id="projectSelect">
                <option value="" disabled selected>Selziona progetti</option>
                <c:forEach var="project" items="${projects}">
                    <option value="${project.name}">${project.description}</option>
                </c:forEach>
            </select>
        </div>

    <input type="submit" value="Salva" />
<jsp:include page="scriptJS.jsp"></jsp:include>