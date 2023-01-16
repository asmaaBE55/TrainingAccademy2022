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

<div class="container">
    <form action="${pageContext.request.contextPath}/addProject" method="post">
        <div class="mb-3">
            <label for="exampleInputEmail2" class="form-label">Nome</label>
            <input type="text" name="nome" class="form-control" id="exampleInputEmail2" aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword2" class="form-label">Descrizione</label>
            <input type="text" name="descrizione" class="form-control" id="exampleInputPassword2">
        </div>
        <button type="submit" class="btn btn-primary">Salva progetto</button>
    </form>
</div>
<br>
<footer class="footer mt-auto py-3 bg-light">
    <div class="container">
        <span class="text-muted">Prova</span>
    </div>
</footer>
</body>
<jsp:include page="scriptJS.jsp"></jsp:include>