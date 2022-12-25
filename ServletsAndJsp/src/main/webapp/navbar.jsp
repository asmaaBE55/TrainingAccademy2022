<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>


<header>
  <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #50788b">

    <ul class="navbar-nav">
      <li><a href="<%=request.getContextPath()%>/"  class="nav-link ${param.home}">Home</a></li>
      <li><a href="<%=request.getContextPath()%>/ServletInserUser" class="nav-link ${param.inserimento}">Inserisci Utente</a></li>
      <li><a href="<%=request.getContextPath()%>/ServletShowUsers" class="nav-link ${param.list}">Mostra  Utenti</a></li>
    </ul>
  </nav>
</header>
<br>