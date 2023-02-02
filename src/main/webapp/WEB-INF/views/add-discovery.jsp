<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj filmik - TopVideo</title>
    <%@include file="../segments/stylesheets.jspf"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/add-discovery-forms.css">
</head>
<body>
    <div class="container">
        <%@include file="../segments/header.jspf"%>

        <form action=""${pageContext.request.contextPath}/discovery/add"" method="post" class="discovery-form">
            <h2 class="discovery-form-title">Dodaj nowy filmik</h2>
            <input name="title" placeholder="Tytuł" required>
            <input name="url" placeholder="URL" type="url" required>
            <select name="categoryId">
                <c:forEach var="category" items="${requestScope.categories}">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </select>
            <textarea name="description" placeholder="Opis"></textarea>
            <button class="discovery-form-button">Dodaj</button>
        </form>
        
        <%@include file="../segments/footer.jspf"%>
    </div>

</body>
</html>
