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
            <div class="item-center">Something to do with the transport company</div>
            <div class="item">Выход</div>
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
                    <th>${cast.route.number}</th>
                    <th>${cast.type.description}</th>
                    <th>${cast.model.description}</th>
                    <th>${cast.transport.regPlate}</th>
                    <th>${cast.driver.fullName}</th>
                    <th>${cast.conductor.fullName}</th>
                    <th>${cast.startTime.toLocalDate()}</th>
                    <th>${cast.startTime.toLocalTime()}</th>
                    <th>${cast.endTime.toLocalTime()}</th>
                </tr>
            </c:forEach>
        </table>
    </div>
    </body>
</html>