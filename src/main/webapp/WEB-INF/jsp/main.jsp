<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="utf-8">
    <title>Главная</title>
    <link href="../css/Common.css" rel="stylesheet" type="text/css">

</head>
<body>
    <c:choose>
        <c: when  test="${user == null}">
            <div class = "left">
                <a href = "/login">Войти</a>
            </div>
            <div class = "center">
                <c:forEach var="type" items="${types}">
                    <div class = "typeField"> $type.description </div>
                </c:forEach>
            </div>
        </c: when>
        <c: otherwise>
            <div class = "right">
                <a href = "/main" style="float:right">Главная</a>
                <a href = "/exit" style="float:right">Выход</a>
            </div>
            <div class = "center">

            </div>
        </c: otherwise>
    </c:choose>
</body>
</html>