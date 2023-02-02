<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>TopVideos</title>
    <%@include file="../segments/stylesheets.jspf"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/user-profile.css">
</head>
<body>
<div class="container">
    <%@include file="../segments/header-userprofile.jspf"%>

    <main>

        <div class="profile-inline">
            <div>
                <i class="fas fa-duotone fa-user fa-5x"></i>
            </div>
            <div>
                <table class="tabele">
                    <thead>
                    <tr>
                        <th colspan="2">Dane użytkownika</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Nazwa użytkownika</td>
                        <td>${requestScope.profile_data.username}</td>
                    </tr>
                    <tr>
                        <td>emial</td>
                        <td>${requestScope.profile_data.email}</td>
                    </tr>
                    <tr>
                        <td>Data założenia konta</td>
                        <td>${requestScope.profile_data.registrationDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))}</td>
                    </tr>
                    <tr>
                        <td>Ilośc dodanych znalezisk</td>
                        <td>${requestScope.profile_data.numberOfDiscoveriesAdded}</td>
                    </tr>
                    <tr>
                        <td>Symaryczna ocena znalezlisk</td>
                        <td>${requestScope.votes}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <%@include file="../segments/discovery-list.jspf"%>
    </main>
    <%@include file="../segments/footer.jspf"%>
</div>
</body>
</html>