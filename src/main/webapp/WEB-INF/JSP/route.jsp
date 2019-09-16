<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Маршруты</title>
        <link href="../css/routes.css" rel="stylesheet" type="text/css"><meta charset="utf-8"/>
    </head>

    <body>
        <div class="header">
            <div class="item"></div>
            <div class="item-center">Маршруты</div>
            <div class="item"></div>
        </div>
        <div class="center">
            <div class="grid">
                <c:forEach var="route" items="${routes}">
                    <div><a href="/route/${route.number}">${route.number}</a></div>
                </c:forEach>
            </div>
        </div>
        <div class="footer">
                <div class="item"></div>
                <div class="item-center">Транспортная Компания "Транспортная компания"</div>
                <div class="item">Вход для сотрудников</div>
        </div>
    </body>
</html>