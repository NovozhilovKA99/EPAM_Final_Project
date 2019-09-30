<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Маршрут №1</title>
        <link href="../CSS/id.css" rel="stylesheet" type="text/css"><meta charset="utf-8"/>
    </head>

    <body>
        <div class="header">
            <a href="/route"><div class="item">Главная</div></a>
            <div class="item-center">Something to do with the transport company</div>
            <div class="item"></div>
        </div>
        <div class="center">
            <table width=100%>
                <tbody>
                    <tr>
                        <td width=50%>
                            <table class="route-table" color="black">
                                <tbody>
                                    <c:forEach var="stop" items="${routeForward}">
                                        <tr>
                                            <td>${stop.name}</td>
                                            <td>${stop.indexRoute}</td>
                                            <td>
                                                <c:if test="${transport.get(stop)!=null}">
                                                    Транспорт
                                                </c:if>

                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </td>
                        <td width=50%>
                            <table class="route-table">
                                <tbody>
                                    <c:forEach var="stop" items="${routeBack}">
                                        <tr>
                                            <td>${stop.name}</td>
                                            <td>${stop.indexRoute}</td>
                                            <td>
                                                <c:if test="${transport.get(stop)!=null}">
                                                    Транспорт
                                                </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="footer">
                <div class="item"></div>
                <div class="item-center">Транспортная Компания "Транспортная компания"</div>
                <div class="item">Вход для сотрудников</div>
        </div>
    </body>
</html>