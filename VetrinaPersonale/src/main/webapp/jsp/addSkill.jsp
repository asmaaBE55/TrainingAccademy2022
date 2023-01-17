<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<form action="${pageContext.request.contextPath}/addSkillForm" method="post">
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Nome</label>
        <input type="text" name="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Descrizione</label>
        <input type="text" name="description" class="form-control" id="exampleInputPassword1">
    </div>
    <div class="mb-3">
        <label for="categorySelect" class="form-label">Categoria</label>
        <select name="category" class="form-control" id="categorySelect">
            <option value="" disabled selected>Selziona una categoria</option>
            <c:forEach var="category" items="${categories}">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>
    </div>

<input type="submit" value="Salva" />
<jsp:include page="scriptJS.jsp"></jsp:include>