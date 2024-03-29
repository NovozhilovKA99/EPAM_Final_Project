<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Work</title>
        <link href="../CSS/work.css" rel="stylesheet" type="text/css"><meta charset="utf-8"/>
    </head>

    <body>
        <div class="header">
            <div class="item"></div>
            <c:if test = "${user.position.equals('admin')}">
                <a href="/home/add"><div class="item">Добавить смену</div></a>
            </c:if>
            <div class="item-center">Something to do with the transport company</div>
            <div class="item"><a href="/logout">Выход</a></div>
        </div>
    <div class = "center">
        <table>
            <tr>
                <th>Маршрут</th>
                <th>Транспорт</th>
                <th>Модель</th>
                <th>Номер транспорта</th>
                <th>Водитель</th>
                <th>Кондуктор</th>
                <th>Дата</th>
                <th>Начало смены</th>
                <th>Конец смены</th>
            </tr>
            <c:forEach var="cast" items="${casts}">
                <tr>
                    <td>${cast.getRouteDB().getNumber()}</td>
                    <td>${cast.getType().getDescription()}</td>
                    <td>${cast.getModel().getDescription()}</td>
                    <td>${cast.getTransport().getRegPlate()}</td>
                    <td>${cast.getDriver().getFullName()}</td>
                    <td>${cast.getConductor().getFullName()}</td>
                    <td>${cast.getStartTime().toLocalDate()}</td>
                    <td>${cast.getStartTime().toLocalTime()}</td>
                    <td>${cast.getEndTime().toLocalTime()}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    </body>
</html>