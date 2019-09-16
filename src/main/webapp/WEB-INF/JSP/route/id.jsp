<!DOCTYPE html>
<html>
    <head>
        <title>Маршрут №1</title>
        <link href="../css/id.css" rel="stylesheet" type="text/css"><meta charset="utf-8"/>
    </head>

    <body>
        <div class="header">
            <div class="item"></div>
            <div class="item-center">Something to do with the transport company</div>
            <div class="item"></div>
        </div>
        <div class="center">
            <table width=100%>
                <tbody>
                    <tr>
                        <td width=50%>
                            <table class="route-table">
                                <tbody>
                                    <c:forEach var="stop" items="${route-forward}">
                                        <div>${stop.name}</div>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </td>
                        <td width=50%>
                            <table class="route-table">
                                <tbody>
                                    <c:forEach var="stop" items="${route-back}">
                                        <div>${stop.name}</div>
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