<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zarejestruj się - TopVideo</title>
  <%@include file="../segments/stylesheets.jspf"%>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/forms.css">
</head>
<body>
  <div class="container">
    <%@include file="../segments/header.jspf"%>

    <form action="${pageContext.request.contextPath}/signup" method="post" class="user-form">
      <h2 class="user-form-title">Zarejestruj się na TopVideo</h2>
      <input name="username" placeholder="Nazwa użytkownika" required>
      <input name="email" placeholder="email" type="email" required>
      <input name="password" placeholder="Hasło" type="password" required>
      <button class="user-form-button">Zarejestruj się</button>
    </form>

    <%@include file="../segments/footer.jspf"%>
  </div>

</body>
</html>
